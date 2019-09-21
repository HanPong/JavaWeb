package com.atguigu.spring.beans.cycle;

public class Car {
	public Car() {
		System.out.println("Car's Constructor...");
	}
	private String brand;
	
	public void setBrand(String brand) {
		System.out.println("Set Brand...");
		this.brand=brand;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}
	public void init() {
		System.out.println("Init...");
	}
	public void destroy() {
		System.out.println("Destroy...");
	}
}
