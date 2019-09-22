package com.atguigu.mybatis.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.atguigu.mybatis.dao.EmployeeMapperDynamicSQL;
import com.atguigu.mybatis.dao.EmployeeMapperPlus;

public class MyBatisTest {
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource="mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	/*测试两级缓存
	 * 一级缓存（本地缓存），与数据库同一次会话期间查询到的数据会放在本地缓存中
	 * 以后如果需要获取相同的数据，直接从缓存中获取，没必要再去查数据库
	 * sqlSssion级别的缓存，一级缓存是一直开启的
	 * */
	public void testFirstLevelCache() throws IOException {
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		SqlSession opensession=sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper=opensession.getMapper(EmployeeMapper.class);
			
		}finally {
			
		}
		
		
	}
	

	
	}



