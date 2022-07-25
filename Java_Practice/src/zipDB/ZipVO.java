package zipDB;

public class ZipVO {
	private String zipcode;  //--우편번호  7  
	private String sido;  //--  특별시,광역시,도  4
	private String gugun;  //-- 시,군,구  17  
	private String dong;   //--읍,면,동  26  
	private String ri; // --  리명  18
	private String bldg;  //-- 건물명  40 
	private String bunji; //-- 번지,아파트동,호수  17 
	private int seq; //-- 데이터 순서  5
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getRi() {
		return ri;
	}
	public void setRi(String ri) {
		this.ri = ri;
	}
	public String getBldg() {
		return bldg;
	}
	public void setBldg(String bldg) {
		this.bldg = bldg;
	}
	public String getBunji() {
		return bunji;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	
}
