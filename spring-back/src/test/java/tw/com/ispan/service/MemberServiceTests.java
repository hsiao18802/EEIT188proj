//package tw.com.ispan.service;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import tw.com.ispan.domain.Members;
//
//@SpringBootTest
//public class MemberServiceTests {
//	@Autowired
//	private MemberService memberService;
//	
//	@Test
//	public void testLogin() {
//		Members login = memberService.login("kk123", "1111");
//		System.out.println("login="+login);			
//	}
//	@Test
//	public void testChangePassword() {
//		boolean change = memberService.changePassword(
//				"Ellen", "E", "EEE");
//		System.out.println("change="+change);			
//	}
//	
//	@Test
//	public void testFindByUsername() {
//	    Members member = memberService.testFindByUsername("kk123");
//	    System.out.println("Found member: " + member);
//	}
//
//}
