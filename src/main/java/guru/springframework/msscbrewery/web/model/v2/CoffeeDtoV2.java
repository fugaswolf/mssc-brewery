package guru.springframework.msscbrewery.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeDtoV2 {

    private UUID id;
    private String coffeeName;
    private CoffeeStyleEnum coffeeStyle;
    private Long upc;

}
