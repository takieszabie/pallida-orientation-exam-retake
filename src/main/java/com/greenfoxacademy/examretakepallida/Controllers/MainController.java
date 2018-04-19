package com.greenfoxacademy.examretakepallida.Controllers;

import com.greenfoxacademy.examretakepallida.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @Autowired
  ItemRepository itemRepository;

  @GetMapping("/warehouse")
  public String renderWareHouse(){
    //tobefilled yet
    return "warehouse";
  }
}
