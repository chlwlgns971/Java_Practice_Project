package Chapter06;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	MyDate(){}
	MyDate(int year, int month, int day){
		this.year=year;
		this.month=month;
		this.day=day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
}
class Person{
	private String name;
	private int birth;
	
	Person(){}
	Person(String name, int year, int month, int day){
		this.name=name;
		String str=Integer.toString(year)+Integer.toString(month)+Integer.toString(day);
		this.birth=Integer.parseInt(str);
	}
	Person(String name, MyDate md){
		this.name=name;
		String str=Integer.toString(md.getYear())+Integer.toString(md.getMonth())+Integer.toString(md.getDay());
		this.birth=Integer.parseInt(str);
	}
	public String getName() {
		return name;
	}
	public int getBirth() {
		return birth;
	}
	
	
}
