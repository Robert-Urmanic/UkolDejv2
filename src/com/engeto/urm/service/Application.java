package com.engeto.urm.service;

import com.engeto.urm.dto.*;
import com.engeto.urm.dao.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Application {
    public static void run() {
        InitialDemoData initialDemoData = new InitialDemoData();
        initialDemoData.initialisation();
        Scanner s = new Scanner(System.in);
        Route route = null;
        System.out.println("Chcete vyhledávat lodě? Y/n");

        String decision = s.next();
        boolean spatnyUdaj = true;
        if ("Y".equals(decision.toUpperCase())) {
            while (spatnyUdaj) {

                System.out.println("Zadejte ID, nebo jméno lodě: ");
                String NameIDDecision = s.next();
                try {
                    spatnyUdaj = vyhledejID(initialDemoData, spatnyUdaj, NameIDDecision);
                } catch (NumberFormatException e) {
                    for (Ship tempShip : initialDemoData.getListOfShips()) {
                        if (tempShip.getName().equals(NameIDDecision)) {
                            System.out.println(tempShip);
                            spatnyUdaj = false;
                        }
                    }
                }
                vytiskniSpatneIDNeboJmenoLode(spatnyUdaj, NameIDDecision);
            }
        } else System.exit(80085);
        boolean spatnyNazevPristavu = true;

        while (spatnyNazevPristavu) {
            try {
                Scanner scanPort = new Scanner(System.in);
                System.out.println("Napiš přístav, ze kterého loď vyjíždí:");
                Port port1 = Port.valueOf(scanPort.next());
                System.out.println("Napiš přístav, do kterého loď přijede:");
                Port port2 = Port.valueOf(scanPort.next());
                spatnyNazevPristavu = false;
                System.out.println("Zadejte vzdálenost, kterou loď urazí: ");
                BigDecimal distanceToTravel = scanPort.nextBigDecimal();
                spatnyUdaj = true;
                while (spatnyUdaj) {
                    System.out.println("Zadejte ID, nebo jméno lodě: ");
                    String NameIDDecision = s.next();
                    try {
                        spatnyUdaj = vyhledejID(initialDemoData, spatnyUdaj, NameIDDecision);
                        if (spatnyUdaj == false) {
                            Integer id = Integer.parseInt(NameIDDecision);
                            System.out.println("Chcete spustit simulaci?");
                            String simulace = s.next();
                            if ("Y".equals(simulace.toUpperCase())) {
                                route = new Route(port1, port2, distanceToTravel, id, initialDemoData.getListOfShips());
                                System.out.println(route);
                            } else System.exit(69);
                        }
                        vytiskniSpatneIDNeboJmenoLode(spatnyUdaj, NameIDDecision);
                    } catch (NumberFormatException ex) {
                        System.err.println("Zadali jste špatně ID lodě...");
                        System.out.println("Chcete to zkusit znovu? Y/n");
                        String opakovat = s.next();
                        if ("Y".equals(opakovat.toUpperCase())) {
                            spatnyNazevPristavu = true;
                        } else System.exit(789);
                    } catch (IllegalArgumentException ex) {
                        System.err.println("Vzdálenost nesmí být negativní, nebo rovna 0");
                        System.out.println("Chcete to zkusit znovu? Y/n");
                        String opakovat = s.next();
                        if ("Y".equals(opakovat.toUpperCase())) {
                            spatnyNazevPristavu = true;
                        } else System.exit(420);
                    } catch (IllegalCallerException ex) {
                        System.err.println("Destinace nesmí být totožné");
                        System.out.println("Seznam přístavů:");
                        System.out.println(java.util.Arrays.asList(Port.values()));
                        System.out.println("Chcete to zkusit znovu? Y/n");
                        String opakovat = s.next();
                        if ("Y".equals(opakovat.toUpperCase())) {
                            spatnyNazevPristavu = true;
                        } else System.exit(4);
                    }
                }

            } catch (IllegalArgumentException e) {
                System.err.println("Zvolili jste špatný přístav...");
                System.out.println("Seznam přístavů:");
                System.out.println(java.util.Arrays.asList(Port.values()));
                System.out.println("Chcete to zkusit znovu? Y/n");
                String opakovat = s.next();
                if ("N".equals(opakovat.toUpperCase())) {
                    System.exit(5318008);
                }
            }
        }
        String tempHold = "";
        for (Ship tempS: initialDemoData.getListOfShips()) {
            tempHold += tempS;
        }
        try (PrintWriter out = new PrintWriter("vystup.txt")) {
            out.println(tempHold);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void vytiskniSpatneIDNeboJmenoLode(boolean spatnyUdaj, String NameIDDecision) {
        if (spatnyUdaj == true) {
            System.out.println("Loď s jménem či ID: " + NameIDDecision + " neexistuje.");
        }
    }

    private static boolean vyhledejID(InitialDemoData initialDemoData, boolean spatnyUdaj, String NameIDDecision) {
        int idLode = Integer.parseInt(NameIDDecision);

        for (Ship tempShip : initialDemoData.getListOfShips()) {
            if (tempShip.getId() == idLode) {
                System.out.println(tempShip);
                spatnyUdaj = false;
            }
        }
        return spatnyUdaj;
    }


}

