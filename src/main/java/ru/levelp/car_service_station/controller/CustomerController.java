package ru.levelp.car_service_station.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.levelp.car_service_station.repository.CustomerRepo;
import ru.levelp.car_service_station.model.Customers;
import ru.levelp.car_service_station.repository.CustomerStatusRepo;
import ru.levelp.car_service_station.repository.GenderRepo;
import ru.levelp.car_service_station.utils.PaginationParams;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.hasText;

@AllArgsConstructor
@Controller
@RequestMapping({"/customers"})
public class CustomerController {

    private CustomerRepo customerRepo;
    private CustomerStatusRepo statusRepo;
    private GenderRepo genderRepo;

    @GetMapping("")
    public String index(@RequestParam(value = "page", required = false, defaultValue = "1") Integer pageParam,
                        @RequestParam(value = "q", required = false, defaultValue = "") String query,
                        Model model) {

        PageRequest pageRequest = PageRequest.of(pageParam - 1, 10);

        String queryString = query.trim();

        Page<Customers> customers = hasText(queryString) ?
                customerRepo.findContact(queryString, pageRequest)
                : customerRepo.findAll(pageRequest);

        model.addAttribute("customers", customers.stream().collect(Collectors.toList()));
        model.addAttribute("query", query);
        model.addAttribute("genders", genderRepo.findAll(Sort.by(Sort.Direction.ASC, "id")));

        PaginationParams<Customers> paginationParams = new PaginationParams<>(customers);
        model.addAllAttributes(paginationParams.getParams(pageParam));

        return "customers";
    }

    @Transactional
    @PostMapping("/addNewCustomer")
    public @ResponseBody String addNewCustomer (@RequestParam String firstName,
                                                @RequestParam String lastName,
                                                @RequestParam String email,
                                                @RequestParam String phone,
                                                @RequestParam Long genderId)
    {
        Customers customer = new Customers();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setStatus(statusRepo.getOne(1L));
        customer.setGender(genderRepo.getOne(genderId));

        customerRepo.save(customer);

        return "Новый клиент успешно сохранён!";
    }

    @GetMapping("/findAll")
    public @ResponseBody Iterable<Customers> getAllCustomers() {
        return customerRepo.findAll();
    }

    @GetMapping("/findById")
    public @ResponseBody Optional<Customers> findById(long id) {
        return customerRepo.findById(id);
    }

    @GetMapping("/findAllById")
    public @ResponseBody Iterable<Customers> findAllById(Iterable<Long> ids) {
        return customerRepo.findAllById(ids);
    }

    @GetMapping("/deleteById")
    public @ResponseBody String deleteById(@ModelAttribute("id") long id) {
        customerRepo.deleteById(id);
        return "Клиент по id " + id + " удалён!";
    }

    @GetMapping("/deleteAll")
        public @ResponseBody String deleteAll() {
        customerRepo.deleteAll();
        return "Все клиенты удалены!";
    }

    @GetMapping("/count")
    public @ResponseBody long count() {
        return customerRepo.count();
    }

}
