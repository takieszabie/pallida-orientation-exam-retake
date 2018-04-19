package com.greenfoxacademy.examretakepallida.Controllers;

import com.greenfoxacademy.examretakepallida.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

  @Autowired
  ItemRepository itemRepository;


  @GetMapping("/warehouse")
  public String renderWarehouse(Model model){
    model.addAttribute("itemNames",itemRepository.findDistinctByItemName());
    model.addAttribute("sizes", itemRepository.findDistinctBySize());
    model.addAttribute("items", itemRepository.findAll());
    return "warehouse";
  }

  @PostMapping("/warehouse/summary")
  public String renderSummary(){

    return "summary";
  }
}
