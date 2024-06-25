package br.dev.rodrigopinheiro.FleetControl.controller;

import br.dev.rodrigopinheiro.FleetControl.controller.dto.UserDto;
import br.dev.rodrigopinheiro.FleetControl.entity.UserEntity;
import br.dev.rodrigopinheiro.FleetControl.service.UserEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserControler {

    private final UserEntityService userEntityService;

    public UserControler(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserDto userDTO) {
        if (!userDTO.email().endsWith("@xyz.com") && !userDTO.email().endsWith("@rps.com")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(userEntityService.saveUser(userDTO));
    }
}
