package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CoffeeDto;

import java.util.UUID;

public interface CoffeeService {

    CoffeeDto getCoffeeId(UUID coffeeId);

    CoffeeDto saveNewCoffee(CoffeeDto coffeeDto);

    void updateCoffee(UUID coffeeId, CoffeeDto coffeeDto);

    void deleteById(UUID coffeeId);
}
