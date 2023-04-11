package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CoffeeService;
import guru.springframework.msscbrewery.web.model.CoffeeDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


//@Deprecated
@RequestMapping("/api/v1/coffee")
@RestController
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService){
        this.coffeeService = coffeeService;
    }

    @GetMapping("/{coffeeId}")
    public ResponseEntity<CoffeeDto> getCoffee(@PathVariable("coffeeId") UUID coffeeId){
        return new ResponseEntity<>(coffeeService.getCoffeeId(coffeeId), HttpStatus.OK);
    }

    @PostMapping// Post - create new coffee
    public ResponseEntity handlePost(@RequestBody CoffeeDto coffeeDto){
        CoffeeDto savedDto = coffeeService.saveNewCoffee(coffeeDto);

        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to url
        headers.add("Location","/api/v1/coffee/" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{coffeeId}")
    public ResponseEntity handleUpdate(@PathVariable("coffeeId") UUID coffeeId, @RequestBody CoffeeDto coffeeDto) {
        coffeeService.updateCoffee(coffeeId, coffeeDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("/{coffeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoffee(@PathVariable("coffeeId") UUID coffeeId) {
        coffeeService.deleteById(coffeeId);
    }
}
