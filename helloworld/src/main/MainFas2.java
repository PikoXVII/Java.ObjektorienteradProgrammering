package main;
import Explorers.*;
import missions.*;
import vehicles.*;


public class MainFas2 {
	public static void main(String[]  args) {
		System.out.println("***** Welcome to the Space Exploration Program! *****");
		System.out.println();
		System.out.println("Setting Up Rockets, Missions, and Teams");
		System.out.println();

		Rocket rocket1 = new Rocket();
		Rocket rocket2 = new Rocket();

		ExplorationMission moonMission = new ExplorationMission("Moon Base Construction", "Moon", 90, rocket1);
		moonMission.setName("Moon Base Contruction");

		MaintenanceMission issMission = new MaintenanceMission("ISS Power System Repair", "International Space Station", 20, rocket2);
		issMission.setName("ISS Power System Repair");




		SpaceExplorer[] moonTeam = {
				new Astronaut("Luna", moonMission),
				new Engineer("Max", moonMission),
				new Pilot("Zara", moonMission)
		};

		SpaceExplorer[] issTeam = {
				new Astronaut("Oliver", issMission),
				new Engineer("Emily", issMission),
				new Pilot("Noah", issMission)
		};

		Commander commander1 = new Commander("Alex", moonMission, moonTeam);
		Commander commander2 = new Commander("Mia", issMission, issTeam);


		System.out.println("Moon Team is lead by Commander " + commander1.getName() + "  ID:" + commander1.getId());
		System.out.println("\nTeam members are:\n");
		for (int i = 0; i < moonTeam.length; i++) {
			System.out.println("- ID: " + moonTeam[i].getId() + " | Name: " + moonTeam[i].getName() +  " | Rank: " + moonTeam[i].getRank() + " | Mission: " + moonTeam[i].getMission().getName());
		}

		System.out.println();

		System.out.println("ISS Team is lead by Commander " + commander2.getName() + "  ID:" + commander2.getId());
		System.out.println();
		System.out.println("Team members are:");
		System.out.println();
		for (int i = 0; i < issTeam.length; i++) {
			System.out.println("- ID: " + issTeam[i].getId() + " | Name: " + issTeam[i].getName() +   " | Rank: " + issTeam[i].getRank() + " | Mission: " + issTeam[i].getMission().getName());
	
		}

		System.out.println();

		System.out.println(":::: Team 1: Launching Moon Mission! ::::");
		System.out.println();
		commander1.performDuty();

		System.out.println();
		System.out.println(":::: Team 2: Launching ISS Repair Mission! ::::");
		System.out.println();
		commander2.performDuty();
	}

}


