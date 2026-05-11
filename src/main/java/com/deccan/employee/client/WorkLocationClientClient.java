package com.deccan.employee.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.deccan.employee.model.WorkLocation;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(name = "worklocation")
public interface WorkLocationClientClient {
    @PostMapping("/worklocation/save")
    public WorkLocation saveWorkLocation(@RequestBody WorkLocation WorkLocation);
}
