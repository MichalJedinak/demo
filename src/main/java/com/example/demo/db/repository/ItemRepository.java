package com.example.demo.db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.example.demo.db.mapper.ItemRowMapper;
import com.example.demo.db.service.api.request.UpdateItemRequest;
import com.example.demo.entity.Item;

@Component
public class ItemRepository {

      private final JdbcTemplate jdbcTemplate;
      private final ItemRowMapper itemRowMapper = new ItemRowMapper();
   
      public ItemRepository(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
      }

      public Item getItem(int id){
            final String query = "SELECT * FROM item WHERE id="+id+";";
            try {
                  return jdbcTemplate.queryForObject(query, itemRowMapper);
            } catch (EmptyResultDataAccessException e) {
                  JOptionPane.showMessageDialog(null,e,"SQL eroro",JOptionPane.ERROR_MESSAGE);

                  return null;
            }

      }

      public List<Item> getAllItems(){
            final String query="SELECT * FROM item;";
            return 
            jdbcTemplate.query(query, itemRowMapper);
      }

      public Integer add(Item item){
            final String query = "INSERT INTO item (name,available,description,created_at)VALUE(?,?,?,?);";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {

                  @Override
                  public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement preparedStatement = con.prepareStatement(query);
                        preparedStatement.setString(1, item.getName());
                        preparedStatement.setInt(2,item.getAvailable());
                        preparedStatement.setString(3, item.getDescription());
                        preparedStatement.setTimestamp(4,item.getCreatedAt());
                        return preparedStatement;
                  }
                  
            },keyHolder);

            if(keyHolder.getKey()!=null){
                  return keyHolder.getKey().intValue();
            }else{
                  return null;
            }

      }
      public void delete(int id){
            final String qeury = "DELETE FROM item WHERE id="+id+";";
            jdbcTemplate.update(qeury, id);
      }
      public void update(int id,UpdateItemRequest updateItemRequest){
            final String sql="UPDATE item SET name=? available=? description=? WHERE id="+id+";";
            jdbcTemplate.update(sql,updateItemRequest);
      }
      public void updateAvailableInternal(int id, int available){
            final String sql = "UPDATE item SET available=? WHERE id=?;";
            jdbcTemplate.update(sql, available,id);
      }
      
}
