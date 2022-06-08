package web.controller;

import Service.CarService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
@Controller
public class CarController {
    @GetMapping("/cars")
    public String cars(@RequestParam(value = "count", defaultValue = "5") int allCars, Model model) {
        List<Car> list = new ArrayList<>();
        list.add(new Car(1, "BMW", "blue"));
        list.add(new Car(2, "MERCEDES", "red"));
        list.add(new Car(3, "AUDI", "green"));
        list.add(new Car(4, "KIA", "black"));
        list.add(new Car(5, "HONDA", "yellow"));
        list = CarService.carsCount(list, allCars);
        model.addAttribute("list", list);
        return "cars";

    }
}