package com.choco.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.choco.demo.model.details;

public interface KhokhoRepository extends JpaRepository <details,Integer>{
	//sports findByusername(String username);
	//named parameter
	@Query("select a from details a where a.fullname=:fullname")
	public List<details>getFieldByData(String fullname);
    
	@Modifying
	@Query("delete from details a  where a.fullname=?1")
	public int deleteFieldByData(String fullname);
	
	@Modifying
	@Query("update details a set a.fullname=?1 where a.playerID=?2")
	public int UpdateFieldByData(String fullname,int playerID);
		/*List<Laptop> findByBrandStartingWith(String prefix);
		List<Laptop> findByBrandEndingWith(String suffix);
		List<Laptop> findByBrand(String Brand);*/


		
	
}