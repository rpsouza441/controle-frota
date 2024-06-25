package br.dev.rodrigopinheiro.FleetControl.controller.dto;


public record UserDto(
        String email,
        String password,
        boolean isActive
) {
}
