package com.javaweb.api;

import java.util.Map;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.DTO.BuildingDTO;
import com.javaweb.DTO.ErrorResponseDTO;
import com.javaweb.customexception.FieldRequiredException;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping(value="/api/building")
	public List<BuildingDTO> findBuilding(@RequestParam (value = "name", required = false) String name, 
			@RequestParam(value="numberOfBasement", required = false) Long numberofBasement) {
		List<BuildingDTO> result = buildingService.findAll(name, numberofBasement);
		return result;
	}
//	public void validateData(BuildingDTO buildingDTO) {
//		if (buildingDTO.getName() == null || buildingDTO.getName().equals("") || buildingDTO.getDistrictId() == null) {
//			throw new FieldRequiredException("Name or district ID is null");
//		}
//	}
	@PostMapping(value="/api/building")
	public Object createBuilding(@RequestBody BuildingDTO buildingDTO) {
		//validateData(buildingDTO);
		
		System.out.print("OK");
		return buildingDTO;
	}
	
	@RequestMapping(value="/api/building/{ids}/{name}", method=RequestMethod.DELETE)
	public void deleteBuilding(@PathVariable Long[] ids,
			@PathVariable String name) {
		System.out.print("OK");
	}
}
