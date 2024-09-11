package tw.com.ispan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.ispan.domain.Members;

@Repository
public interface MembersRepository extends JpaRepository<Members, Integer> {
	Optional<Members> findByUsername(String username);
}
