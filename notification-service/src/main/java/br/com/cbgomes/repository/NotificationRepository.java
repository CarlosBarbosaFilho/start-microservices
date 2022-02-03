package br.com.cbgomes.repository;

import br.com.cbgomes.entity.EntityNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<EntityNotification, Long> {
}
