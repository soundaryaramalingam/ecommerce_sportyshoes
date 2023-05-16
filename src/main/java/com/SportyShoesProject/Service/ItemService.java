package com.SportyShoesProject.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoesProject.Model.Shoes;
import com.SportyShoesProject.Repository.ItemRepository;


@Service
public class ItemService {

	@Autowired
	ItemRepository itemrepo;
	
	public List<Shoes> GetAllItems() {
		List<Shoes> itemlist = itemrepo.findAll();
        System.out.println("ItemList "+itemlist.size());
       if(itemlist.size() > 0) {
       	System.out.println("FOUND DATA");
           return itemlist;
       } 
       else {
       	return null;
       }
	}
	
	public Shoes getItem(Long product_id) {
		Optional<Shoes> itemlist = itemrepo.findById(product_id);
		if(itemlist.isPresent()) {
			System.out.println(itemlist.get());
			 return itemlist.get();
		 }
		 else {
			 System.out.println("null");
			 return null;
		 }
	}

	public void save(Shoes shoe) {
		itemrepo.save(shoe);
		
	}

	public void deleteItem(Long product_id) {
		itemrepo.deleteById(product_id);
	}
	
		
	

}
