package com.digdes.java2023.repository;

import com.digdes.java2023.model.employee.Employee;
import com.digdes.java2023.model.employee.EmployeeStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByAccount(String account);
    Optional<Employee> findByAccountAndEmployeeStatus(String account, EmployeeStatus employeeStatus);
    Optional<Employee> findByUsername(String username);
    Optional<Employee> findByUsernameAndEmployeeStatus(String username, EmployeeStatus employeeStatus);

    Page<Employee> findByEmployeeStatusAndLastNameContainingOrNameContainingOrPatronymicContainingOrAccountContainingOrEmailContaining(
            EmployeeStatus employeeStatus,
            String infixLastname,
            String infixName,
            String infixPatronymic,
            String infixAccount,
            String infixEmail,
            Pageable pageable);
}
