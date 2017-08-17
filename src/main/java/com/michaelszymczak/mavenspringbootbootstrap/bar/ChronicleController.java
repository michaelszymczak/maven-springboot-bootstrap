package com.michaelszymczak.mavenspringbootbootstrap.bar;

import foo.PostalCodeRange;
import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.values.Values;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChronicleController {

    private final ChronicleMap<CharSequence, PostalCodeRange> cityPostalCodes;

    public ChronicleController() {
        cityPostalCodes = ChronicleMap
                .of(CharSequence.class, PostalCodeRange.class)
                .name("city-postal-codes-map")
                .averageKey("Amsterdam")
                .entries(50_000)
                .create();
    }

    @RequestMapping("/chronicle")
    public String index() {

        final PostalCodeRange before = cityPostalCodes.get("foo");

        PostalCodeRange postalCodeRange = Values.newHeapInstance(PostalCodeRange.class);
        postalCodeRange.minCode(5);
        postalCodeRange.maxCode(7);
        cityPostalCodes.put("foo", postalCodeRange);

        PostalCodeRange after = cityPostalCodes.get("foo");

        return String.format("Up and running. Before: %s, after: %s",  before, after);
    }

}
