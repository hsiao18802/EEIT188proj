package tw.com.ispan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.com.ispan.domain.Cart;
import tw.com.ispan.domain.Members;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
//	Cart findByMembers(Members members);
//	Cart findByMemberId(Integer memberId);
}