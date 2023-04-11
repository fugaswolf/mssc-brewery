package guru.springframework.msscbrewery.services.v2;

import guru.springframework.msscbrewery.web.model.CoffeeDto;
import guru.springframework.msscbrewery.web.model.v2.CoffeeDtoV2;

import java.util.UUID;

public interface CoffeeServiceV2 {
    CoffeeDtoV2 getCoffeeId(UUID coffeeId);

    CoffeeDtoV2 saveNewCoffee(CoffeeDtoV2 coffeeDto);

    void updateCoffee(UUID coffeeId, CoffeeDtoV2 coffeeDto);

    void deleteById(UUID coffeeId);
}
