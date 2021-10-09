package ru.levelp.mysimplecrm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorController {

    @GetMapping("/sum/{value1}/{value2}")
    public String sum(@PathVariable("value1") double value1, @PathVariable("value2") double value2) {
        return "Сумма введенных чисел = " + (value1 + value2);
//            if (value1 % 1 == 0 && value2 % 1 == 0) {
//                return "Сумма введенных чисел = " + (value1 + value2);
//            } else {
//                return "Вы ввели не целое число!";
//            }
    }

    @GetMapping("/diff/{value1}/{value2}")
    public String diff(@PathVariable("value1") double value1, @PathVariable("value2") double value2) {
        return "Разность введенных чисел = " + (value1 - value2);
    }

    @GetMapping("/multiply/{value1}/{value2}")
    public String multiply(@PathVariable("value1") double value1, @PathVariable("value2") double value2) {
        return "Произведение введенных чисел = " + (value1 * value2);
    }

    @GetMapping("/divide/{value1}/{value2}")
    public String divide(@PathVariable("value1") double value1, @PathVariable("value2") double value2) {
        return "Деление введенных чисел = " + (value1 / value2);
    }

}
