package com.atguigu.spring.beans.factory;
/*ʵ������������ʵ�������ķ���������Ҫ������������
 * �ٵ��ù�����ʵ������������Bean��ʵ��*/

import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {
	private Map<String, Car> cars=null;
	public InstanceCarFactory() {
		cars=new HashMap<String,Car>();
		cars.put("audi", new Car("audi",300000));
		cars.put("ford", new Car("ford", 500000));
	}
	public Car getCar(String brand) {
		return cars.get(brand);
	}
}
