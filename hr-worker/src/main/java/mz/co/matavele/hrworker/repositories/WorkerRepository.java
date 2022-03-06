package mz.co.matavele.hrworker.repositories;

import mz.co.matavele.hrworker.entities.Worker;
import org.hibernate.jdbc.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
