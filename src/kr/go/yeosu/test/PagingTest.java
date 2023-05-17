package kr.go.yeosu.test;

<<<<<<< HEAD
import kr.go.yeosu.util.Page;

public class PagingTest {
	public static void main(String[] args) {
		Page p1 = new Page();
		p1.rePaging(2, 5, 5, 27);

		System.out.println("현재 페이지의 시작 글 번호 : "+p1.getStartPost());
		System.out.println("현재 페이지의 끝 글 번호 : "+p1.getEndPost());
		System.out.println("현재 페이지 번호 : "+p1.getCPage());
		System.out.println("전체 페이지 수 : "+p1.getTotalPages());
		System.out.println("현재 블록 : "+p1.getCurrentBlock());
		
		System.out.println("----------------------------");
		p1.rePaging(14, 10, 10, 340);

		System.out.println("현재 페이지의 시작 글 번호 : "+p1.getStartPost());
		System.out.println("현재 페이지의 끝 글 번호 : "+p1.getEndPost());
		System.out.println("현재 페이지 번호 : "+p1.getCPage());
		System.out.println("전체 페이지 수 : "+p1.getTotalPages());
		System.out.println("현재 블록 : "+p1.getCurrentBlock());
=======
import static org.junit.Assert.fail;

import org.junit.Test;

public class PagingTest {
	
	@Test
	public void test() {
		fail("Not yet implemented");
>>>>>>> df8f963aecadd4b41755529d0572dc57eecbefce
	}
}
