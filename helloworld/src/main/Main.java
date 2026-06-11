
/*
package main;

import Explorers.Astronaut;
import Explorers.Engineer;
import Explorers.Pilot;
import Explorers.SpaceExplorer;

public class Main {
	public static void main(String[] args) {
		System.out.println("*** Welcome to the Space Exploration Program! ***");
		System.out.println("============================");
        System.out.println("Starting Phase 1: Explorers");
        System.out.println("============================");
        System.out.println("--- Creating Explorers (Phase 1) ---\n");
        
        Astronaut jalle = new Astronaut("Jalle", "Moon Exploration");
        Engineer johannes = new Engineer("Johannes", "Reperator");
        Pilot abbe = new Pilot("Abbe", "Navigator");
        
        SpaceExplorer[] explorers = {jalle, johannes, abbe};
        
        System.out.println("List of Explorers: ");
        System.out.println("");
        
        for(int i = 0; i < explorers.length; i++) {
        	System.out.println("- ID: " + explorers[i].getId() + " | Name: " + explorers[i].getName() + " | Rank: " + explorers[i].getRank() + " | Mission: " + explorers[i].getMission());
        }
        System.out.println("");
        System.out.println("Lanching missions...");
        System.out.println("");
        
        for(int i = 0; i < explorers.length; i++) {
        	explorers[i].startMission();
        }
        System.out.println("");
        System.out.println("Explorer reporting stautes ...");
        System.out.println("");
        
        for(int i = 0; i < explorers.length; i++) {
        	explorers[i].reportStatus();
        }
        System.out.println("");
        System.out.println("Mission Completed");
        System.out.println("");
        
        for(int i = 0; i < explorers.length; i++) {
        	explorers[i].completeMission();
        }
        
        
		
	}

}



:::::::::::::SAMPLE OUTPUT:::::::::::::::
	*** Welcome to the Space Exploration Program! ***
	============================
	Starting Phase 1: Explorers
	============================
	--- Creating Explorers (Phase 1) --
*/