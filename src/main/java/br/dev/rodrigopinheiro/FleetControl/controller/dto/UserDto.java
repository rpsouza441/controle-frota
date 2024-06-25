package br.dev.rodrigopinheiro.FleetControl.controller.dto;


import br.dev.rodrigopinheiro.FleetControl.entity.UserEntity;

public record UserDto(
        String email,
        String password,
        boolean active
) {
    public UserEntity toUser() {
        return UserEntity.builder()
                .email(email)
                .password(password)
                .active(active)
                .build();
    }

    public UserDto fromUser(UserEntity userEntity) {
        return new UserDto(userEntity.getEmail(),userEntity.getPassword(),userEntity.getActive());
    }
}
