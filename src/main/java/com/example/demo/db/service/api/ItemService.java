package com.example.demo.db.service.api;

import java.util.List;

import com.example.demo.db.service.api.request.UpdateItemRequest;
import com.example.demo.entity.Item;

import io.micrometer.common.lang.Nullable;

public interface ItemService {

      List<Item> getAllItems();
      @Nullable
      Item getItemm(int  id);
      @Nullable
      Integer add(Item item);// return generated id 
      void delete(int id);
      void update(int id,UpdateItemRequest request);
      void updateAvailableInternal(int id,int available);
      
}
