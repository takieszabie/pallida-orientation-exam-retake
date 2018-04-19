package com.greenfoxacademy.examretakepallida.Controllers;

import com.greenfoxacademy.examretakepallida.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @Autowired
  ItemRepository itemRepository;

  @GetMapping("/shoppingplanner")
  public String renderShoppingPlanner(){
    //tobefilled yet
    return "shoppingplanner";
  }

  @GetMapping("/warehouse")
  public String renderWarehouse(Model model){
    model.addAttribute("items", itemRepository.findAll());
    return "warehouse";
  }
}
