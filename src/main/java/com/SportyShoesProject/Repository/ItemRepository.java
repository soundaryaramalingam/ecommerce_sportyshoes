package com.SportyShoesProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SportyShoesProject.Model.Shoes;
import com.SportyShoesProject.Model.User;


	@Repository
	public interface ItemRepository extends JpaRepository<Shoes, Long>{
		
	}


