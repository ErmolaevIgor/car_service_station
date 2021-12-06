package ru.levelp.mysimplecrm.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.levelp.mysimplecrm.repository.CustomerCarsRepo;
import ru.levelp.mysimplecrm.model.CustomerCars;
import ru.levelp.mysimplecrm.utils.PaginationParams;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.hasText;

@AllArgsConstructor
@Controller
@RequestMapping("/customer_cars")
public class CustomerCarsController {

    private CustomerCarsRepo customerCarsRepo;

    @GetMapping("")
    public String index(@RequestParam(value = "page", required = false, defaultValue = "1") Integer pageParam,
                        @RequestParam(value = "q", required = false, defaultValue = "") String query,
                        Model model) {

        PageRequest pageRequest = PageRequest.of(pageParam - 1, 10);

        String queryString = query.trim();

        Page<CustomerCars> customerCars = hasText(queryString) ?
                customerCarsRepo.findCar(queryString, pageRequest)
                : customerCarsRepo.findAll(pageRequest);

        model.addAttribute("customer_cars", customerCars.stream().collect(Collectors.toList()));
        model.addAttribute("query", query);

        PaginationParams<CustomerCars> paginationParams = new PaginationParams<>(customerCars);
        model.addAllAttributes(paginationParams.getParams(pageParam));

        return "customer_cars";
    }

    @Transactional
    @PostMapping
    public @ResponseBody String addNewCar(@RequestParam String vinNumber,
                                          @RequestParam String registrationNumber,
                                          @RequestParam String brand,
                                          @RequestParam String model,
                                          @RequestParam String engineModification,
                                          @RequestParam String yearOfIssue,
                                          @RequestParam String mileage)
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
        return "Машина по id " + id + " удалёна!";
    }

}
