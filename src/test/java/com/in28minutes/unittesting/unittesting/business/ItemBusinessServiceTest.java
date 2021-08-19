package com.in28minutes.unittesting.unittesting.business;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

	@Mock
	ItemRepository repo;

	@InjectMocks
	ItemBusinessService business;

	@Test
	void testRetreiveHardcodedItem() {
		ItemBusinessService businessService = new ItemBusinessService();
		Item item = businessService.retreiveHardcodedItem();
		assertNotNull(item);
		Item i1 = new Item(1, "Ball", 10, 100);
		assertEquals(i1.toString(), item.toString());

	}

	@Test
	void testRetrieveAllItems() {
		when(repo.findAll()).thenReturn(Arrays.asList(new Item(2, "bat", 20, 200)));
		business.retrieveAllItems();
	}

	@Test
	void testSaveItem() {
		Item i1 = new Item(4, "bkvjfk", 40, 400);
		when(repo.save(i1)).thenReturn(i1);
		Item saved = null;
		try {
			saved = business.saveItem(i1);
		} catch (ParameterMissingException e) {
			e.printStackTrace();
		}
		assertEquals("item2",saved.getName());
	}

	@Test
	void testRetrieveAllItemsWithZeroItemsRetrieved() {
		when(repo.findAll()).thenReturn(Arrays.asList());
		business.retrieveAllItems();

	}

	@Test
	void testUpdateItem() {
		Optional<Item> i1 = Optional.of(new Item(2,"kdnnd",20,200));
		when(repo.findById(2)).thenReturn(i1);
		Item item=business.updateItem(2);
		assertNotEquals(i1.get().getName(), item.getName());
	}
	
	
	
	@Test 
	void TestItemWithNoName() {
		Item i1= new Item(5,null,90,678);
		Item saved=null;
		when(repo.save(i1)).thenReturn(i1);
		try {
			 saved = business.saveItem(i1);		
		}
		catch(ParameterMissingException e) {
			assertNotNull(e);
			assertEquals(ParameterMissingException.class,e.getClass(),"parameter missing");	
		};
	}

}
