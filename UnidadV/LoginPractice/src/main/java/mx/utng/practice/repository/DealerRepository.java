package mx.utng.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.utng.practice.model.Dealer;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long>{

	@Query ("select deal from Dealer deal")
	public List<Dealer> findAll();
}
