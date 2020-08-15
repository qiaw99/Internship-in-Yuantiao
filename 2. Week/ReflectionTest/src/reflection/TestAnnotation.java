package reflection;

import java.lang.annotation.Annotation;

public class TestAnnotation {
	public static void main(String[] args) {
		Class aClass = TestClass.class;
		Annotation[] annotations = aClass.getAnnotations();
		
		for(Annotation annotation: annotations) {
			if(annotation instanceof MyAnnotation) {
				MyAnnotation myAnnotation = (MyAnnotation) annotation;
				System.out.println("Name: " + myAnnotation.name());
				System.out.println("Value: " + myAnnotation.value());
			}
		}
	}
}
