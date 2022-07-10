package Parsing;

public class Person {
	private String name;
	private String gender;
	private String job;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", job=" + job + "]";
	}
	
	
}
