package com.example.demo.entity;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

import org.springframework.lang.Nullable;
import jakarta.annotation.Nonnull;

public class Item {
      @Nullable
      private Long   id;
      @Nonnull
      private String name;
      @Nonnull
      private int available;
     @Nonnull
      private String description;
      @Nullable
      Timestamp createdAt;

      public Item(Long id, String name, Timestamp createdAt, int available,String description) {
            this.id = id;
            this.name = name;
            this.createdAt = Timestamp.from(Instant.now());
            this.available = available;
            this.description = description;
      }

      public Item() {
      }
      @Nullable
      public Long getId() {
            return id;
      }
      public void setId(@Nullable Long id) {
            this.id = id;
      }
      public String getName() {
            return name;
      }
      public void setName(String name) {
            this.name = name;
      }
      public Timestamp getCreatedAt() {
            return createdAt;
      }
      public void setCreatedAt(Timestamp createdAt) {
            this.createdAt = createdAt;
      }
      public int getAvailable() {
            return available;
      }
      public void setAvailable(int available) {
            this.available = available;
      }
    
      public String getDescription() {
            return description;
      }
      public void setDescription(String description) {
            this.description = description;
      }

      @Override
      public int hashCode() {
            return Objects.hash(id, name, available, description, createdAt);
      }

      @Override
      public boolean equals(Object obj) {
            if (this == obj)
                  return true;
            if (!(obj instanceof Item))
                  return false;
            Item other = (Item) obj;
            return Objects.equals(id, other.id) && Objects.equals(name, other.name) && available == other.available
                        && Objects.equals(description, other.description) && Objects.equals(createdAt, other.createdAt);
      }
}
