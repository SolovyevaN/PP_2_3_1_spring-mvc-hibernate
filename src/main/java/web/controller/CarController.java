package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.CarService.CarServiceImp;
import web.Model.Car;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarServiceImp carService;

    @GetMapping("/")
    public String listCar(@RequestParam(defaultValue = "100") int count, Model model) {
        List<Car> cars = carService.listCar();
        if (count < cars.size()) {
            cars = cars.subList(0, count);
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
