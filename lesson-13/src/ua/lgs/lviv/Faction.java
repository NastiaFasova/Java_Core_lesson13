package ua.lgs.lviv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Faction {

	private ArrayList<Deputy> deputy = new ArrayList<>();
	private String name;

	public void addDeputy() {
		Scanner scan = new Scanner(System.in);
		System.out.println(
				"Enter a weight, a height, a name, a surname, and an age of a deputy. Don't forget to tell whether he's a barrator");

		int weight = scan.nextInt();
		double height = scan.nextDouble();
		String name = scan.next();
		String surname = scan.next();
		int age = scan.nextInt();
		boolean barrator = scan.nextBoolean();
		Deputy dep = new Deputy(height, weight, name, surname, age, barrator);
		deputy.add(dep);
		dep.giveBribe();
	}

	public void removeDeputy(String surname) {
		Scanner scan = new Scanner(System.in);
		Iterator<Deputy> iterator = deputy.iterator();
		while (iterator.hasNext()) {
			Deputy next = iterator.next();
			if (next.getSurname().equalsIgnoreCase(surname)) {
				iterator.remove();
			}
		}
	}

	public Faction() {
		super();
	}

	public void printBarrator() {
		Iterator<Deputy> iterator = deputy.iterator();
		while (iterator.hasNext()) {
			Deputy next = iterator.next();
			if (next.isBarrator()) {
				System.out.println(next + " ");
			}
		}
	}

	public Faction(String name) {
		super();
		this.name = name;
	}

	public void printAllDeputies() {
		Iterator<Deputy> iterator = deputy.iterator();
		if (!iterator.hasNext()) {
			System.out.println("There are no deputies...");
		}
		while (iterator.hasNext()) {
			Deputy next = iterator.next();
			System.out.println(next.toString() + " ");
		}
	}

	public ArrayList<Deputy> getDeputy() {
		return deputy;
	}

	public void setDeputy(ArrayList<Deputy> deputy) {
		this.deputy = deputy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void removeAll() {
		Iterator<Deputy> iterator = deputy.iterator();
		while (iterator.hasNext()) {
			Deputy next = iterator.next();
			iterator.remove();
		}
	}

	public void printGreatestBarrator() {
		int maxMoney = deputy.get(0).getBribe_qty();
		int maxBarrator = 0;
		for (int i = 0; i < deputy.size(); i++) {
			if (deputy.get(i).getBribe_qty() > maxMoney) {
				maxMoney = deputy.get(i).getBribe_qty();
				maxBarrator = i;
			}
		}
		System.out.println("The greatest barrator: ");
		for (int i = 0; i < deputy.size(); i++) {
			if (maxBarrator == i) {
				System.out.println(deputy.get(i).toString());
			}
		}
	}

}
