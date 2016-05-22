package com.rangers.jdbctemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rangers.jdbctemplate.model.Employee;
import com.rangers.jdbctemplate.model.PageFilter;
import com.rangers.jdbctemplate.model.service.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  @Autowired
  private IEmployeeService employeeService;

  /**
   * Sample request -
   * http://localhost:8085/api/employees?departmentId=2&limit=1&offset=1&pagedList=true
   * 
   * @param departmentId
   * @param pageFilter
   * @return
   */
  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public List<Employee> getEmployees(int departmentId, PageFilter pageFilter) {

    return employeeService.getDepartmentEmployees(departmentId, pageFilter);
  }

  @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
  public Employee getEmployee(@PathVariable int employeeId) {

    return employeeService.getEmployee(employeeId);
  }

  @RequestMapping(method = RequestMethod.POST)
  public Employee addEmployee(@RequestBody Employee employee) {

    return employeeService.addEmployee(employee);
  }

  @RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
  public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee newEmployee) {
    Employee oldEmployee = employeeService.getEmployee(employeeId);

    if (oldEmployee != null) {
      oldEmployee.setName(newEmployee.getName());
      oldEmployee.setEmailId(newEmployee.getEmailId());
      oldEmployee.setDepartmentId(newEmployee.getDepartmentId());

      return employeeService.updateEmployee(oldEmployee);
    }

    return null;
  }

  @RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
  @ResponseStatus(code = HttpStatus.OK)
  public void delete(@PathVariable int employeeId) {
    employeeService.deleteEmployee(employeeId);
  }

}
