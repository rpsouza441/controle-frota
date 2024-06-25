package br.dev.rodrigopinheiro.FleetControl.controller.dto;

import br.dev.rodrigopinheiro.FleetControl.entity.enums.CarAction;

public record CarLogDto(
         Long carId,
         Long userId,
         CarAction action,
         Long mileage
) {
}
