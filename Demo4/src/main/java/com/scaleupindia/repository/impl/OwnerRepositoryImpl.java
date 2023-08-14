package com.scaleupindia.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.scaleupindia.config.DatabaseConfig;
import com.scaleupindia.config.PropertiesConfig;
import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.exception.InternalServiceException;
import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.util.MapperUtil;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerRepositoryImpl implements OwnerRepository {
	private static final String DATABASE_DRIVER = "database.driver";
	private static final PropertiesConfig PROPERTIES_CONFIG = PropertiesConfig.getInstance();

	@Override
	public List<OwnerDTO> findAllOwners() {
		String sql = "SELECT * FROM owner_table";
		List<OwnerDTO> ownerList = new ArrayList<>();
		try (Connection connection = DatabaseConfig.getConnection();
				Statement statement = connection.createStatement();) {
			Class.forName(PROPERTIES_CONFIG.getProperty(DATABASE_DRIVER));
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				OwnerDTO owner = MapperUtil.convertOwnerResultSetToDto(resultSet);
				ownerList.add(owner);
			}
		} catch (ClassNotFoundException | SQLException exception) {
			throw new InternalServiceException(exception.getMessage());
		}
		return ownerList;
	}
}
