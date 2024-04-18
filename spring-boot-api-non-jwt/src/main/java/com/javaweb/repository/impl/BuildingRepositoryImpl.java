package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.DTO.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.ConnectionUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	
	@Override
	public List<BuildingEntity> findAll(String name, Long numberOfBasement) {
		String sql = "SELECT * FROM Building ";
		String where = "WHERE 1=1";
		
		if (name != null && !name.equals("")) {
			where += " AND name LIKE '%" + name + "%' ";
		}
		
		if (numberOfBasement != null) {
			where += " AND numberofbasement = " + numberOfBasement;
		}
		sql += where;
		
		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		try(Connection conn = ConnectionUtil.getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql)){
			while (rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setDistrictId(rs.getLong("districtid"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				result.add(building);
			}
			System.out.println("Connected database successfully...");

		} catch (SQLException e) {

			e.printStackTrace();

			System.out.println("Connected database failed...");

		}
		
		return result;
	}

	@Override
	public void delete(Long[] ids) {
		
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}
}
