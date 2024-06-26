package com.love.main;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.love.beans.Employee;


public class MainTest {
	
	public static void main(String args[]) 
	{
		String configfilepath = "/com/love/resource/applicationContext.xml";
		ApplicationContext acontext = new ClassPathXmlApplicationContext(configfilepath);
		Employee emp=(Employee)acontext.getBean("employee");
		emp.show();
		System.out.println("\nfor next.....\n");
		emp=(Employee)acontext.getBean("employee1");
		emp.show();
	}
}
