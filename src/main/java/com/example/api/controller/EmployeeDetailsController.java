package com.example.api.controller;

import com.example.api.model.EmployeeDetails;
import com.example.api.service.EmployeeDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeDetailsController {
    private EmployeeDetailsService employeeDetailsService;

    public EmployeeDetailsController(EmployeeDetailsService employeeDetailsService){
        this.employeeDetailsService=employeeDetailsService;
    }

    @PostMapping("/save")
    public EmployeeDetails addingNewUser(@RequestBody EmployeeDetails employeeDetails){
        return employeeDetailsService.newUser(employeeDetails);
    }

    @GetMapping("/getAll")
    public List<EmployeeDetails> getAllUsers(){
        return employeeDetailsService.getDetails();
    }

    @GetMapping("get/{id}")
    public EmployeeDetails getByUserId(@PathVariable int id){
        return employeeDetailsService.getById(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUserById(@PathVariable int id){
        return employeeDetailsService.deleteUser(id);
    }

    @PutMapping("/put/{id}")
    public EmployeeDetails updatingDetails(@PathVariable int id,@RequestBody EmployeeDetails employeeDetails){
        return employeeDetailsService.updatingUserByid(id,employeeDetails);
    }

}
