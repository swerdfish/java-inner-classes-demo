package demo.move;

public class MovableThing implements Movable {

	@Override
	public void move() {
		System.out.println("I have been moved");
	}
	
	@Override
	public void shake() {
		System.out.println("Shake it up!");
	}

}
