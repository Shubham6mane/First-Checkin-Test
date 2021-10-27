class Student
{
	String name;
	int id;
	Address add;

	void setName(String name){
		this.name=name;
	}
	void setId(int id){
		this.id=id;
	}
	void setAdd(Address add){
		this.add=add;
	}
	String getName(){
		return name;
	}
	int getId(){
		return id;
	}
	Address getAdd(){
		return add;
	}
};

class Address
{
	String city;
	int pincode;
};

public class Main
{
	public static void main(String[] args) 
	{

		Student s=new Student();
		s.setName("Shubham");
		s.setId(10);

		Address a=new Address();
		a.city="Nagpur";
		a.pincode=480001;

		s.setAdd(a);
		System.out.println("Name>>"+s.getName());
		System.out.println("Id>>"+s.getId());
		System.out.println("City>>"+s.getAdd().city);
		System.out.println("Pincode>>"+s.getAdd().pincode);
	}
}
