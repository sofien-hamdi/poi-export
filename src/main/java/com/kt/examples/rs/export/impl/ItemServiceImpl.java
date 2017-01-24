package com.kt.examples.rs.export.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.kt.examples.rs.data.Item;
import com.kt.examples.rs.export.ItemService;
import com.kt.examples.rs.helper.ItemExportHelper;


@Service("itemService")
public class ItemServiceImpl implements ItemService {

  private static final String ITEMS_XL = "items_list.xlsx";

  //call http://localhost:9090/poi-export/items/
  public Response getItems() {
    return Response.ok(ItemExportHelper.buildItemsDocument(getList()))
        .header("Content-Disposition", "attachment; filename=\"" + ITEMS_XL + "\"").build();
  }
  private List<Item> getList() {
    List<Item> list = new ArrayList<Item>();
    list.add(new Item("Code", "Label"));
    for (int i = 1; i < 10; i++) {
      list.add(new Item("c" + i, "l" + i));
    }
    return list;
  }

}

