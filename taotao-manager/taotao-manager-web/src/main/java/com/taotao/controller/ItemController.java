package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
