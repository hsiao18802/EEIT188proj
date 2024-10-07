package tw.com.ispan.service;

import java.util.List;

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
    
    // 查詢全部員工
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    // 根據 ID 查詢
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // 根據 accessLevel 查詢
    public List<Employee> findByAccessLevel(int accessLevel) {
        return employeeRepository.findByAccessLevel(accessLevel);
    }

    // 新增員工，並對密碼進行加密
    public Employee saveEmployee(Employee employee) {
        String encodedPassword = passwordEncoder.encode(employee.getEmployeePassword());
        employee.setEmployeePassword(encodedPassword);
        return employeeRepository.save(employee);
    }

    // 刪除員工
    public boolean deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
 // 修改員工資料（不包括密碼）
    public Employee updateEmployeeDetails(int id, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee != null) {
            existingEmployee.setEmployeeAccount(updatedEmployee.getEmployeeAccount());
            existingEmployee.setEmployeeEmail(updatedEmployee.getEmployeeEmail());
            existingEmployee.setAccessLevel(updatedEmployee.getAccessLevel());
            return employeeRepository.save(existingEmployee);
        } else {
            return null;
        }
    }
    
 // 修改員工密碼
    public boolean updateEmployeePassword(int id, String oldPassword, String newPassword) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee != null && passwordEncoder.matches(oldPassword, existingEmployee.getEmployeePassword())) {
            // 如果舊密碼匹配，則更新密碼
            existingEmployee.setEmployeePassword(passwordEncoder.encode(newPassword));
            employeeRepository.save(existingEmployee);
            return true;
        } else {
            // 舊密碼不匹配
            return false;
        }
    }

}
