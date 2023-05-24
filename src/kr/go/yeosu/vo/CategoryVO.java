package kr.go.yeosu.vo;

public class CategoryVO {
	private String ct;		//카테고리 대분류 코드 - 카테고리코드(cate)의 앞 두 자리
	private String gname; //카테고리 그룹명
	private String cate; //카테고리 중분류 코드 - 4자리
	private String cname; //중분류 카테고리명
	private String pcode;	//상품코드
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
}
