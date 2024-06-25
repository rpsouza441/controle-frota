package br.dev.rodrigopinheiro.FleetControl.repository;

import br.dev.rodrigopinheiro.FleetControl.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
