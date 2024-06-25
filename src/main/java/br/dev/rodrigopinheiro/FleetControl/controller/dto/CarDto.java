package br.dev.rodrigopinheiro.FleetControl.controller.dto;

import br.dev.rodrigopinheiro.FleetControl.entity.enums.CarAction;

public record CarDto (
        Long cardId,
        Long userId,
        CarAction action,
        Long milage
) {
}
