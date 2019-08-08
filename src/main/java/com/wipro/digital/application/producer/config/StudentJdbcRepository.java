package com.wipro.digital.application.producer.config;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wipro.digital.application.producer.util.Student;
@Repository
public class StudentJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    class StudentRowMapper implements RowMapper < Student > {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        	
            Student student = new Student();
            student.setId(rs.getString("id"));
            student.setName(rs.getString("name"));
            student.setPassportNumber(rs.getString("passport_number"));
            return student;
        }
    }
    
    public List < Student > findAll() {
        return jdbcTemplate.query("select * from student", new StudentRowMapper());
    }
    
    public Map<String, Object> findById(String id) {
		/*
		 * @SuppressWarnings("unchecked") HashMap<String, String> hashMap =
		 * (HashMap<String, String>)
		 * jdbcTemplate.query("select * from student where id=10010", new
		 * ResultSetExtractor<Map>(){
		 * 
		 * @SuppressWarnings("rawtypes")
		 * 
		 * @Override public Map extractData(ResultSet rs) throws
		 * SQLException,DataAccessException { HashMap<String,String> mapRet= new
		 * HashMap<String,String>(); while(rs.next()){
		 * mapRet.put(rs.getString("string1"),rs.getString("string2")); }
		 * 
		 * return mapRet; } }); return hashMap;
		 */
    	
    	 return jdbcTemplate.queryForMap("select * from student where id = ?", id);
    }
    
    public int deleteById(String id) {
        return jdbcTemplate.update("delete from student where id=?", new Object[] {
            id
        });
    }
    public int insert(Student student) {
        return jdbcTemplate.update("insert into student (id, name, passport_number) " + "values(?,  ?, ?)",
            new Object[] {
                student.getId(), student.getName(), student.getPassportNumber()
            });
    }
    public int update(Student student) {
        return jdbcTemplate.update("update student " + " set name = ?, passport_number = ? " + " where id = ?",
            new Object[] {
                student.getName(), student.getPassportNumber(), student.getId()
            });
    }

}