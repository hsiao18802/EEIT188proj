package tw.com.ispan.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tw.com.ispan.domain.Cart;
import tw.com.ispan.domain.Members;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	@Query("SELECT c FROM Cart c JOIN FETCH c.product WHERE c.members.membersId = :membersId")
	Set<Cart> findByMembersIdWithProduct(@Param("membersId") Integer membersId);



	 @Query("SELECT c FROM Cart c WHERE c.members.id = :membersId AND c.product.id = :productId")
	    Cart findByMembersIdAndProductId(@Param("membersId") Integer membersId, @Param("productId") Integer productId);
	 
	 Set<Cart> findByMembers(Members members);
	


	

}