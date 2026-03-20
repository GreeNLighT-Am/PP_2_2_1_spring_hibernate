package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarDao carDao;

    @Override
    @Transactional
    public void add(Car car) {
        carDao.add(car);
    }
}
