package demo.move;

public class Car implements Movable {
	
	private double x;
	private double y;
	
	public Car() {
		this.x = 0;
		this.y = 0;
	}
	
	public Car(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void move() {
		this.x += 1;
		this.y += 1;
		System.out.println("I have moved to the new position: ("+x+", "+y+")");
	}
	
	public void move(int delta_x, int delta_y) {
		this.x += delta_x;
		this.y += delta_y;
		System.out.println("I have moved to the new position: ("+x+", "+y+")");
	}
	
	@Override
	public void shake() {
		System.out.println("Please don't shake me. I'm a car.");
	}

}
