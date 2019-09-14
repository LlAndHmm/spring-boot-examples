package com.neo.model;

import com.neo.repository.ItemRepository;
import com.neo.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTests {

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void test() throws Exception {
		itemRepository.save(new Item("itemName1", "itemCode1"));
		itemRepository.save(new Item("itemName2", "itemCode2"));
		System.out.println(itemRepository.findItemByItemName("itemName1").getItemCode());
	}

}