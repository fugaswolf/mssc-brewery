package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CoffeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Slf4j
@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Override
    public CoffeeDto getCoffeeId(UUID coffeeId) {
        return CoffeeDto.builder().id(UUID.randomUUID()).coffeeName("Frappucino").coffeeStyle("Double").build();
    }

    @Override
    public CoffeeDto saveNewCoffee(CoffeeDto coffeeDto) {
        return CoffeeDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCoffee(UUID coffeeId, CoffeeDto coffeeDto) {
        //todo impl - would add a real impl to update coffee
    }

    @Override
    public void deleteById(UUID coffeeId) {
        //todo impl - would add a real impl to delete coffee
        log.debug("Deleting a coffee...");
    }
}
