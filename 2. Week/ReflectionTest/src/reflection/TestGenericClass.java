package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestGenericClass {
	public static void main(String[] args) {
		try {
			Method method = GenericClass.class.getMethod("getStringList", null);
			Type returnType = method.getGenericReturnType();
			
			if(returnType instanceof ParameterizedType) {
				ParameterizedType type = (ParameterizedType) returnType;
				Type[] typeArgumentsTypes = type.getActualTypeArguments();
				for(Type typeArgumenType : typeArgumentsTypes) {
					Class<?> typeArgClass = (Class<?>) typeArgumenType;
					System.out.println("Type Arg Class: " + typeArgClass);
				}
			}
			
			Type[] genericParameterTypes = method.getGenericParameterTypes();
			for(Type genericParameterType: genericParameterTypes) {
				if(genericParameterType instanceof ParameterizedType) {
					ParameterizedType aType = (ParameterizedType) genericParameterType;
					Type[] parameterArgTypes = aType.getActualTypeArguments();
					for(Type parameterArgType: parameterArgTypes) {
						Class<?> parameterArgClass = (Class<?>) parameterArgType;
						System.out.println("Parameter Arg Class: " + parameterArgClass);
					}
				}
			}
			
			Field genericField = GenericClass.class.getField("stringList");
			Type genericFieldType = genericField.getGenericType();
			if(genericFieldType instanceof ParameterizedType){
				    ParameterizedType aType = (ParameterizedType) genericFieldType;
				    Type[] fieldArgTypes = aType.getActualTypeArguments();
				    for(Type fieldArgType : fieldArgTypes){
				        Class<?> fieldArgClass = (Class<?>) fieldArgType;
				        System.out.println("fieldArgClass = " + fieldArgClass);
				    }
				}

			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
	}
}
