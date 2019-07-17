package com.wipro.digital.application.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.wipro.digital.application.producer.util.Employee;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeTest {
	
	@InjectMocks
	Employee emp ;
	
	
	@Before
	public void setup() {
		
		emp.setName("test");
		emp.setEmpid(12345);
		emp.setAddress("Pune");
		
		Employee emp1 = new Employee("test",1234,"test");
		
		MockitoAnnotations.initMocks(this);
	}
	
	 @Test
	    public void getEmployeeTest()
	    {
	        assertEquals("test", emp.getName());
	        assertEquals(12345, emp.getEmpid());
	        assertEquals("Pune", emp.getAddress());
	        emp.toString();
	       // assertEquals(Mockito.anyString(), toString());
	    }

}
