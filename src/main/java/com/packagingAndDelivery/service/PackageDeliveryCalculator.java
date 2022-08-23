package com.packagingAndDelivery.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.packagingAndDelivery.exceptionhandler.InvalidInputDetailsException;



@Service
public class PackageDeliveryCalculator {
	
	
	@Value("${package.packagecostintegral}")
private int packagecostintegral;
	@Value("${package.packagecostaccessory}")
private int packagecostaccessory;
	@Value("${package.sheatcost}")
private int sheatcost;
	@Value("${package.deliveryintegral}")
private int deliveryintegral;
	@Value("${package.deliveryaccessory}")
private int deliveryaccessory;
	
	public double GetPackageAndDeliveryCharge(String componentType,int quantity ) {
		
		System.out.println(packagecostintegral);
		System.out.println(packagecostaccessory);
		System.out.println(deliveryintegral);
		System.out.println(deliveryaccessory);
		double totalcharge;
		if(quantity<=0)
		{
			//log.error("Ordered Quantity should be greater than 0");
			System.out.println(packagecostintegral);
			throw new InvalidInputDetailsException("Invalid input quantity "+quantity);
		}
		
		switch(componentType.toLowerCase()) {
		case "integral" : totalcharge= (packagecostintegral+deliveryintegral+sheatcost)
				                        * quantity;
		break;
		case "accessory" : totalcharge= (packagecostaccessory+deliveryaccessory+sheatcost)
                                        * quantity;
        break;
        default : {
        	//log.error("Entered Component is not a valid type");
        	throw new InvalidInputDetailsException("Entered Invalid Component Type "+componentType);
        }
        }
		
		
		
		return totalcharge;
		
	}
}
