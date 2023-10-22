package com.example.demo.db.service.api.request;

import java.util.Objects;

import io.micrometer.common.lang.NonNull;

public class UpdateItemRequest {
      @NonNull
      private String name;
      @NonNull
      private String description;
      @NonNull
      private int available;

      public UpdateItemRequest(String name, String description, int available) {
            this.name = name;
            this.description = description;
            this.available = available;
      }

      public String getName() {
            return name;
      }
      public String getDescription() {
            return description;
      }
      public int getAvailable() {
            return available;
      }
      @Override
      public int hashCode() {
            return Objects.hash(name, description, available);
      }
      @Override
      public boolean equals(Object obj) {
            if (this == obj)
                  return true;
            if (!(obj instanceof UpdateItemRequest))
                  return false;
            UpdateItemRequest other = (UpdateItemRequest) obj;
            return Objects.equals(name, other.name) && Objects.equals(description, other.description)
                        && available == other.available;
      }
      
}
