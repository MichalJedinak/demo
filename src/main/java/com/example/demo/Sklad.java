package com.example.demo;

public class Sklad {
      private long   id;
      private String item_name;
      private int    item_count;

      public Sklad() {
      }

      public Sklad(long id, String item_name, int item_count) {
            this.id = id;
            this.item_name = item_name;
            this.item_count = item_count;
      }
      
      public Sklad(String item_name, int item_count) {
            this.item_name = item_name;
            this.item_count = item_count;
      }

      /**
       * @return the id
       */
      public long getId() {
            return id;
      }

      /**
       * @param id the id to set
       */
      public void setId(long id) {
            this.id = id;
      }

      /**
       * @return the item_name
       */
      public String getItem_name() {
            return item_name;
      }

      /**
       * @param item_name the item_name to set
       */
      public void setItem_name(String item_name) {
            this.item_name = item_name;
      }

      /**
       * @return the item_count
       */
      public int getItem_count() {
            return item_count;
      }

      /**
       * @param item_count the item_count to set
       */
      public void setItem_count(int item_count) {
            this.item_count = item_count;
      }


      
}
