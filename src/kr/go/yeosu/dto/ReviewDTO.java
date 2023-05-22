package kr.go.yeosu.dto;

import java.util.Date;

public class ReviewDTO {
	private	String w_num;
	private	String id;
	private	String o_code;
	private	String w_date;
	private	String review;
	private	int	rating;
	
	public ReviewDTO(){
		Date now = new Date();
		this.w_date = now.toString();
	}

	public String getW_num() {
		return w_num;
	}

	public void setW_num(String w_num) {
		this.w_num = w_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getO_code() {
		return o_code;
	}

	public void setO_code(String o_code) {
		this.o_code = o_code;
	}

	public String getW_date() {
		return w_date;
	}

	public void setW_date(String w_date) {
		this.w_date = w_date;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}