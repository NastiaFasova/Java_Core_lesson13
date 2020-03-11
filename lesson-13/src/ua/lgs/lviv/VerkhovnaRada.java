package ua.lgs.lviv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class VerkhovnaRada {
	private static VerkhovnaRada instance;

	private static VerkhovnaRada getInstance() {
		if (instance == null)
			synchronized (VerkhovnaRada.class) {
				if (instance == null) {
					instance = new VerkhovnaRada();
				}
			}
		return instance;
	}

	private ArrayList<Faction> factions = new ArrayList<>();
	private ArrayList<Deputy> deputy = new ArrayList<>();

	public void addFaction() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a faction you would like to add: ");
		String factionName = scan.next();
		factions.add(new Faction(factionName));
	}

	public void removeFaction() {
		Scanner scan = new Scanner(System.in);
		Iterator<Faction> iterator = factions.iterator();
		System.out.println("Enter a faction you would like to remove: ");
		String factionName = scan.next();
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getName().equalsIgnoreCase(factionName)) {
				iterator.remove();
			}
		}
	}

	public void printAllFactions() {
		Iterator<Faction> iterator = factions.iterator();
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			System.out.println(next.getName() + " ");
		}
	}

	public ArrayList<Faction> getFactions() {
		return factions;
	}

	public void setFactions(ArrayList<Faction> factions) {
		this.factions = factions;
	}

	public void printFaction() {
		Scanner scan = new Scanner(System.in);
		Iterator<Faction> iterator = factions.iterator();
		System.out.println("Enter the faction the information about which you would like to print: ");
		String factionName = scan.next();
		for (int i = 0; i < factions.size(); i++) {
			if (factions.get(i).getName().equalsIgnoreCase(factionName)) {
				factions.get(i).printAllDeputies();
			}
		}
	}

	public void addDeputyToFraction() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a faction you would like to add the deputy: ");
		String factionName = scan.next();
		for (int i = 0; i < factions.size(); i++) {
			if (factions.get(i).getName().equalsIgnoreCase(factionName)) {
				factions.get(i).addDeputy();
			}
		}

	}

	public void removeDeputy() {
		Scanner scan = new Scanner(System.in);
		Iterator<Deputy> iteratorDeputy = deputy.iterator();
		System.out.println("Enter a surname of a deputy you would like to remove: ");
		String surname = scan.next();
		for (int i = 0; i < factions.size(); i++) {
			for (int j = 0; j < factions.get(i).getDeputy().size(); j++) {
				if (factions.get(i).getDeputy().get(j).getSurname().equalsIgnoreCase(surname)) {
					factions.get(i).removeDeputy(surname);
				} else {
					System.out.println("This faction is absent...");
				}
			}

		}

	}

	public void printBarratorsFromFaction() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a faction. You'll see all its barrators");
		String nameFaction = scan.next();
		for (int i = 0; i < factions.size(); i++) {
			if (factions.get(i).getName().equalsIgnoreCase(nameFaction)) {
				factions.get(i).printBarrator();
			}
		}
	}

	public void printGreatestBarratorFromFaction() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a faction. You'll see its greatest barrator");
		String nameFaction = scan.next();
		for (int i = 0; i < factions.size(); i++) {
			if (factions.get(i).getName().equalsIgnoreCase(nameFaction)) {
				factions.get(i).printGreatestBarrator();
			}
		}
	}

	public void printDeputiesOfFaction() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a faction. You'll see all its deputies");
		String nameFaction = scan.next();
		for (int i = 0; i < factions.size(); i++) {
			if (factions.get(i).getName().equalsIgnoreCase(nameFaction)) {
				factions.get(i).printAllDeputies();
			}
		}
	}

}
