package ua.lgs.lviv;

import java.util.Scanner;

public class Deputy extends Person {

	private String name;
	private String surname;
	private int age;
	private boolean barrator;
	private int bribe_qty;

	public Deputy(double height, int weight, String name, String surname, int age, boolean barrator) {
		super(height, weight);
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.barrator = barrator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBarrator() {
		return barrator;
	}

	public void setBarrator(boolean barrator) {
		this.barrator = barrator;
	}

	public int getBribe_qty() {
		return bribe_qty;
	}

	public void setBribe_qty(int bribe_qty) {
		this.bribe_qty = bribe_qty;
	}

	@Override
	public String toString() {
		return "Deputy [name=" + name + ", surname=" + surname + ", age=" + age + ", barrator=" + barrator
				+ ", bribe_qty=" + bribe_qty + "]";
	}

	public void giveBribe() {
		Scanner scan = new Scanner(System.in);
		int quantity = 0;
		if (!barrator) {
			System.out.println("This deputy doesn't take any bribes");
		} else {
			System.out.println("Enter the amount of bribes you give: ");
			try {
				quantity = scan.nextInt();
			} catch (Exception e) {
				System.err.println("Wrong input...");
			}
			if (quantity > 5000) {
				System.out.println("The police will get caught the deputy!!!");
			} else {
				setBribe_qty(quantity);
			}
		}
	}

}
