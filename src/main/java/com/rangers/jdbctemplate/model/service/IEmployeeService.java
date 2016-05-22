package com.rangers.jdbctemplate.model.service;

import java.util.List;

import com.rangers.jdbctemplate.model.Employee;
import com.rangers.jdbctemplate.model.PageFilter;

public interface IEmployeeService {

  public List<Employee> getDepartmentEmployees(int departmentId, PageFilter pageFilter);

  public Employee getEmployee(int employeeId);

  public Employee addEmployee(Employee employee);

  public Employee updateEmployee(Employee employee);

  public void deleteEmployee(int employeeId);

}
