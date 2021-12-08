package com.engeto.urm.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

public class Route {
    private UUID uuidRoute;
    private Port startPort;
    private Port targetPort;
    private BigDecimal distance;
    private BigDecimal travelTime;
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
        return distance.divide(prumernaRychlost, 2, RoundingMode.HALF_UP);
    }

    public Route(Port startPort, Port targetPort) {
        this.startPort = startPort;
        this.targetPort = targetPort;
    }

    public Route(Port startPort, Port targetPort, BigDecimal distance, Integer ship_id, List<Ship> listOfShips) {
        this.ship_id = ship_id;
        this.startPort = startPort;
        this.targetPort = targetPort;
        this.distance = distance;
        this.travelTime = timeOfTravel(listOfShips);;
        // TODO: 08.12.2021 zkontrolovat jestli sedí id lodě
        setUuidLode();

    }

    public Integer getShip_id() {
        return ship_id;
    }

    public void setShip_id(Integer ship_id) {
        this.ship_id = ship_id;
    }

    public UUID getUuidRoute() {
        return uuidRoute;
    }

    public void setUuidLode() {
        this.uuidRoute = UUID.randomUUID();
    }

    public Port getStartPort() {
        return startPort;
    }

    public void setStartPort(Port startPort) {
        this.startPort = startPort;
    }

    public Port getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(Port targetPort) {
        this.targetPort = targetPort;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "uuidLode=" + uuidRoute +
                ", startPort=" + startPort +
                ", targetPort=" + targetPort +
                ", distance=" + distance +
                ", travelTime=" + travelTime +
                ", ship_id=" + ship_id +
                '}';
    }
}
