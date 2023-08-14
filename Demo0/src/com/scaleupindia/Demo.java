package com.scaleupindia;

import java.util.List;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.service.impl.OwnerServiceImpl;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo {
	private OwnerService ownerService;

	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.run(args);
	}

	public void run(String... args) {
		ownerService = new OwnerServiceImpl();
		try {
			System.out.println("Welcome to Petistaan");
			List<OwnerDTO> ownerDTOList = ownerService.findAllOwners();
			System.out.println("There are " + ownerDTOList.size() + " owners.");
			ownerDTOList.forEach(System.out::println);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}
