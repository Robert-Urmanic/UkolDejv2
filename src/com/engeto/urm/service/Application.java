package com.engeto.urm.service;

import com.engeto.urm.dto.*;
import com.engeto.urm.dao.*;

import java.util.Scanner;

public class Application {
    public static void run() {
        InitialDemoData initialDemoData = new InitialDemoData();
        initialDemoData.initialisation();
        Scanner s = new Scanner(System.in);

        System.out.println("Chcete vyhledávat lodě? Y/n");

        String decision = s.next();
        boolean spatnyUdaj = true;
        if ("Y".equals(decision.toUpperCase())) {
            while (spatnyUdaj) {

                System.out.println("Zadejte ID, nebo jméno: ");
                String NameIDDecision = s.next();
                try {
                    int idLode = Integer.parseInt(NameIDDecision);

                    for (Ship tempShip : initialDemoData.getListOfShips()) {
                        if (tempShip.getId() == idLode) {
                            System.out.println(tempShip);
                            spatnyUdaj = false;
                        }
                    }
                } catch (NumberFormatException e) {
                    for (Ship tempShip : initialDemoData.getListOfShips()) {
                        if (tempShip.getName().equals(NameIDDecision)) {
                            System.out.println(tempShip);
                            spatnyUdaj = false;
                        }
                    }
                }
                if (spatnyUdaj == true) {
                    System.out.println("Loď s jménem či ID: " + NameIDDecision + " neexistuje.");
                }
            }
        }
    }
}
