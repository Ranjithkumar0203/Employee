package com.deccan.employee.client;

import com.deccan.employee.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "address-service", url = "${address.service.url}")
public interface AddressClient {

    @PostMapping("/address/save")
    Address saveAddress(@RequestBody Address address);
}
