package com.taotao.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class TestCase {
	
	@Test
	public void testPageHelper(){
		//创建一个Spring容器
		ApplicationContext application = new ClassPathXmlApplicationContext
				("classpath:spring/applicationContext-*.xml");
		//从spring容器中获取Mapper代理对象
		TbItemMapper mapper = application.getBean(TbItemMapper.class);
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(1,10);
		List<TbItem> list = mapper.selectByExample(example);
		for (TbItem item:list) {
			System.out.println(item.getTitle());
		}
		if(list instanceof Page){
			System.out.println("page");
			System.out.println("size:"+list.size());
		}
		long total = new PageInfo<TbItem>(list).getTotal();
		System.out.println("共有商品"+total+"件");
		
	}
}
