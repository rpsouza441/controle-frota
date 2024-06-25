package br.dev.rodrigopinheiro.FleetControl.service;

import br.dev.rodrigopinheiro.FleetControl.controller.dto.UserDto;
import br.dev.rodrigopinheiro.FleetControl.entity.UserEntity;
import br.dev.rodrigopinheiro.FleetControl.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {

    private final UserRepository userRepository;

    public UserEntityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUser(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setEmail(userDto.email());
        user.setPassword(new BCryptPasswordEncoder().encode(userDto.password()));
        user.setActive(userDto.isActive());
        // Adicionar lógica para roles
        return userRepository.save(user);
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
