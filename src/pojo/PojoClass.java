package pojo;

public class PojoClass 
{
	private String name;
	private int age;
	
	public PojoClass(String name,int age)
	{
		this.name=name;
		this.age=age;
		System.out.println(" Name "+this.name+" age "+this.age);
	}
	
	public PojoClass()
	{
		System.out.println(" HAI ");
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setAge(int age)
	{
		this.age=age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String toString()
	{
		return name +" "+age;
	}
	
}
