package web.CarService;


import web.Model.Car;

import java.util.List;

public interface CarService {
    List<Car> listCar();
    int getCarCount(List<Car> cars);
}
