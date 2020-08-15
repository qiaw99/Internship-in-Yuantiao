package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetPrivateThings {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		PrivateObject privateObject = new PrivateObject("The private Object");
		Field privateStringField = PrivateObject.class.getDeclaredField("privateString");
		privateStringField.setAccessible(true);
		String fieldValue = (String) privateStringField.get(privateObject);
		System.out.println("The field value: " + fieldValue);

		Method privateMethod = PrivateObject.class.getDeclaredMethod("getPrivateString", null);
		privateMethod.setAccessible(true);
		String returnValue = (String) privateMethod.invoke(privateObject, null);
		System.out.println("The return value: " + returnValue);
	}
}
