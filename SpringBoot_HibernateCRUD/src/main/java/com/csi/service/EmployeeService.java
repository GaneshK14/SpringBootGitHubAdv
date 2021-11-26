package com.csi.service;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeService {

public void saveData(Employee employee);
	
	public List<Employee> getData();
	
	public void updateData(int empId, Employee employee);
	
	public void deleteData(int empId);
	
}
