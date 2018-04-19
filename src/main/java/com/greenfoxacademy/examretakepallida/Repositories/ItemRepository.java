package com.greenfoxacademy.examretakepallida.Repositories;

import com.greenfoxacademy.examretakepallida.Models.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

  @Query("select distinct c.itemName from Item c")
  List<String> findDistinctByItemName();

  @Query("select distinct c.size from Item c")
  List<String> findDistinctBySize();

  @Query("select c from Item c where c.itemName like :itemName and c.size like :itemSize")
  List<Item> findByItemNameAndSize(@Param("itemName") String itemNameInput, @Param("itemSize") String itemSizeInput);

}