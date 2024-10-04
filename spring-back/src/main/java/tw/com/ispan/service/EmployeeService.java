package tw.com.ispan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tw.com.ispan.domain.Employee;
import tw.com.ispan.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Employee login(String account, String password) {
        Employee employee = employeeRepository.findByEmployeeAccount(account);

        if (employee != null && passwordEncoder.matches(password, employee.getEmployeePassword())) {
            return employee; // 登錄成功
        }
        return null; // 登錄失敗
    }
    
    // 使用 employeeId 查找 employeeAccount
    public String findEmployeeAccountById(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + employeeId));
        return employee.getEmployeeAccount(); // 返回員工的帳號
    }
}
