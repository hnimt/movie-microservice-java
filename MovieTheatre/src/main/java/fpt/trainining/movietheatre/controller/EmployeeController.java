package fpt.trainining.movietheatre.controller;

import fpt.trainining.movietheatre.dto.ResponseHandler;
import fpt.trainining.movietheatre.dto.employee.EmployeeReq;
import fpt.trainining.movietheatre.dto.employee.EmployeeRes;
import fpt.trainining.movietheatre.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity findAll() {
        List<EmployeeRes> res = employeeService.findAll();
        return ResponseHandler.generateResponse("Find all employees successfully!", HttpStatus.OK, res);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody EmployeeReq req) {
        EmployeeRes res = employeeService.create(req);
        return ResponseHandler.generateResponse("Create employee successfully!", HttpStatus.CREATED, res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        employeeService.deleteById(id);
        return ResponseHandler.generateResponse("Delete employee successfully!", HttpStatus.OK, null);
    }


}
