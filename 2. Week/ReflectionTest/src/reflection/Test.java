package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Test {
	public static boolean isGetter(Method method) {
		if (!method.getName().startsWith("get"))
			return false;
		if (method.getParameterTypes().length != 0)
			return false;
		if (void.class.equals(method.getReturnType()))
			return false;
		return true;

	}

	public static boolean isSetter(Method method) {
		if (!method.getName().startsWith("set"))
			return false;
		if (method.getParameterTypes().length != 1)
			return false;
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) {
		Class<Student> myObjeClass = Student.class;

		String className = myObjeClass.getName();
		System.out.println(className);
		System.out.println("******************************");
		
		int modifiers = myObjeClass.getModifiers();
		System.out.println(Modifier.isPublic(modifiers));

		System.out.println("******************************");
		
		Class<? super Student> aClass = myObjeClass.getSuperclass();

		try {
			Field field = myObjeClass.getField("lastNameString");
			Student student1 = new Student();
			Object valueObject = field.get(student1);
			field.set(student1, valueObject);
			System.out.println("Field: " + field);
		} catch (NoSuchFieldException | SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		System.out.println("******************************");
		System.out.println(aClass.getName());
		System.out.println("Implemented Interfaces: " + Arrays.toString(myObjeClass.getInterfaces()));

		System.out.println("******************************");
		Constructor[] constructors = myObjeClass.getConstructors();
		System.out.println("Constructors: " + Arrays.toString(constructors));
		Constructor constructor = constructors[0];
		Class[] parameterTypes = constructor.getParameterTypes();
		System.out.println("Construtor parametertypes: " + Arrays.toString(parameterTypes));
		
		System.out.println("******************************");
		Method[] methods = myObjeClass.getMethods();
//		Method[] methods = myObjeClass.getDeclaredMethods();
		System.out.println("Methods: " + Arrays.toString(methods));
		for (Method tempMethod : methods) {
			if (isGetter(tempMethod))
				System.out.println("getter: " + tempMethod);
			if (isSetter(tempMethod))
				System.out.println("setter: " + tempMethod);

		}

		System.out.println("******************************");
		try {
			Student std = new Student(30, "Father");
			Method method = myObjeClass.getMethod("getLastNameString", null);
			System.out.println("Return Type: " + method.getReturnType());
			System.out.println("Parameter Types: " + Arrays.toString(method.getParameterTypes()));
			System.out.println(method.invoke(std, null));
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("******************************");
		// Get all fields that are declared with public
		Field[] fields = myObjeClass.getFields();
//		Field[] fields = myObjeClass.getDeclaredFields();
		System.out.println("Fields: " + Arrays.toString(fields));

		System.out.println("******************************");
		Annotation[] annotations = myObjeClass.getAnnotations();
		System.out.println("Annotations: " + Arrays.toString(annotations));

		System.out.println("******************************");
		try {
			Student student2 = (Student) constructor.newInstance(20, "1234");
			System.out.println(student2);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
