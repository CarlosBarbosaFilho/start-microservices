package br.com.cbgomes.repository;

import br.com.cbgomes.entity.EntityFraudHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRepository extends JpaRepository<EntityFraudHistory, Long> {
}
