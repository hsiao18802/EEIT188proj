package tw.com.ispan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<String> login(@RequestBody LoginRequest request) { // 使用 @RequestBody 接收 JSON
        Employee employee = employeeService.login(request.getAccount(), request.getPassword());
        if (employee != null) {
            return ResponseEntity.ok("Login successful. Welcome " + employee.getEmployeeAccount());
        } else {
            return ResponseEntity.status(401).body("Login failed. Invalid account or password.");
        }
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        // 使當前用戶的 Session 無效
        session.invalidate();
        return ResponseEntity.ok("登出成功");
    }
}
