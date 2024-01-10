package com.example.employee.Employee.Services;

import com.example.employee.Employee.DTO.EmployeeDTO;
import com.example.employee.Employee.Entity.Employee;
import com.example.employee.Employee.Repo.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpServices {

    @Autowired
    private EmployeeRepo emprepo;



    public String addEmployee(EmployeeDTO empdto) {

        Employee emp = new Employee(empdto);

        Employee savedemp = emprepo.save(emp);

        return savedemp.toString();
    }


    public String deleteEmp(int id) {
        try {
            emprepo.deleteById(id);
            return "Employee deleted successfully.";
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where the employee with the given ID is not found
            return "Employee not found with ID: " + id;
        } catch (Exception e) {
            // Handle other exceptions (e.g., database connection issues)

            return "Error deleting employee with ID: " + e;
        }
    }

    public String updateEmp(int id, EmployeeDTO employeeDTO) {

        if (emprepo.existsById(id)) {
            Employee existingEmployee = emprepo.getReferenceById(id);
            existingEmployee.setAge(employeeDTO.getAge() != 0 ? employeeDTO.getAge() : existingEmployee.getAge());
            existingEmployee.setAddress(employeeDTO.getAddress() != null ? employeeDTO.getAddress() : existingEmployee.getAddress());
            existingEmployee.setName(employeeDTO.getName() != null ? employeeDTO.getName() : existingEmployee.getName());
            emprepo.save(existingEmployee);


        }
        else
        {
            System.out.println("Employee ID "+id+"do not Exist");
        }
        return null;
    }

    public List<Employee> getAllEntities() {
        return emprepo.findAll();
    }

    public Employee getSingleEmp(int id) {
        return emprepo.findById(id).orElse(null);
    }

    public List<Employee> getEmployeebyname(String name) {
        return emprepo.findByName(name);
    }
}
