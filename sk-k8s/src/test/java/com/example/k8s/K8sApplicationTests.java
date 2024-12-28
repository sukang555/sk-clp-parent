package com.example.k8s;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;


class K8sApplicationTests {

    @Test
    void contextLoads() {

        Period period = Period.between(
                LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 6, 1)
        );

        int months = period.getMonths() + period.getYears() * 12;
        System.out.println(months);

        int sinceYear = new BigDecimal(months).divide(new BigDecimal(12), BigDecimal.ROUND_HALF_DOWN).intValue();

        System.out.println(sinceYear);
    }

}
