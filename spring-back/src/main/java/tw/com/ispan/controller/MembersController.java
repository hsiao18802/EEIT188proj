package tw.com.ispan.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ispan.domain.Members;
import tw.com.ispan.service.MemberService;
import tw.com.ispan.util.JsonWebTokenUtility;

@CrossOrigin
@RestController
@RequestMapping("/rent/member")
public class MembersController {

    @Autowired
    private MemberService membersService;
    
    @Autowired
    private JsonWebTokenUtility jwtUtility;

    @GetMapping("/info")
    public ResponseEntity<Members> getMemberInfo(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.replace("Bearer ", "");

        String userData = jwtUtility.validateEncryptedToken(token);
        if (userData == null) {
            return ResponseEntity.status(401).build();
        }

        JSONObject user = new JSONObject(userData);
        String username = user.getString("membername");
        Members member = membersService.getMemberByUsername(username);

        if (member != null) {
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
