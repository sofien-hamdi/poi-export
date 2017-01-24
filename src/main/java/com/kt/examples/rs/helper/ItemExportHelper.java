package com.kt.examples.rs.helper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kt.examples.rs.data.Item;

public class ItemExportHelper {
  
  public static byte[] buildItemsDocument(List<Item> list) {
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet worksheet = workbook.createSheet("POI Worksheet");

    XSSFRow row;
    int rowid = 0;
    for (Item item : list) {
      row = worksheet.createRow(rowid++);
      
      Cell cell0 = row.createCell(0);
      cell0.setCellValue(item.getCode());

      Cell cell1 = row.createCell(1);
      cell1.setCellValue(item.getLabel());
    }

    return workBookToByteArray(workbook);
  }

  private static byte[] workBookToByteArray(XSSFWorkbook workbook) {
    byte[] docAsByteArray = new byte[0];
    
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try {
      workbook.write(bos);
      docAsByteArray = bos.toByteArray();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    try {
      bos.close();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    return docAsByteArray;
  }
}
