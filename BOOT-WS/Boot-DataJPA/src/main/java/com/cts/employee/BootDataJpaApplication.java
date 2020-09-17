package com.cts.employee;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.employee.dao.EmployeeDao;
import com.cts.employee.entity.Employee;

@SpringBootApplication
public class BootDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(BootDataJpaApplication.class, args);

		EmployeeDao empDao = ac.getBean(EmployeeDao.class);

		Employee e1 = new Employee("Abc", 10000);
		Employee e2 = new Employee("Xyz", 20000);
		Employee e3 = new Employee("Aaa", 30000);
		Employee e4 = new Employee("Bbb", 40000);
		Employee e5 = new Employee("Ccc", 50000);

		Department d1 = new Department("HR", "Hyderabad");
		Department d2 = new Department("Accounts", "Pune");

		e1.setDept(d1);
		e2.setDept(d1);
		e3.setDept(d1);

		e4.setDept(d2);
		e5.setDept(d2);

		//empDao.saveAll(Arrays.asList(e1, e2, e3, e4, e5));
		
		Employee emp=empDao.findById(1).orElse(null);
		
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getSalary());
		System.out.println(emp.getDept().getDeptId());
		System.out.println(emp.getDept().getDeptName());
		System.out.println(emp.getDept().getLocation());

		System.out.println("--- Saved....");

	}

}
