package br.dev.rodrigopinheiro.FleetControl.service;

import br.dev.rodrigopinheiro.FleetControl.controller.dto.CarDto;
import br.dev.rodrigopinheiro.FleetControl.entity.CarLog;
import br.dev.rodrigopinheiro.FleetControl.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }



    public CarLog create(CarDto carDto) {
        return null;
    }
}
