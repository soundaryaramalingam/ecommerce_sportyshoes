package com.SportyShoesProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SportyShoesProject.Model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{

}
