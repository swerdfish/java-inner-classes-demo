package demo.move;

import java.util.Arrays;
import java.util.List;

public class MovableDemoDriver {
	
	public static void main(String[] args) {
		Movable car = new Car();
		Movable thing = new MovableThing();
		Movable anonymousThing = new Movable() {
			@Override
			public void move() {
				System.out.println("I have been moved anonymously");
			}
			@Override
			public void shake() {
				System.out.println("I have been shaken anonymously");
			}
		};
		List<Movable> movingThings = Arrays.asList(car, thing, anonymousThing);
		for (Movable mt : movingThings) {
			mt.move();
			mt.shake();
		}
	}
	
}
