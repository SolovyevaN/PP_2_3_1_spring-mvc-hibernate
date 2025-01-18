package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.CarService.CarServiceImp;
import web.Model.Car;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarServiceImp carService;

    @GetMapping("/")
    public String listCar (@RequestParam (defaultValue = "5") int count, Model model){
        List<Car> cars = carService.listCar();
        if(count >= 5){
            model.addAttribute("cars", cars);
        }else {
            model.addAttribute("cars", cars.subList(0, Math.min(count,cars.size())));
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
