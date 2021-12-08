package com.engeto.urm.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Route {
    private Integer id;
    private Port startPort;
    private Port targetPort;
    private BigDecimal distance;
    private LocalDate travelTime;
    // TODO: 07.12.2021 id lodě 
    private Integer ship_id;

    public BigDecimal timeOfTravel(List<Ship> listOfShips) {
        BigDecimal minusovaRychlostKvuliNakladu1 = new BigDecimal(listOfShips.get(ship_id).getSeznamCargo().get(0).getWeight());
        minusovaRychlostKvuliNakladu1 = minusovaRychlostKvuliNakladu1.divide(new BigDecimal(100));
        BigDecimal minusovaRychlostKvuliNakladu2 = new BigDecimal(listOfShips.get(ship_id).getSeznamCargo().get(1).getWeight());
        minusovaRychlostKvuliNakladu2 = minusovaRychlostKvuliNakladu2.divide(new BigDecimal(100));
        BigDecimal minusovaRychlostKvuliNakladu3 = new BigDecimal(0);
        minusovaRychlostKvuliNakladu3 = minusovaRychlostKvuliNakladu1.add(minusovaRychlostKvuliNakladu2);
        BigDecimal prumernaRychlost = listOfShips.get(ship_id).getAverageSpeed().subtract(minusovaRychlostKvuliNakladu3);
        return distance.divide(prumernaRychlost);
    }
}
