package kr.go.yeosu.dto;

public class Notice {
	private int idx;
	private String title;
	private String content;
	private String author;
	private String file1;
	private String resdate;
	private int readcnt;	
	
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
	
	public String getResdate() {return resdate;}
	public void setResdate(String resdate) {this.resdate = resdate;}
	
	public int getReadcnt() {return readcnt;}
	public void setReadcnt(int readcnt) {this.readcnt = readcnt;}	
}
