package ch.spring.loriapp.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ch.spring.loriapp.business.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findOneByUsername(String username);
	
	@Query("select count(a) > 0 from Account a where a.email = :email")
	boolean exists(@Param("email") String email);
}