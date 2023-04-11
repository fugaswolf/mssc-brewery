package guru.springframework.msscbrewery.services.v2;

import guru.springframework.msscbrewery.web.model.CoffeeDto;
import guru.springframework.msscbrewery.web.model.v2.CoffeeDtoV2;
import guru.springframework.msscbrewery.web.model.v2.CoffeeStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Slf4j
@Service
public class CoffeeServiceV2Impl implements CoffeeServiceV2 {
    @Override
    public CoffeeDtoV2 getCoffeeId(UUID coffeeId) {
        return CoffeeDtoV2.builder().id(UUID.randomUUID()).coffeeName("Frappucino").coffeeStyle(CoffeeStyleEnum.DOUBLE).build();
    }

    @Override
    public CoffeeDtoV2 saveNewCoffee(CoffeeDtoV2 coffeeDto) {
        return CoffeeDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCoffee(UUID coffeeId, CoffeeDtoV2 coffeeDto) {
        //todo impl - would add a real impl to update coffee
    }

    @Override
    public void deleteById(UUID coffeeId) {
        //todo impl - would add a real impl to delete coffee
        log.debug("Deleting a coffee...");
    }
}
