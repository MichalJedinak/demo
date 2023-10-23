package com.example.demo.db.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.entity.Item;

public class ItemRowMapper  implements RowMapper<Item> {

      @Override      
      public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setName(rs.getString("name"));
            item.setAvailable(rs.getInt("available"));
            item.setDescription(rs.getString("description"));
            item.setCreatedAt(rs.getTimestamp("created_at"));
            return item;
      }
      
}
