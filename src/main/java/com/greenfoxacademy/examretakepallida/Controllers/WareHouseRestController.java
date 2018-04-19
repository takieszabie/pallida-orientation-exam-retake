package com.greenfoxacademy.examretakepallida.Controllers;

import com.greenfoxacademy.examretakepallida.Models.JsonResponse;
import com.greenfoxacademy.examretakepallida.Models.Item;
import com.greenfoxacademy.examretakepallida.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WareHouseRestController {

  @Autowired
  ItemRepository itemRepository;

  @GetMapping("/warehouse/query")
  public ResponseEntity sendItemList (@RequestParam(name = "price") int number, @RequestParam(name = "type") String typedesc){
    if(typedesc.equals("equal")){
      return new ResponseEntity(new JsonResponse("ok", itemRepository.findByUnitPriceEquals(number)), HttpStatus.OK);
    } else if(typedesc.equals("lower")){
      return new ResponseEntity(new JsonResponse("ok", itemRepository.findByUnitPriceIsLessThan(number)), HttpStatus.OK);
    } else if(typedesc.equals("higher")){
      return new ResponseEntity(new JsonResponse("ok", itemRepository.findByUnitPriceIsGreaterThan(number)), HttpStatus.OK);
    } else return null;
  }

}
