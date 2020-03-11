package ua.lgs.lviv;

public class Person {

	private double height;
	private int weight;

	public Person(double height, int weight) {
		super();
		this.height = height;
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Person [height=" + height + ", weight=" + weight + "]";
	}

}
