package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	@ResponseBody
	@RequestMapping("/item/{itemid}")
	public TbItem getItemById(@PathVariable Long itemid){
		TbItem item = itemService.getItemById(itemid);
		return item;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItem(Integer page,Integer rows){
		System.out.println("list");
		return itemService.getItemList(page, rows);
	}
}



