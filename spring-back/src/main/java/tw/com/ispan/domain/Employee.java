package tw.com.ispan.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "employee_account", nullable = false)
    private String employeeAccount;

    @Column(name = "employee_password", nullable = false)
    private String employeePassword;

    @Column(name = "employee_email", nullable = true)
    private String employeeEmail;
    
    @Column(name = "access_level", nullable = true)
    private int accessLevel;
}