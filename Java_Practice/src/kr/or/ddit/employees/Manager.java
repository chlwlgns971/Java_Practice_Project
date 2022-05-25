package kr.or.ddit.employees;

public class Manager extends Employee {
	private String position;
	
	public Manager(String empNo, String name, String part){
		setEmpNo(empNo);
		setName(name);
		setPart(part);
		this.position=position;
	}
}
