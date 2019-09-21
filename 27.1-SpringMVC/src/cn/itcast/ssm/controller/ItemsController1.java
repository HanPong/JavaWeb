package cn.itcast.ssm.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.itcast.ssm.po.Items;

//��дHandler��ʵ��Controller�ӿ�
public class ItemsController1 implements Controller{
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//����service�������ݿ�
		List<Items> itemsList=new ArrayList<Items>();
		Items items_1 = new Items();
		items_1.setName("����ʼǱ�");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 ����ʼǱ����ԣ�");
		
		Items items_2 = new Items();
		items_2.setName("ƻ���ֻ�");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6ƻ���ֻ���");
		
		itemsList.add(items_1);
		itemsList.add(items_2);
		
		//����ModelAndview
		ModelAndView modelAndView=new ModelAndView();
		//�൱��request��setAttribute����,��jspҳ����ͨ��itemsListȡ����
		modelAndView.addObject("itemsList", itemsList);
		
		//ָ����ͼ
		modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		return modelAndView;
	}
	
	

}