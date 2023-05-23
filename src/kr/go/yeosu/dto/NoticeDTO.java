package kr.go.yeosu.dto;

import java.util.Date;

public class NoticeDTO {
	private int idx;
	private String title;
	private String content;
	private String author;
	private String file1;
	private String regdate;
	private int readcnt;	
	
	public NoticeDTO(){
		Date now = new Date();
		this.regdate = now.toString();
	}
				
	public int getIdx() {return idx;}
	public void setIdx(int idx) {this.idx = idx;}
	
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	
	public String getAuthor() {return author;}
	public void setAuthor(String author) {this.author = author;}
	
	public String getFile1() {return file1;}
	public void setFile1(String file1) {this.file1 = file1;}
	
	public String getRegdate() {return regdate;}
	public void setRegdate(String date) {this.regdate = date;}
	
	public int getReadcnt() {return readcnt;}
	public void setReadcnt(int readcnt) {this.readcnt = readcnt;}	
}
