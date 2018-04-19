package com.greenfoxacademy.examretakepallida.Controllers;

import com.greenfoxacademy.examretakepallida.Models.Item;
import com.greenfoxacademy.examretakepallida.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

  @PostMapping(value = "/warehouse/summary")
  public String summary(@ModelAttribute(name = "item") String itemName,
                        @ModelAttribute(name = "size") String sizeNum,
                        @ModelAttribute(name = "amount") int amount,
                        Model model) {
    List<Item> warehouses = itemRepository.findByItemNameAndSize(itemName, sizeNum);
    if (warehouses.size() == 0) {
      return "redirect:/warehouse";
    } else {
      model.addAttribute("itemName", itemName);
      model.addAttribute("sizeNum", sizeNum);
      model.addAttribute("amount", amount);
      model.addAttribute("itemsList", warehouses);
      Item item = warehouses.get(0);
      model.addAttribute("subTotal", amount * item.getUnitPrice());
      return "summary";
    }
  }
}
