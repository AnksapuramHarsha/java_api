package com.example.api.service;

import com.example.api.model.EmployeeDetails;
import com.example.api.repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDetailsService {
    private EmployeeDetailsRepository employeeDetailsRepository;

    @Autowired
    public EmployeeDetailsService(EmployeeDetailsRepository employeeDetailsRepository){
        this.employeeDetailsRepository=employeeDetailsRepository;
    }

    public EmployeeDetails newUser(EmployeeDetails employeeDetails){
        return employeeDetailsRepository.save(employeeDetails);
    }

    public List<EmployeeDetails> getDetails(){
        return employeeDetailsRepository.findAll();
    }

    public EmployeeDetails getById(int id){
        return employeeDetailsRepository.findById(id).get();
    }

    public String deleteUser(int id){
        employeeDetailsRepository.deleteById(id);
        return "Deleted" +id+ " successfully";
    }

    public EmployeeDetails updatingUserByid(int id,EmployeeDetails ed){
        EmployeeDetails existingDetails=employeeDetailsRepository.findById(id).get();
        existingDetails.setName(ed.getName());
        existingDetails.setSalary(ed.getSalary());
        return employeeDetailsRepository.save(existingDetails);

    }

}
