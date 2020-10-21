package demo.comparisons;

public class MathComparisons {
	
	public void numericalComparisons(int number) {
		int[] comps = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		class Comparisons {
			
			public int dm;
			public int quotient;
			public int remainder;
			public int product;
			
			public Comparisons(int dm) {
				this.dm = dm;
				this.quotient = number / dm;
				this.remainder = number % dm;
				this.product = number *dm;
			}
			
			public void display() {
				System.out.println(number+" * "+dm+" = "+product);
				System.out.println(number+" / "+dm+" = "+quotient+" R "+remainder);
			}
		}
		
		for (int co : comps) {
			new Comparisons(co).display();
		}
	}
	
	public static void main(String[] args) {
		new MathComparisons().numericalComparisons(34250);
	}

}
