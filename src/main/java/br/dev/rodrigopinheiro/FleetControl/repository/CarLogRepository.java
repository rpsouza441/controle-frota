package br.dev.rodrigopinheiro.FleetControl.repository;

import br.dev.rodrigopinheiro.FleetControl.entity.CarLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarLogRepository extends JpaRepository<CarLog, Long> {
}
