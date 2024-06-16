
interface Shape {
	double getArea();
}

class Circle implements Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}
}

class Square implements Shape {
	private double sideLength;

	public Square(double sideLength) {
		this.sideLength = sideLength;
	}

	@Override
	public double getArea() {
		return sideLength * sideLength;
	}
}

public class Assignment5 {

	public static void calculateArea(Shape shape) {
		double area = shape.getArea();
		//
	}

	public static void main(String[] args) {
		// Create objects of different shapes (inheritance)
		Circle circle = new Circle(5);
		Square square = new Square(10);

		// Polymorphic calls to calculateArea (polymorphism)
		calculateArea(circle);
		calculateArea(square);

		// (Perform calculations or store results using the area values)
	}
}
