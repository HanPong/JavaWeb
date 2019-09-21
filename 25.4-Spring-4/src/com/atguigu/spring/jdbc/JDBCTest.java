package com.atguigu.spring.jdbc;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTest {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	JdbcTemplate jdbcTemplate=(JdbcTemplate)ctx.getBean("jdbcTemplate");
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource=(DataSource)ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}
	
	//执行一次更新
	@Test
	public void testUpdata() {
		String sql="update tbl_employee set last_name=? where id=?";
		jdbcTemplate.update(sql, "Jack","2");
	}
	//执行多次更新
	@Test
	public void testBatchUpdate() {
		String sql="insert into tbl_employee(last_name,email) values(?,?)";
		List<Object[]> batchArg=new ArrayList<>();
		batchArg.add(new Object[] {"AA","BB"});
		batchArg.add(new Object[] {"AA","BB"});
		jdbcTemplate.batchUpdate(sql,batchArg);
	}


}
