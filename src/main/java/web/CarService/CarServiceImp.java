package web.CarService;

import org.springframework.stereotype.Service;
import web.Model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService {
    @Override
    public List<Car> listCar() {
        return List.of(
                new Car("Toyota", "Black", 2023),
                new Car("BMW", "White", 2021),
                new Car("Tesla", "Blue", 2019),
                new Car("Opel", "Red", 2015),
                new Car("Ford", "Grey", 2020)
        );
    }
}
