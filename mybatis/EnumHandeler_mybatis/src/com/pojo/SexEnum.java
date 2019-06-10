package com.pojo;

public enum SexEnum {
	
	MALE(1,"��"),FEMALE(2,"Ů");
	private int id;
	private String name;
	
	private SexEnum(int id,String name)
	 {
		this.id=id;
		this.name=name;
	 }
	
	//ͨ��id��ȡö��
	 public static SexEnum getSexById(int id)
	{
		 if(id==1)
		 return MALE;
		 else if(id==2)
		 return FEMALE;
		 else
		 return null;
	 }
	 
	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
		 this.name = name;
	}
}

