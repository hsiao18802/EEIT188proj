package tw.com.ispan.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
