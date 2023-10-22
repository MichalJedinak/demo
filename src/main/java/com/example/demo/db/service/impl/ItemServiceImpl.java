package com.example.demo.db.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.db.repository.ItemRepository;
import com.example.demo.db.service.api.ItemService;
import com.example.demo.db.service.api.request.UpdateItemRequest;
import com.example.demo.entity.Item;
@Service
public class ItemServiceImpl implements ItemService{

      ItemRepository itemRepository;

      public ItemServiceImpl(ItemRepository itemRepository) {
            this.itemRepository = itemRepository;
      }

      @Override
      public List<Item> getAllItems() {
            return itemRepository.getAllItems();
      }

      @Override
      public Item getItemm(int id) {
            return itemRepository.getItem(id);
      }

      @Override
      public Integer add(Item item) {
            return itemRepository.add(item);
      }

      @Override
      public void delete(int id) {
            itemRepository.delete(id);
      }

      @Override
      public void update(int id, UpdateItemRequest request) {
            itemRepository.update(id,request);
      }

      ////  požiť neskôr  v rozšírení projketu
      @Override
      public void updateAvailableInternal(int id, int available) {
             itemRepository.updateAvailableInternal(id,available);
      }
      
}
