package com.weatherlog.app.repo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.weatherlog.app.WeatherLogSqlConfigureProperties;
import com.weatherlog.app.dto.WeatherLogDTO;
import com.weatherlog.app.repo.WeatherLogRepository;

@Repository
public class WeatherLogRepositoryImpl implements WeatherLogRepository {

//    @Autowired	
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;	
	
    @Autowired	
    private WeatherLogSqlConfigureProperties sqlProperties;	
 
	@Override
	public List<WeatherLogDTO> getAllWeatherLogs() {
		List<WeatherLogDTO> weatherLogDTOList = null;	
//		weatherLogDTOList = namedParameterJdbcTemplate.query(sqlProperties.getGetAllWeatherLogsQuery(), 
//			new WeatherLogDtoSearchMapper());	
		return weatherLogDTOList;	
	}

	@Override
	public int saveWeatherLog() {
		return 0;
	}

	@Override
	public int deleteWeatherLog() {
		return 0;
	}

	private class WeatherLogDtoSearchMapper implements RowMapper<WeatherLogDTO> {	
		public WeatherLogDTO mapRow(ResultSet resultSet, int i) throws SQLException {	
	
			WeatherLogDTO weatherLogDto = new WeatherLogDTO();	
			weatherLogDto.setActualWeather(	
					resultSet.getString("ACTUAL_WEATHER"));	
			weatherLogDto.setDtimeInserted(	
					resultSet.getTimestamp("DTIME_INSERTED").toInstant());	
			weatherLogDto.setTemperature(	
					resultSet.getString("TEMPERATURE"));	
			weatherLogDto.setLocation(	
					resultSet.getString("LOCATION"));	
			weatherLogDto.setResponseId(	
					resultSet.getString("RESPONSE_ID"));	
			weatherLogDto.setId(	
					resultSet.getLong("ID"));	
			return weatherLogDto;	
		}	
	}	
}
