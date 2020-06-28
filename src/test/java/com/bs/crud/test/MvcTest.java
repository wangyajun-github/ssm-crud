//package com.bs.crud.test;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.bs.crud.bean.Employee;
//import com.github.pagehelper.PageInfo;
//
///**
// * 浣跨敤Spring娴嬭瘯妯″潡鎻愪緵鐨勬祴璇曡姹傚姛鑳斤紝娴嬭瘯curd璇锋眰鐨勬纭��
// * Spring4娴嬭瘯鐨勬椂鍊欙紝闇�瑕乻ervlet3.0鐨勬敮鎸�
// * @author lfy
// * 
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(locations = { "classpath:applicationContext.xml",
//		"file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml" })
////@ContextConfiguration("classpath*:**web.xml")
//public class MvcTest {
//	@Autowired
//	WebApplicationContext context;
//	MockMvc mockMvc;
//
//	@Before
//	public void initMokcMvc() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//	}
//
////	@Test
////	public void testPage() throws Exception {
////		
////		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1"))
////				.andReturn();
////		MockHttpServletRequest request = result.getRequest();
////		
////		PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
////		System.out.println("getPageNum"+pi.getPageNum());
////		System.out.println("getPages"+pi.getPages());
////		System.out.println("getTotal"+pi.getTotal());
////	
////		int[] nums = pi.getNavigatepageNums();
////		for (int i : nums) {
////			System.out.print(" "+i);
////		}
////		
////		List<Employee> list = pi.getList();
////		for (Employee employee : list) {
////			System.out.println("ID : "+employee.getEmpId()+"  ==>Name:"+employee.getEmpName());
////		}
////		
////	}
//
//}
