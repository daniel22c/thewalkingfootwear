package com.thewalking.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.thewalking.controller.CategoryRestController;
import com.thewalking.jpa.CategoryService;
import com.thewalking.model.Category;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.ArrayList;
//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryBusinessTest {
	@Mock
	CategoryService categoryService;
	@InjectMocks
	CategoryRestController categoryRestController; 
	
	@Test
	public void testFindAllCategory() {
		List<Category> list = new ArrayList<Category>();
		list.add(new Category(1,"Lady's shoes"));
		list.add(new Category(2,"Girl's shoes"));
		list.add(new Category(3,"Accessories-Jewelry"));
		when(categoryService.all()).thenReturn(list);
		
		assertEquals(3, categoryRestController.findAllCategory().size());
	}
}
