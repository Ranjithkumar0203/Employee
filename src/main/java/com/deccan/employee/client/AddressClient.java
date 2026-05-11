package com.deccan.employee.client;

import java.util.List;

import com.deccan.employee.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "address")
public interface AddressClient {

    @PostMapping("/address/save")
    Address saveAddress(@RequestBody Address address);

    @GetMapping("/address/employee/{employeeID}")
    List<Address> getAddressesByEmployeeID(@PathVariable String employeeID);
}
