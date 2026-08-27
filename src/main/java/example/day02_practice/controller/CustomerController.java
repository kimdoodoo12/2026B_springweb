package example.day02_practice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import example.day02_practice.model.dao.CustomerDao;
import example.day02_practice.model.dto.CustomerDto;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class CustomerController {
    private CustomerController(){};
    private static final CustomerController instance = new CustomerController();
    public static CustomerController getInstance(){return instance;}

    private CustomerDao cd = CustomerDao.getInstance();
    
    @PostMapping("/customer/reserve")
    public boolean reserve(CustomerDto customerDto){
        boolean result = cd.reserve(customerDto);
        return result;
    }

    @GetMapping("/customer/findall")
    public ArrayList<CustomerDto> findAll(){
        ArrayList <CustomerDto> result = cd.findAll();
        return result;
    }

    @PutMapping("/customer/update")
    public boolean update(String phone, int people){
        boolean result = cd.update(phone, people);
        return result;
    }

    @DeleteMapping("/customer/delete")
    public boolean delete(String phone){
        boolean result = cd.delete(phone);
        return result;
    }
}
    
