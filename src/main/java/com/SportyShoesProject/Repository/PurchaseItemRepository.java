package com.SportyShoesProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SportyShoesProject.Model.CartItem;
import com.SportyShoesProject.Model.PurchaseItem;

@Repository
public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long>{

	@Query(value = "SELECT * FROM purchase_items p WHERE p.purchase_id = ?1", nativeQuery = true)
	public List<PurchaseItem> getOrderBypurchaseId(Long purchase_id);
}
