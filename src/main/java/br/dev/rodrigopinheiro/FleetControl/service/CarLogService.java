package br.dev.rodrigopinheiro.FleetControl.service;

import br.dev.rodrigopinheiro.FleetControl.controller.dto.CarLogDto;
import br.dev.rodrigopinheiro.FleetControl.entity.CarLog;
import br.dev.rodrigopinheiro.FleetControl.repository.CarLogRepository;
import org.springframework.stereotype.Service;

@Service
public class CarLogService {

    private final CarLogRepository carLogRepository;

    public CarLogService(CarLogRepository carLogRepository) {
        this.carLogRepository = carLogRepository;
    }

    public CarLog createCarLog(CarLogDto carLogDTO) {
        //TODO search car and user  to sabe log

        CarLog carLog = new CarLog();

        return carLogRepository.save(carLog);
    }
}
