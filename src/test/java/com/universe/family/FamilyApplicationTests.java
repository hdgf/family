package com.universe.family;

import com.universe.family.model.cronous.shop.WebNews;
import com.universe.family.model.cronous.shop.WebNewsRepository;
import com.universe.family.utils.PageableTools;
import com.universe.family.utils.SortDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyApplicationTests {

	@Autowired
	private WebNewsRepository webNewsRepository;

	@Test
	public void contextLoads() {
		Pageable pageable =new PageRequest(0, 10);
		Page<WebNews> datas = webNewsRepository.findAll(pageable);
		System.out.println("总条数："+datas.getTotalElements());
		System.out.println("总页数："+datas.getTotalPages());
		for(WebNews u : datas) {
			System.out.println(u.getId()+"====" + u.getTitle());
		}
	}

	private void print(Page<WebNews> datas) {
		System.out.println("总条数："+datas.getTotalElements());
		System.out.println("总页数："+datas.getTotalPages());
		for(WebNews u : datas) {
			System.out.println(u.getId()+"===="+u.getTitle() + ", time:" + u.getTime() + ", type:" + u.getType());
		}
	}

	@Test
	public void test2() {
		Page<WebNews> datas = webNewsRepository.findAll(PageableTools.basicPage(0));
		print(datas);
	}

	@Test
	public void test3() {
		Page<WebNews> datas = webNewsRepository.findAll(PageableTools.basicPage(1, 5));
		print(datas);
	}

	@Test
	public void test4() {
		Page<WebNews> datas = webNewsRepository.findAllByType("系统公告", PageableTools.basicPage(1, 5, new SortDto("time")));
		print(datas);

		//Page<WebNews> datas2 = webNewsRepository.findAll(PageableTools.basicPage(1, 5, new SortDto("DESC", "time")));
		//print(datas2);
	}
}
