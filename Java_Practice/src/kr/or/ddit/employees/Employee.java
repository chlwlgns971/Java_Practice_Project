

package kr.or.ddit.employees;

public class Employee {
	private String empNo; //사원번호
	private String name; //이름
	private String part; //부서
	
	public Employee(){}
	public Employee(String empNo, String name, String part){
		this.empNo=empNo;
		this.name=name;
		this.part=part;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	@Override
	public String toString() {
		return "Employee [사번=" + empNo + ", 이름=" + name + ", 부서=" + part + "]";
	}
	
}
