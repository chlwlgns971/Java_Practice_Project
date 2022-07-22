package BankManage;

public class BankVO {
	private String bank_no;
	private String bank_name;
	private String bank_user_name;
	private String bank_date;
	
	public BankVO() {
		super();
	}

	public BankVO(String bank_no, String bank_name, String bank_user_name) {
		super();
		this.bank_no = bank_no;
		this.bank_name = bank_name;
		this.bank_user_name = bank_user_name;
	}

	public String getBank_no() {
		return bank_no;
	}

	public void setBank_no(String bank_no) {
		this.bank_no = bank_no;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_user_name() {
		return bank_user_name;
	}

	public void setBank_user_name(String bank_user_name) {
		this.bank_user_name = bank_user_name;
	}

	public String getBank_date() {
		return bank_date;
	}

	public void setBank_date(String bank_date) {
		this.bank_date = bank_date;
	}

	@Override
	public String toString() {
		return "BankVO [bank_no=" + bank_no + ", bank_name=" + bank_name + ", bank_user_name=" + bank_user_name
				+ ", bank_date=" + bank_date + "]";
	}
}
