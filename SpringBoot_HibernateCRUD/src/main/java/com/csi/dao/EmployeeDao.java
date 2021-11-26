package com.csi.dao;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeDao {

	public void saveData(Employee employee);
	
	public List<Employee> getData();
	
	public void updateData(int empId, Employee employee);
	
	public void deleteData(int empId);
	
}
