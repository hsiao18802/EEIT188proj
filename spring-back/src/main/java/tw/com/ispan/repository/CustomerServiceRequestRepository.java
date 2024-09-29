package tw.com.ispan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.com.ispan.domain.CustomerServiceRequest;
import tw.com.ispan.domain.Members;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerServiceRequestRepository extends JpaRepository<CustomerServiceRequest, Long> {
    List<CustomerServiceRequest> findByStatus(String status);
    List<CustomerServiceRequest> findByMemberAndStatus(Members member, String status);}
