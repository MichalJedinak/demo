package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.service.api.ItemService;
import com.example.demo.db.service.api.request.UpdateItemRequest;
import com.example.demo.entity.Item;
@CrossOrigin
@RestController 
@RequestMapping("item")
public class ItemController {

       private  ItemService itemService;
 
      public ItemController(ItemService itemService) {
            this.itemService = itemService;
      }

      @PostMapping( consumes ="application/x-www-form-urlencoded")
      public ResponseEntity<Object> add(@RequestBody Item item){
            Integer id = itemService.add(item);
            if(id != null){
                  return new ResponseEntity<>(id, HttpStatus.CREATED);
            }else{
                  return new ResponseEntity<>(null ,HttpStatus.INTERNAL_SERVER_ERROR);
            }
      }
            @PostMapping(value = "/save")
            public HttpStatus save(@RequestBody Item item){
                  Integer id =     itemService.add(item);
                 if(id != null){
                  return  HttpStatus.CREATED;
            }else{
                  return HttpStatus.INTERNAL_SERVER_ERROR;
            }
            }
            @GetMapping(value = "/items")
            public List<Item> getItems(){            
                  return itemService.getAllItems();
            }
             @PatchMapping("/update/{id}")
             public HttpStatus updateItem(@PathVariable("id") int id, @RequestBody UpdateItemRequest request){
                  if(itemService.getItemm(id)!= null){
                  itemService.update(id, request);
                  return HttpStatus.OK;
            }else{
                  return HttpStatus.PRECONDITION_FAILED;

            }
            }
            @DeleteMapping("/delete/{id}")
            public HttpStatus deleteItem(@PathVariable("id") int id){
                        if(itemService.getItemm(id)!=null){
                              itemService.delete(id);
                              return HttpStatus.OK;
                  }else{
                        return HttpStatus.PRECONDITION_FAILED;
                  }
            }

      @GetMapping
      public ResponseEntity<Object> allItems(){
            List<Item> itemList = itemService.getAllItems();
            return new ResponseEntity<>(itemList,HttpStatus.OK);
      }
      @GetMapping("{id}")
      public ResponseEntity<Object> get(@PathVariable("id") int id){
            Item item = itemService.getItemm(id);
            if(item ==null){
                  return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }else{
                  return new ResponseEntity<>(item, HttpStatus.OK);
            }
      }

     // @PatchMapping("{id}")
       @RequestMapping(value = "/{id}", method = {RequestMethod.PATCH, RequestMethod.PUT})
      public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody UpdateItemRequest request){
            if(itemService.getItemm(id)!= null){
                  itemService.update(id, request);
                  return ResponseEntity.ok().build();
            }else{
                  return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Item whit id : "+id+" doest not exist .");

            }
      }

      @DeleteMapping("{id}")
      public ResponseEntity<Object> deleteProduct(@PathVariable("id") int id){
            if(itemService.getItemm(id)!=null){
                  itemService.delete(id);
                  return ResponseEntity.ok().build();
           }else{
             return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Item whit id : "+id+" doest not exist .");
           }
      }
      
}

