package tw.com.ispan.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import lombok.Data;
import tw.com.ispan.domain.Employee;
import tw.com.ispan.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // 使用靜態內部類來接收 JSON 請求
    @Data
    public static class LoginRequest {
        private String account;
        private String password;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        Employee employee = employeeService.login(request.getAccount(), request.getPassword());
        if (employee != null) {
            Map<String, String> response = new HashMap<>();
            // 獲取員工的 ID 並將其放入回應
            response.put("employeeId", String.valueOf(employee.getEmployeeId()));
            response.put("message", "Login successful. Welcome " + employee.getEmployeeAccount());

            return ResponseEntity.ok(response);
        } else {
            // 返回失敗訊息
            return ResponseEntity.status(401).body(Collections.singletonMap("message", "Login failed. Invalid account or password."));
        }
    }


    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        // 使當前用戶的 Session 無效
        session.invalidate();
        return ResponseEntity.ok("登出成功");
    }
    
    
    // 根據 employeeId 查找 employeeAccount
    @GetMapping("/account/{id}")
    public ResponseEntity<String> getEmployeeAccountById(@PathVariable("id") int employeeId) {
        try {
            String employeeAccount = employeeService.findEmployeeAccountById(employeeId);
            return ResponseEntity.ok(employeeAccount); // 返回帳號
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // 找不到員工
        }
    }
    
        // 全部查詢
        @GetMapping("/all")
        public ResponseEntity<Map<String, Object>> getAllEmployees() {
            List<Employee> employees = employeeService.findAll();
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Employees retrieved successfully");
            response.put("employees", employees);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        // 根據 ID 查詢單筆
        @GetMapping("/{id}")
        public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable("id") int id) {
            Employee employee = employeeService.findById(id);
            Map<String, Object> response = new HashMap<>();

            if (employee != null) {
                response.put("message", "Employee found");
                response.put("employee", employee);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("message", "Employee not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }

        // 根據 accessLevel 進行分類查詢
        @GetMapping("/access-level/{accessLevel}")
        public ResponseEntity<Map<String, Object>> getEmployeesByAccessLevel(@PathVariable("accessLevel") int accessLevel) {
            List<Employee> employees = employeeService.findByAccessLevel(accessLevel);
            Map<String, Object> response = new HashMap<>();

            if (employees != null && !employees.isEmpty()) {
                response.put("message", "Employees with access level " + accessLevel + " found");
                response.put("employees", employees);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("message", "No employees found with access level " + accessLevel);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }

        // 新增員工
        @PostMapping("/add")
        public ResponseEntity<Map<String, Object>> addEmployee(@RequestBody Employee employee) {
            Employee newEmployee = employeeService.saveEmployee(employee);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Employee added successfully");
            response.put("employee", newEmployee);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

        // 刪除員工
        @DeleteMapping("/{id}")
        public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable("id") int id) {
            boolean deleted = employeeService.deleteEmployee(id);
            Map<String, Object> response = new HashMap<>();

            if (deleted) {
                response.put("message", "Employee deleted successfully");
                return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
            } else {
                response.put("message", "Employee not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<Map<String, Object>> updateEmployeeDetails(@PathVariable("id") int id, @RequestBody Employee updatedEmployee) {
            System.out.println("Received request to update employee with ID: " + id);

            // 先從資料庫中取得現有的 Employee 資料
            Employee existingEmployee = employeeService.findById(id);
            if (existingEmployee == null) {
                System.out.println("Employee not found with ID: " + id);
                Map<String, Object> response = new HashMap<>();
                response.put("message", "Employee not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            // 保留不變的欄位
            if (updatedEmployee.getEmployeeAccount() == null) {
                updatedEmployee.setEmployeeAccount(existingEmployee.getEmployeeAccount());
            }
            if (updatedEmployee.getEmployeePassword() == null) {
                updatedEmployee.setEmployeePassword(existingEmployee.getEmployeePassword());
            }
            if (updatedEmployee.getEmployeeEmail() == null) {
                updatedEmployee.setEmployeeEmail(existingEmployee.getEmployeeEmail());
            }
            if (updatedEmployee.getAccessLevel() == 0) {
                updatedEmployee.setAccessLevel(existingEmployee.getAccessLevel());
            }

            // 更新員工資料
            Employee employee = employeeService.updateEmployeeDetails(id, updatedEmployee);
            Map<String, Object> response = new HashMap<>();
            
            if (employee != null) {
                response.put("message", "Employee details updated successfully");
                response.put("employee", employee);
                System.out.println("Employee updated successfully: " + employee);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("message", "Failed to update employee details");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


        // 修改員工密碼，並驗證舊密碼
        @PutMapping("/update-password/{id}")
        public ResponseEntity<Map<String, Object>> updateEmployeePassword(@PathVariable("id") int id, @RequestBody Map<String, String> passwordData) {
            String oldPassword = passwordData.get("oldPassword");
            String newPassword = passwordData.get("newPassword");

            boolean passwordUpdated = employeeService.updateEmployeePassword(id, oldPassword, newPassword);
            Map<String, Object> response = new HashMap<>();

            if (passwordUpdated) {
                response.put("message", "Password updated successfully");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("message", "Old password is incorrect");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }
    }


