package com.csi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import com.csi.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public void saveData(Employee employee) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(employee);

		transaction.commit();
	}

	@Override
	public List<Employee> getData() {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		List<Employee> empList = session.createQuery("From Employee").list();

		return empList;
	}

	@Override
	public void updateData(int empId, Employee employee) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee emp = (Employee) session.get(Employee.class, empId);

		if (emp.getEmpId() == empId) {

			emp.setEmpName(employee.getEmpName());
			emp.setEmpContactNo(employee.getEmpContactNo());
			emp.setEmpSalary(employee.getEmpSalary());
			emp.setEmpDob(employee.getEmpDob());

			session.update(emp);
			transaction.commit();

		}
	}

	@Override
	public void deleteData(int empId) {
		// TODO Auto-generated method stub

		Session session=factory.openSession();

		Transaction transaction=session.beginTransaction();

		Employee emp=(Employee) session.get(Employee.class, empId);

		if(emp.getEmpId()==empId){



			session.delete(emp);
			transaction.commit();

		}

	}
}
