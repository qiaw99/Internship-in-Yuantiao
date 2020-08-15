package com.qiaw99;

import java.io.Serializable;

/**
 * 1. �ṩһ��Ĭ�ϵ��޲ι��캯���� 2. ��Ҫ�����л�����ʵ���� Serializable �ӿڡ� 3. ������һϵ�пɶ�д���ԡ� 4. ������һϵ�е�
 * getter �� setter ������
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
