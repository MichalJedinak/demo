package com.example.demo.skladconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class SkladJdbc {

      public SkladJdbc(){
            showValueFromDatabaseTableSklad();
      }
      public static void main(String[] args) {
            new SkladJdbc();
      }
      public static void showValueFromDatabaseTableSklad(){
            try {
                  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sklad", "root", "show_pussy8squirrel~hairy");
                  java.sql.Statement statement =connection.createStatement();
                  ResultSet resulset = statement.executeQuery("SELECT * FROM warehouse");
               
                  while(resulset.next()){                     
                      int id= resulset.getInt(1);  
                      String idString = String.valueOf(id);
                      String item_name = resulset.getString(2);
                      int count = resulset.getInt(3);
                      String item_count = String.valueOf(count);              
                      
                      System.out.println(idString+" "+item_name+" "+item_count);           
                  }   
                  connection.close();
                  statement.close();
                  resulset.close();
            } catch (Exception e) {
                  e.printStackTrace();
                  JOptionPane.showMessageDialog(null, e);;
            }
      }
}

