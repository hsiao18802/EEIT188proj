package tw.com.ispan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.ispan.domain.CustomerServiceRequest;

@Repository
public interface CustomerServiceRequestRepository extends JpaRepository<CustomerServiceRequest, Long> {
	List<CustomerServiceRequest> findByMember_MembersId(Integer membersId);
	List<CustomerServiceRequest> findByStatus(String status); // 查詢特定狀態的客服請求
}
