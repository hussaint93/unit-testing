package com.in28minutes.unittesting.unittesting.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@Component
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository repository;
	


	public void setRepository(ItemRepository repository) {
		this.repository = repository;
	}

	public Item retreiveHardcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	public List<Item> retrieveAllItems() {
		List<Item> items = repository.findAll();
		
		for(Item item:items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		
		return items;	
	}

	

	public Item saveItem(Item i1) throws ParameterMissingException {
		if(i1.getName()==null) {
			throw new ParameterMissingException();
		}
		return repository.save(i1);	
	}

	public Item updateItem(int id) {
			Optional<Item> item = repository.findById(id);
			return new Item(item.get().getId(),"itemupdated",50,500);
	}
	
}
