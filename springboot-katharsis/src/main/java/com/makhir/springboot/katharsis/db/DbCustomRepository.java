package com.makhir.springboot.katharsis.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.makhir.springboot.katharsis.model.Car;
import com.makhir.springboot.katharsis.model.Model;

@Repository
public class DbCustomRepository {
	private static final Logger log = LoggerFactory.getLogger(DbCustomRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public DbCustomRepository(){
		
	}
	
	public void saveCar(Car vo){
		log.debug("Enter: DbCustomRepository.saveCar(), {}");
		
		log.debug("Enter: DbCustomRepository.saveCar(), {}");
	}
	
	public Car getCar(Car vo){
		log.debug("Enter: DbCustomRepository.getCar(), {}", vo.getId());
		
		String sqlQuery = "select * from cars where id = " + vo.getId();
		
		vo = jdbcTemplate.query(sqlQuery, new ResultSetExtractor<Car>(){

			@Override
			public Car extractData(ResultSet rs) throws SQLException, DataAccessException {
				Car vo = new Car();
				if(rs.next()){
					vo.setId(rs.getLong(1));
					vo.setName(rs.getString(2));
					vo.setMenufacturar(rs.getString(3));
				}
				return vo;
			}
			
		});
				
		log.debug("Exit: DbCustomRepository.getCar()");
		return vo;
	}
	
	public List<Car> getCars(){
		log.debug("Enter: DbCustomRepository.getCars(), {}");
		List<Car> list = new ArrayList<Car>();
		
		String sqlQuery = "select * from cars";
		
		list = jdbcTemplate.query(sqlQuery, new RowMapper<Car>(){
			@Override
			public Car mapRow(ResultSet rs, int rowNo) throws SQLException {
				Car vo = new Car();
				vo.setId(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setMenufacturar(rs.getString(3));
				return vo;
			}
		});
		
		log.debug("### Total no. of cars: {}", list.size());
		log.debug("Exit: DbCustomRepository.getCars()");
		return list;
	}
	
	public Model getModel(Model vo){
		log.debug("Enter: DbCustomRepository.getModel(), {}", vo.toString());
		
		String sqlQuery = "select * from Models";
		if(vo != null && vo.getCarid() != null)
			sqlQuery = sqlQuery + " where carid = " + vo.getCarid();
		else
			sqlQuery = sqlQuery + " where id = " + vo.getId();
		
		vo = jdbcTemplate.query(sqlQuery, new ResultSetExtractor<Model>(){

			@Override
			public Model extractData(ResultSet rs) throws SQLException, DataAccessException {
				Model vo = new Model();
				if(rs.next()){
					vo.setId(rs.getLong(1));
					vo.setName(rs.getString(2));
					vo.setVarient(rs.getString(3));
					vo.setYear(rs.getString(4));
					vo.setCarid(rs.getLong(5));
				}
				return vo;
			}
			
		});
				
		log.debug("Exit: DbCustomRepository.getCar()");
		return vo;
	}
	
	public List<Model> getModels(Model reqVo){
		log.debug("Enter: DbCustomRepository.getModel(), {}");
		List<Model> list = new ArrayList<Model>();
		
		String sqlQuery = "select * from Models";
		
		if(reqVo != null && reqVo.getCarid() > 0)
			sqlQuery = sqlQuery + " where carid = " + reqVo.getCarid();
		
		list = jdbcTemplate.query(sqlQuery, new RowMapper<Model>(){
			@Override
			public Model mapRow(ResultSet rs, int rowNo) throws SQLException {
				Model vo = new Model();
				vo.setId(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setVarient(rs.getString(3));
				vo.setYear(rs.getString(4));
				vo.setCarid(rs.getLong(5));
				return vo;
			}
		});
		
		log.debug("### Total no. of models: {}", list.size());
		log.debug("Exit: DbCustomRepository.getModels()");
		return list;
	}
}
