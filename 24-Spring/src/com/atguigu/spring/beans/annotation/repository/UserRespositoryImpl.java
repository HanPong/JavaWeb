package com.atguigu.spring.beans.annotation.repository;
import org.springframework.stereotype.Repository;
@Repository
public class UserRespositoryImpl implements UserRespository {
	
	public void save() {
		System.out.println("UserRespository Save...");
	}

}
