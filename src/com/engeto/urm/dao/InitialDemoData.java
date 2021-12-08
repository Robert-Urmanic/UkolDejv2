package com.engeto.urm.dao;

import com.engeto.urm.dto.Cargo;
import com.engeto.urm.dto.Ship;
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
            ship.setAverageSpeed(ship.getRandomNumber(30,100));
            listOfShips.add(ship);
            for (int j = 1; j <= 2; j++) {
                Cargo cargo = new Cargo();
                cargo.setId(i*j);
                // TODO: 07.12.2021 opravit číslo ID carga 
                cargo.setDescription(description[random.nextInt(description.length)]);
                cargo.setWeight(new Random().nextInt(1001));
                listOfCargo.add(cargo);
                temporaryListOfCargo.add(cargo);
            }
            ship.setSeznamCargo(temporaryListOfCargo);
            temporaryListOfCargo.clear();
        }

        //System.out.println(listOfShips);

    }
    private static String[] description = {
            "Descripton 1",
            "Descripton 2",
            "Descripton 3",
            "Descripton 4",
            "Descripton 5",
            "Descripton 6",
    };
    private static String[] names = {
            "Liam",
            "Olivia",
            "Noah",
            "Emma",
            "Oliver",
            "Ava",
            "William",
            "Sophia",
            "Elijah",
            "Isabella",
            "James",
            "Charlotte",
            "Benjamin",
            "Amelia",
            "Lucas",
            "Mia",
            "Mason",
            "Harper",
            "Ethan",
            "Evelyn"
    };
}
