package com.greenfoxacademy.examretakepallida.Models;

import javax.persistence.*;

@Entity
@Table(name = "warehouse")
public class Item {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private long id;
  private String itemName;
  private String manufacturer;
  private String category;
  private String size;
  private double unitPrice;

  public Item(String itemName, String manufacturer, String category, String size, double unitPrice) {
    this.itemName = itemName;
    this.manufacturer = manufacturer;
    this.category = category;
    this.size = size;
    this.unitPrice = unitPrice;
  }

  public Item() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }
}
