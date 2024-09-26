package tw.com.ispan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.ispan.domain.CustomerServiceRequest;
import tw.com.ispan.domain.Members;

@Repository
public interface CustomerServiceRequestRepository extends JpaRepository<CustomerServiceRequest, Long> {
//	List<CustomerServiceRequest> findByMember_MembersId(Integer membersId);
//	List<CustomerServiceRequest> findByStatus(String status); // 查詢特定狀態的客服請求
	 Optional<CustomerServiceRequest> findByMemberAndStatus(Members member, String status);
	 Optional<CustomerServiceRequest> findTopByMemberAndStatusOrderByCreatedAtDesc(Members member, String status);
}
