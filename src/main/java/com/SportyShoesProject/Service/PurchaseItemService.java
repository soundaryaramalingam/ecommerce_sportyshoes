package com.SportyShoesProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.SportyShoesProject.Model.CartItem;
import com.SportyShoesProject.Model.PurchaseItem;
import com.SportyShoesProject.Repository.PurchaseItemRepository;

import jakarta.transaction.Transactional;

@Service
public class PurchaseItemService {

	 @Autowired
	 private PurchaseItemRepository purchaseItemrepo;

		
		
		public void saveOrder(PurchaseItem list){
			purchaseItemrepo.save(list);
		}


		public PurchaseItem getOrderById(Long userId) {
			// TODO Auto-generated method stub
			return purchaseItemrepo.findById(userId).get();
		}

		public List<PurchaseItem> getOrderBypurchaseId(Long uuid) {
			
			var purchase=(List<PurchaseItem>) purchaseItemrepo.getOrderBypurchaseId(uuid);
			return purchase;
		}
	
		

}