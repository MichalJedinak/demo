package com.example.demo.db.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.db.mapper.ItemRowMapper;
import com.example.demo.entity.Item;

@Component
public class ItemRepository {

      private final JdbcTemplate jdbcTemplate;
      private final ItemRowMapper itemRowMapper = new ItemRowMapper();
   
      public ItemRepository(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
      }

      public List<Item> getAllItems(){
            final String query="SELECT * FROM item;";
            return 
            jdbcTemplate.query(query, itemRowMapper);
      }
      
}
