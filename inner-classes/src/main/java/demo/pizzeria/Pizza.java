package demo.pizzeria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Pizza {
	
	private List<Topping> toppings;
	private String[] construction;
	private double heightInches;
	
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

	public List<Topping> getToppings() {
		return toppings;
	}

	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}
	
	public String[] getConstruction() {
		return construction;
	}
	
	public double getHeightInches() {
		return heightInches;
	}

	@Override
	public String toString() {
		return "Pizza [toppings=" + toppings + "]";
	}
	
	public static class DeepDish extends Pizza {
		
		public DeepDish() {
			super();
			super.construction = new String[] {"crust", "cheese", "toppings", "sauce"};
			super.heightInches = 2;
		}
		
		public DeepDish(String[] toppingStringArray) {
			super(toppingStringArray);
			super.construction = new String[] {"crust", "cheese", "toppings", "sauce"};
			super.heightInches = 2;
		}
		
		public DeepDish(String toppingsString) {
			super(toppingsString);
			super.construction = new String[] {"crust", "cheese", "toppings", "sauce"};
			super.heightInches = 2;
		}
		
		public DeepDish(Collection<Object> toppingCollection) {
			super(toppingCollection);
			super.construction = new String[] {"crust", "cheese", "toppings", "sauce"};
			super.heightInches = 2;
		}
		
		public DeepDish(Topping[] toppings) {
			super(toppings);
		}

		@Override
		public String toString() {
			return "Deep Dish Pizza [toppings=" + super.toppings + "]";
		}
		
	}
	
	public static class Classic extends Pizza {
		
		public Classic() {
			super();
			super.construction = new String[] {"crust", "sauce", "cheese", "toppings"};
			super.heightInches = 0.5;
		}
		
		public Classic(String[] toppingStringArray) {
			super(toppingStringArray);
			super.construction = new String[] {"crust", "sauce", "cheese", "toppings"};
			super.heightInches = 0.5;
		}
		
		public Classic(String toppingsString) {
			super(toppingsString);
			super.construction = new String[] {"crust", "sauce", "cheese", "toppings"};
			super.heightInches = 0.5;
		}
		
		public Classic(Collection<Object> toppingCollection) {
			super(toppingCollection);
			super.construction = new String[] {"crust", "sauce", "cheese", "toppings"};
			super.heightInches = 0.5;
		}
		
		public Classic(Topping[] toppings) {
			super(toppings);
			super.heightInches = 0.5;
		}

		@Override
		public String toString() {
			return "Classic Pizza [toppings=" + super.toppings + "]";
		}
		
	}
	
	public static class ThinCrust extends Pizza {
		
		public ThinCrust() {
			super();
			super.construction = new String[] {"crust", "sauce", "cheese", "toppings"};
			super.heightInches = 0.25;
		}
		
		public ThinCrust(String[] toppingStringArray) {
			super(toppingStringArray);
			super.construction = new String[] {"crust", "sauce", "cheese", "toppings"};
			super.heightInches = 0.25;
		}
		
		public ThinCrust(String toppingsString) {
			super(toppingsString);
			super.construction = new String[] {"crust", "sauce", "cheese", "toppings"};
			super.heightInches = 0.25;
		}
		
		public ThinCrust(Collection<Object> toppingCollection) {
			super(toppingCollection);
			super.construction = new String[] {"crust", "sauce", "cheese", "toppings"};
			super.heightInches = 0.25;
		}
		
		public ThinCrust(Topping[] toppings) {
			super(toppings);
			super.heightInches = 0.25;
		}

		@Override
		public String toString() {
			return "Thin Crust Pizza [toppings=" + super.toppings + "]";
		}
		
	}

}
