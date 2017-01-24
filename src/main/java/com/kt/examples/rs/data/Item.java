package com.kt.examples.rs.data;

import java.io.Serializable;

public class Item implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private String code;
  private String label;
  
  public Item() {
    super();
  }
  public Item(String code, String label) {
    super();
    this.code = code;
    this.label = label;
  }
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getLabel() {
    return label;
  }
  public void setLabel(String label) {
    this.label = label;
  }
}
