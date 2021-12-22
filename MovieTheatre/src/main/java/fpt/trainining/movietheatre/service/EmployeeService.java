package fpt.trainining.movietheatre.service;

import fpt.trainining.movietheatre.dto.employee.EmployeeReq;
import fpt.trainining.movietheatre.dto.employee.EmployeeRes;

import java.util.List;

public interface EmployeeService {
    List<EmployeeRes> findAll();
    EmployeeRes findById(String id);
    //    MemberRes findMemberByName();
    EmployeeRes create(EmployeeReq req);
    void deleteById(String id);
}
