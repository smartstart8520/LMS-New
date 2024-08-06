package org.example.controller;

import org.example.model.Lms;
import org.example.service.LmsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutionException;

@Controller
public class LmsController {
    LmsService service;

    public LmsController(LmsService service){
        this.service = service;
    }

    @RequestMapping("/create")
    @ResponseBody
    public String createCRUD(@RequestBody Lms lms) throws InterruptedException, ExecutionException {
        return service.createCRUD(lms);
    }

    @RequestMapping("/get")
    @ResponseBody
    public Lms getCRUD(@RequestParam String id) throws InterruptedException, ExecutionException{
        return service.getCRUD(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateCRUD(@RequestBody Lms lms) throws InterruptedException, ExecutionException{
        return service.updateCRUD(lms);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteCRUD(@RequestParam String id) throws InterruptedException, ExecutionException{
        return service.deleteCRUD(id);
    }

    @RequestMapping("/test")
    public ResponseEntity<String> testGetEndpoint(){
        return  ResponseEntity.ok("Test Get Endpoint is Woring");
    }
}
