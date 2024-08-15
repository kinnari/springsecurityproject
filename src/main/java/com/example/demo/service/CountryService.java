package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Country;
import com.example.demo.repo.CountryRepo;

@Service
public class CountryService {
	@Autowired
	private CountryRepo crepo;
	
	public Map<Integer, String> getCountry() {
		 List<Object[]> l = crepo.findCountry();
		 Map<Integer,String> row = new HashMap<>();
         for (Object[] ob : l){
        	 
             Integer key = (Integer)ob[0];
             String value = (String)ob[1];
             row.put(key,value);
         }
         return row;
	}

	public   Country findById(Integer country) {
		// TODO Auto-generated method stub
		return crepo.findById(country).orElse(new Country());
	}
         
}
