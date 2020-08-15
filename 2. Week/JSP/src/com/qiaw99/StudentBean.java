package com.qiaw99;

import java.io.Serializable;

/**
 * 1. 提供一个默认的无参构造函数。 2. 需要被序列化并且实现了 Serializable 接口。 3. 可能有一系列可读写属性。 4. 可能有一系列的
 * getter 或 setter 方法。
 * 
 * @author 87290
 *
 */
public class StudentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private int age;

	public StudentBean() {
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public int getAge() {
		return this.age;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
