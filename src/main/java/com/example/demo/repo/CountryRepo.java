package com.example.demo.repo;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Country;



public interface CountryRepo extends JpaRepository<Country, Integer> {
	 @Query("SELECT c.id, c.name from Country c")
	    List<Object[]> findCountry();
}
