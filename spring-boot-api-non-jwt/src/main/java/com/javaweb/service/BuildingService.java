package com.javaweb.service;

import java.util.List;

import com.javaweb.DTO.BuildingDTO;
import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingService {
	List<BuildingDTO> findAll(String name, Long numberOfBasement);
}
