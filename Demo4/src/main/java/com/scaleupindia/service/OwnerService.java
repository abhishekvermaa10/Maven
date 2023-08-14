package com.scaleupindia.service;

import java.util.List;

import com.scaleupindia.dto.OwnerDTO;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerService {
	List<OwnerDTO> findAllOwners();
}