package fpt.trainining.movietheatre.service.impl;

import fpt.trainining.movietheatre.dto.account.AccountInfoRes;
import fpt.trainining.movietheatre.dto.employee.EmployeeReq;
import fpt.trainining.movietheatre.dto.employee.EmployeeRes;
import fpt.trainining.movietheatre.entity.Account;
import fpt.trainining.movietheatre.entity.Employee;
import fpt.trainining.movietheatre.entity.common.Roles;
import fpt.trainining.movietheatre.exception.ResourceNotFoundException;
import fpt.trainining.movietheatre.repository.EmployeeRepository;
import fpt.trainining.movietheatre.service.AccountService;
import fpt.trainining.movietheatre.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final ModelMapper mapper;
    private final EmployeeRepository employeeRepository;
    private final AccountService accountService;

    private EmployeeRes employeeToEmployeeRes(Employee employee) {
        EmployeeRes employeeRes = mapper.map(employee, EmployeeRes.class);
        AccountInfoRes accountInfoRes = mapper.map(employee.getAccount(), AccountInfoRes.class);
        employeeRes.setAccountInfoRes(accountInfoRes);
        return employeeRes;
    }

    @Override
    public List<EmployeeRes> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map((employee -> {
                    return employeeToEmployeeRes(employee);
                }))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeRes findById(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found this employee"));
        return employeeToEmployeeRes(employee);
    }

    @Override
    public EmployeeRes create(EmployeeReq req) {
        Account account = accountService.updateRole(req.getAccountId(), Roles.EMPLOYEE.roleName);
        Employee employee = mapper.map(req, Employee.class);
        employee.setAccount(account);
        employee = employeeRepository.save(employee);
        EmployeeRes res = employeeToEmployeeRes(employee);
        return res;

    }

    @Override
    @Transactional
    public void deleteById(String id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cannot found employee"));
        accountService.deleteById(employee.getAccount().getAccountId());
        employeeRepository.deleteById(id);
    }
}
