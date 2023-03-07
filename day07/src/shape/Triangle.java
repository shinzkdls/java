package shape;

public class Triangle extends Shape {

	private double width;
	private double height;

	public Triangle() {
	}

	public Triangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public Triangle(int x, int y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height / 2;
	}

	@Override
	public double getCircumn() {
		double z = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
		return z + width + height;
	}

}
