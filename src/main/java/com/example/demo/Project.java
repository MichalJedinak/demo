package com.example.demo;

import javax.swing.JLabel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Project {
      @RequestMapping("/")
      public String index(){
            JLabel label = new JLabel( " Moja prvá Srping Aplikácia");
            return label.getText();
      }
 

}
