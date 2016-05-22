package com.rangers.jdbctemplate.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rangers.jdbctemplate.model.Employee;
import com.rangers.jdbctemplate.model.PageFilter;
import com.rangers.jdbctemplate.model.dao.IEmployeeDao;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

  @Autowired
  private IEmployeeDao employeeDao;

  @Override
  public List<Employee> getDepartmentEmployees(int departmentId, PageFilter pageFilter) {
    return employeeDao.getDepartmentEmployees(departmentId, pageFilter);
  }

  @Override
  @Cacheable(value="employeeCache", key="#employeeId")
  public Employee getEmployee(int employeeId) {
    return employeeDao.getEmployee(employeeId);
  }
/*
  @Cacheable(value="employeeCache", key="employeeId")
  private Employee getEmpoyee2(int employeeId) {
    return employeeDao.getEmployee(employeeId);
  }*/

  @Override
  public Employee addEmployee(Employee employee) {
    return employeeDao.addEmployee(employee);
  }

  @Override
  @CacheEvict(value="employeeCache", key="#employee.id")
  public Employee updateEmployee(Employee employee) {
    return employeeDao.updateEmployee(employee);
  }

  @Override
  @CacheEvict(value="employeeCache", key="#employeeId")
  public void deleteEmployee(int employeeId) {
    employeeDao.deleteEmployee(employeeId);
  }

}
