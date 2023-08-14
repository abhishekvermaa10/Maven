package com.scaleupindia;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.repository.impl.OwnerRepositoryImpl;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerRepositoryTest {

	@Test
	public void testFindAllOwners() { 
		System.out.println("dcewrfvfrw");
		OwnerRepository ownerRepository = new OwnerRepositoryImpl();
		List<OwnerDTO> ownerDTOList = ownerRepository.findAllOwners();
		Assertions.assertFalse(ownerDTOList.isEmpty());
	}
}
