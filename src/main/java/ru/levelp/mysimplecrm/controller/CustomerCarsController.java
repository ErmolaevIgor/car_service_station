package ru.levelp.mysimplecrm.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.levelp.mysimplecrm.repository.CustomerCarsRepo;
import ru.levelp.mysimplecrm.model.CustomerCars;

@AllArgsConstructor
@Controller
@RequestMapping("/customer_cars")
public class CustomerCarsController {

    private final CustomerCarsRepo customerCarsRepo;

    @PostMapping("/addNewCar")
    public @ResponseBody String addNewCar(@RequestParam String vinNumber,
                                          @RequestParam String registrationNumber,
                                          @RequestParam String brand,
                                          @RequestParam String model,
                                          @RequestParam String engineModification,
                                          @RequestParam Short yearOfIssue,
                                          @RequestParam Long mileage)
    {
        CustomerCars customerCars = new CustomerCars();
        customerCars.setVinNumber(vinNumber);
        customerCars.setRegistrationNumber(registrationNumber);
        customerCars.setBrand(brand);
        customerCars.setModel(model);
        customerCars.setEngineModification(engineModification);
        customerCars.setYearOfIssue(yearOfIssue);
        customerCars.setMileage(mileage);
        customerCarsRepo.save(customerCars);
        return "Новая машина успешно добавлена!";
    }

    @GetMapping("/findAll")
    public @ResponseBody Iterable<CustomerCars> getAllCars() {
        return customerCarsRepo.findAll();
    }

    @GetMapping("/deleteById")
    public @ResponseBody String deleteById(@ModelAttribute("id") long id) {
        customerCarsRepo.deleteById(id);
        return "Клиент по id " + id + " удалён!";
    }

}
