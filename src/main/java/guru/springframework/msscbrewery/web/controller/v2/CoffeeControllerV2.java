package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.services.v2.CoffeeServiceV2;
import guru.springframework.msscbrewery.web.model.v2.CoffeeDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/coffee")
@RestController
public class CoffeeControllerV2 {

    private final CoffeeServiceV2 coffeeService;

    public CoffeeControllerV2(CoffeeServiceV2 coffeeService){
        this.coffeeService = coffeeService;
    }

    @GetMapping("/{coffeeId}")
    public ResponseEntity<CoffeeDtoV2> getCoffee(@PathVariable("coffeeId") UUID coffeeId){
        return new ResponseEntity<>(coffeeService.getCoffeeId(coffeeId), HttpStatus.OK);
    }

    @PostMapping// Post - create new coffee
    public ResponseEntity handlePost(@RequestBody CoffeeDtoV2 coffeeDto){
        CoffeeDtoV2 savedDto = coffeeService.saveNewCoffee(coffeeDto);

        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to url
        headers.add("Location","/api/v1/coffee/" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{coffeeId}")
    public ResponseEntity handleUpdate(@PathVariable("coffeeId") UUID coffeeId, @RequestBody CoffeeDtoV2 coffeeDto) {
        coffeeService.updateCoffee(coffeeId, coffeeDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("/{coffeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoffee(@PathVariable("coffeeId") UUID coffeeId) {
        coffeeService.deleteById(coffeeId);
    }
}
