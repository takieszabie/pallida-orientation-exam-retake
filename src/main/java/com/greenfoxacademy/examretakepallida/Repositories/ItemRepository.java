package com.greenfoxacademy.examretakepallida.Repositories;

import com.greenfoxacademy.examretakepallida.Models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
