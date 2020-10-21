package demo.pizzeria;

import java.util.Arrays;
import java.util.List;

public class PlaceOrder {
	
	public static void main(String[] args) {
		List<Pizza> pizzas = Arrays.asList(new Pizza(), new Pizza("pepperoni"), new Pizza("ham, pineapple"));
		List<Pizza.DeepDish> deepDishPizzas = Arrays.asList(new Pizza.DeepDish("sausage"), new Pizza.DeepDish("onions, olives, mushrooms, green peppers, spinach"));
		System.out.println("Placing an order for the following pizzas: ");
		for (Pizza pizza : pizzas) {
			System.out.println(pizza);
		}
		for (Pizza.DeepDish ddp : deepDishPizzas) {
			System.out.println(ddp);
		}
	}

}
