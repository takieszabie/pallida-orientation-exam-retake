package com.greenfoxacademy.examretakepallida.Repositories;

import com.greenfoxacademy.examretakepallida.Models.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

  @Query("select distinct c.itemName from Item c")
  List<String> findDistinctByItemName();

  @Query("select distinct c.size from Item c")
  List<String> findDistinctBySize();

}