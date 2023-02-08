package com.middleware;

import com.middleware.dto.CourierPrice;
import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class MiddlewareApplicationTests {

    @Test
    public void testAssertCourierRate() {

        List<CourierPrice> courierPriceList = Arrays.asList(
                new CourierPrice("citylink", 20.0),
                new CourierPrice("jt", 10.0)
        );

        Map<String, Object> map = new HashMap<>();
        map.put("data", courierPriceList);


        //Test equals
        Map<String, Object> expected  = new HashMap<>();

        courierPriceList = Arrays.asList(
                new CourierPrice("citylink", 20.0),
                new CourierPrice("jt", 10.0)
        );
        expected.put("data", courierPriceList);


        //1. Test equal, ignore order
        assertThat(map, is(expected));
    }
}