package snippets;

public class OuterClass {
	
	public class InnerClassPublic {
		// Public inner class
	}
	
	protected class InnerClassProtected {
		// Protected inner class
	}
	
	class InnerClass {
		// Package private inner class
	}
	
	private class InnerClassPrivate {
		// This class is yellow underlined because it's private, but not used locally.
	}
	
	static class InnerClassStatic {
		// Static class (can be combined with any of the access modifiers above)
	}

}
