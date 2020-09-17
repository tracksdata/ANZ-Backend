package com.cts.employee;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.employee.dao.DepartmentDao;
import com.cts.employee.dao.EmployeeDao;
import com.cts.employee.entity.Department;
import com.cts.employee.entity.Employee;

@SpringBootApplication
public class BootDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(BootDataJpaApplication.class, args);

		DepartmentDao deptDao = ac.getBean(DepartmentDao.class);

		Employee e1 = new Employee("Abc", 10000);
		Employee e2 = new Employee("Xyz", 20000);
		Employee e3 = new Employee("Aaa", 30000);
		Employee e4 = new Employee("Bbb", 40000);
		Employee e5 = new Employee("Ccc", 50000);

		Department d1 = new Department("HR", "Hyderabad");
		Department d2 = new Department("Accounts", "Pune");

		d1.getEmps().add(e1);
		d1.getEmps().add(e2);
		d1.getEmps().add(e3);

		d2.getEmps().add(e4);
		d2.getEmps().add(e5);

		// deptDao.save(d1);
		// deptDao.save(d2);

		Department dept = deptDao.findById(5).orElse(null);

		System.out.println(dept.getDeptId());
		System.out.println(dept.getDeptName());
		System.out.println(dept.getLocation());
		System.out.println("-------------------------");

		for (Employee emp : dept.getEmps()) {
			System.out.println(emp.getId());
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
			System.out.println("------------------------");
		}

		System.out.println("--- Saved....");

	}

}
