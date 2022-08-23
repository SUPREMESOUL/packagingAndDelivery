package com.packagingAndDelivery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packagingAndDelivery.service.PackageDeliveryCalculator;

@RestController
public class AllController {
	
	@Autowired
	public PackageDeliveryCalculator calculator;
	
	@GetMapping(path="/packdelivery")
	public ResponseEntity<Double> getAllCharges(String componentType , int quantity){
		  double total= calculator.GetPackageAndDeliveryCharge(componentType, quantity);
		  
		return new ResponseEntity<>(total,HttpStatus.OK);
		
	}

}
