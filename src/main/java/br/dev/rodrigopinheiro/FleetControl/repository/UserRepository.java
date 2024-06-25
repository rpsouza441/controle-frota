package br.dev.rodrigopinheiro.FleetControl.repository;

import br.dev.rodrigopinheiro.FleetControl.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
}
