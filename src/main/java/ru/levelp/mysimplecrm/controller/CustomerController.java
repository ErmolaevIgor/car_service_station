package ru.levelp.mysimplecrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.levelp.mysimplecrm.CustomerRepository;
import ru.levelp.mysimplecrm.entity.Customers;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/add")
    public @ResponseBody String addNewCustomer (@RequestParam String name,
                                                @RequestParam String email,
                                                @RequestParam String phone)
    {
        Customers customer = new Customers();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customerRepository.save(customer);
        return "Новый клиент успешно сохранён!";
    }

    @GetMapping("/findAll")
    public @ResponseBody Iterable<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/findById")
    public @ResponseBody Optional<Customers> findById(int id) {
        return customerRepository.findById(id);
    }

    @GetMapping("/findAllById")
    public @ResponseBody Iterable<Customers> findAllById(Iterable<Integer> ids) {
        return customerRepository.findAllById(ids);
    }

    @GetMapping("/deleteById")
    public @ResponseBody String deleteById(@ModelAttribute("id") int id) {
        customerRepository.deleteById(id);
        return "Клиент по id " + id + " удалён!";
    }

    @GetMapping("/deleteAll")
        public @ResponseBody String deleteAll() {
        customerRepository.deleteAll();
        return "Все клиенты удалены!";
    }

    @GetMapping("/count")
    public @ResponseBody long count() {
        return customerRepository.count();
    }

}
