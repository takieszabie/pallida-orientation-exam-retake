package com.greenfoxacademy.examretakepallida.Models;

import java.util.List;

public class JsonResponse {
  private String result;
  private List<Item> warehouseList;

  public JsonResponse() {
  }

  public JsonResponse(String result) {
    this.result = result;
  }

  public JsonResponse(String result, List<Item> warehouseList) {
    this.result = result;
    this.warehouseList = warehouseList;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public List<Item> getWarehouseList() {
    return warehouseList;
  }

  public void setWarehouseList(List<Item> warehouseList) {
    this.warehouseList = warehouseList;
  }
}