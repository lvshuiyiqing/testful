package testful.coverage.whiteBox;

import java.util.Arrays;

public final class Stack {
	final Integer[] stack;
	private final int hash;
	public Stack(Integer[] s) {
		stack = s;
		hash = Arrays.hashCode(stack);
	}

	@Override
	public int hashCode() {
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;

		if(!(obj instanceof Stack)) return false;

		Stack other = (Stack) obj;
		if(hash != other.hash) return false;

		return Arrays.equals(stack, other.stack);
	}

	@Override
	public String toString() {
		return Arrays.toString(stack);
	}
}
