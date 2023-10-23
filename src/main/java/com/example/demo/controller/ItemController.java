package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.service.api.ItemService;
import com.example.demo.db.service.api.request.UpdateItemRequest;
import com.example.demo.entity.Item;

@RestController 
@RequestMapping("item")
public class ItemController {

      ItemService itemService;
 
      public ItemController(ItemService itemService) {
            this.itemService = itemService;
      }

      // @RequestMapping("/")
      // public Sklad index(){
      //       Sklad sklad = new Sklad("", 20);
      //       return sklad;
      // }
      // @RequestMapping("/index")
      // public String index(){
      //       String s = "Moja prvá Srping Aplikácia";
      //       return s;
      // }

      @PostMapping
      public ResponseEntity add(@RequestBody Item item){
            Integer id = itemService.add(item);
            if(id != null){
                  return new ResponseEntity<>(id, HttpStatus.CREATED);
            }else{
                  return new ResponseEntity<>(null ,HttpStatus.INTERNAL_SERVER_ERROR);
            }
      }

      @GetMapping
      public ResponseEntity allItems(){
            List<Item> itemList = itemService.getAllItems();
            return new ResponseEntity<>(itemList,HttpStatus.OK);
      }
      @GetMapping("{id}")
      public ResponseEntity get(@PathVariable("id") int id){
            Item item = itemService.getItemm(id);
            if(item ==null){
                  return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }else{
                  return new ResponseEntity<>(item, HttpStatus.OK);
            }
      }

      @PatchMapping("{id}")
      public ResponseEntity update(@PathVariable("id") int id, @RequestBody UpdateItemRequest request){
            if(itemService.getItemm(id)!= null){
                  itemService.update(id, request);
                  return ResponseEntity.ok().build();
            }else{
                  return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Item whit id : "+id+" doest not exist .");

            }
      }

      @DeleteMapping("{id}")
      public ResponseEntity deleteProduct(@PathVariable("id") int id){
            if(itemService.getItemm(id)!=null){
                  itemService.delete(id);
                  return ResponseEntity.ok().build();
           }else{
             return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Item whit id : "+id+" doest not exist .");
           }
      }
      
}

