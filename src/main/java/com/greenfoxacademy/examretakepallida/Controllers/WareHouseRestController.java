package com.greenfoxacademy.examretakepallida.Controllers;

import com.greenfoxacademy.examretakepallida.Models.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WareHouseRestController {

  @GetMapping("/warehouse/query")
  public Item sendAnswer(@RequestParam(name = "price") double number, @RequestParam(name = "type") String typedesc){
    //tobefilled yet
    return new Item();
  }

}
