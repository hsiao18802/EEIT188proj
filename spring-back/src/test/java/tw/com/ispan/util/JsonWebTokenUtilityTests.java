package tw.com.ispan.util;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JsonWebTokenUtilityTests {
	@Autowired
	private JsonWebTokenUtility jsonWebTokenUtility;

	// @Test
	public void testCreateToken() {
		JSONObject obj = new JSONObject()
				.put("data1", "this is data1")
				.put("data2", "this is data2");
		
		String token = jsonWebTokenUtility.createToken(obj.toString(), null);
		System.out.println("token="+token);
	}
	
	@Test
	public void testValidateToken() {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ7XCJkYXRhMlwiOlwidGhpcyBpcyBkYXRhMlwiLFwiZGF0YTFcIjpcInRoaXMgaXMgZGF0YTFcIn0iLCJpYXQiOjE3MjQ5MTIzNjMsImV4cCI6MTcyNDkxMjQyM30.g75RIbmRe-KD7aorl-5HikBPSdnq_KjV0dQ1TSyQuVc";
		String json = jsonWebTokenUtility.validateToken(token);
		System.out.println("json="+json);
	}
}
