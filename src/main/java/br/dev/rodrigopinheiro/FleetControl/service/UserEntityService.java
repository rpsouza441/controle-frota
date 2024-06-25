package br.dev.rodrigopinheiro.FleetControl.service;

import br.dev.rodrigopinheiro.FleetControl.controller.dto.UserDto;
import br.dev.rodrigopinheiro.FleetControl.entity.UserEntity;
import br.dev.rodrigopinheiro.FleetControl.exception.FleetControlException;
import br.dev.rodrigopinheiro.FleetControl.exception.UserNotFoundException;
import br.dev.rodrigopinheiro.FleetControl.repository.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserEntityService {

    private final UserRepository userRepository;

    public UserEntityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public UserEntity findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }


    public UserDto create(UserDto userDto) {

        //TODO

        var user = userDto.toUser();
        var userCreated = userRepository.save(user);
        return new UserDto( userCreated.getEmail(), userCreated.getPassword(), userCreated.getActive());

    }

    public List<UserDto> findAll() {

        List<UserEntity> users = userRepository.findAll();

        return users.stream()
                .map(user -> new UserDto(user.getEmail(), user.getPassword(), user.getActive()))
                .collect(Collectors.toList());
    }

    public UserDto findById(Long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        return new UserDto(user.getEmail(), user.getPassword(), user.getActive());
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException(id);
        } catch (Exception e) {
            throw new FleetControlException();
        }
    }

    public UserDto update(Long id, UserDto userDto) {
        var updatedUser = userRepository.findById(id).map(existingUser -> {
            existingUser.setName(userDto.email());
            existingUser.setEmail(userDto.password());
            existingUser.setActive(userDto.active());
            return userRepository.save(existingUser);

        }).orElseThrow(() -> new UserNotFoundException(id));
        return userDto.fromUser(updatedUser);
    }

}
