package com.engeto.urm.dao;

import com.engeto.urm.dto.Cargo;
import com.engeto.urm.dto.Ship;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.security.SecureRandom;
import java.util.Random;


public class InitialDemoData {
    private static final SecureRandom random = new SecureRandom();

    public List<Ship> getListOfShips() {
        return listOfShips;
    }

    private List<Ship> listOfShips = new ArrayList<>();
    public void initialisation() {

        List<Cargo> temporaryListOfCargo = new ArrayList<>();
        List<Cargo> listOfCargo = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Ship ship = new Ship();
            ship.setId(i);
            ship.setName(names[random.nextInt(names.length)]);
            ship.setCapacity(new Random().nextInt(101));
            ship.setOnWay(new Random().nextBoolean());
            ship.setCountOfTransports(new Random().nextInt(11));
            ship.setAverageSpeed(new BigDecimal(ship.getRandomNumber(30,100)));
            listOfShips.add(ship);
            for (int j = 1; j <= 2; j++) {
                Cargo cargo = new Cargo();
                cargo.setId();
                cargo.setDescription(description[random.nextInt(description.length)]);
                cargo.setWeight(new Random().nextInt(1001));
                listOfCargo.add(cargo);
                temporaryListOfCargo.add(cargo);
            }
            ship.setSeznamCargo(temporaryListOfCargo);
            temporaryListOfCargo.clear();
        }

    }
    private static String[] description = {
            "Přeprava opic",
            "Přeprava denní stravy pro průměrného amerického občana",
            "Přeprava RTX 3090TI",
            "Přeprava \"darů\" CIA do blízkého východu",
            "Přeprava důkazů proti Ferimu",
            "Přeprava trapných vzpomínek, na které si vzpomenete, když jdete spát",
            "Přeprava Jeffreyho Epsteina",
            "Přeprava neprodaných CD Battlefieldu 2042",
    };
    private static String[] names = {
            "Santa Maria",
            "Mayflower",
            "Bismarck",
            "Black Pearl",
            "Empress",
            "Flying Dutchman",
            "Hai Peng",
            "Evergreen",
            "Whiplash",
            "Ryan Gosling",
            "Cheems",
            "Pepe",
            "Doge",
    };
}
