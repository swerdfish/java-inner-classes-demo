package demo.pizzeria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pizza {
	
	private List<Topping> toppings;
	
	public Pizza() {
		toppings = new ArrayList<>();
	}
	
	public Pizza(String[] toppingStringArray) {
		this();
		for (String tps : toppingStringArray) {
			toppings.add(Topping.strToTopping(tps));
		}
	}
	
	public Pizza(String toppingsString) {
		this(toppingsString.split(",\\s*"));
	}
	
	public Pizza(Collection<Object> toppingCollection) {
		this();
		for (Object tpo : toppingCollection) {
			if (tpo instanceof String) toppings.add((Topping.strToTopping((String) tpo)));
			else if (tpo instanceof Topping) toppings.add((Topping) tpo);
			else throw new IllegalArgumentException("Input must either be a String or a Topping");
		}
	}
	
	public Pizza(Topping[] toppings) {
		this();
		for (Topping top : toppings) {
			this.toppings.add(top);
		}
	}
	
	public static class DeepDish {
		
		public List<Topping> toppings;
		
		public DeepDish() {
			toppings = new ArrayList<>();
		}
		
		public DeepDish(String[] toppingStringArray) {
			this();
			for (String tps : toppingStringArray) {
				toppings.add(Topping.strToTopping(tps));
			}
		}
		
		public DeepDish(String toppingsString) {
			this(toppingsString.split(",\\s*"));
		}
		
		public DeepDish(Collection<Object> toppingCollection) {
			this();
			for (Object tpo : toppingCollection) {
				if (tpo instanceof String) toppings.add((Topping.strToTopping((String) tpo)));
				else if (tpo instanceof Topping) toppings.add((Topping) tpo);
				else throw new IllegalArgumentException("Input must either be a String or a Topping");
			}
		}
		
		public DeepDish(Topping[] toppings) {
			this();
			for (Topping top : toppings) {
				this.toppings.add(top);
			}
		}

		public List<Topping> getToppings() {
			return toppings;
		}

		public void setToppings(List<Topping> toppings) {
			this.toppings = toppings;
		}

		@Override
		public String toString() {
			return "Deep Dish Pizza [toppings=" + toppings + "]";
		}
		
	}

	public List<Topping> getToppings() {
		return toppings;
	}

	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}

	@Override
	public String toString() {
		return "Pizza [toppings=" + toppings + "]";
	}

}
