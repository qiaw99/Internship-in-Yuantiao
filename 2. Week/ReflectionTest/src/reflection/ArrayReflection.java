package reflection;

import java.lang.reflect.Array;

public class ArrayReflection {
	public static void main(String[] args) {
		int[] intArray = (int[]) Array.newInstance(int.class, 5);
		Array.set(intArray, 0, 1);
		Array.set(intArray, 1, 2);
		Array.set(intArray, 2, 3);
		Array.set(intArray, 3, 4);
		
		for(int i = 0; i < 5; i ++) {
			System.out.println("intArray[" + i + "] = " + Array.get(intArray, i));
		}
		
	}
}
