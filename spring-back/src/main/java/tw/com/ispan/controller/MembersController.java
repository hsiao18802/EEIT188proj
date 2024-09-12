package tw.com.ispan.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tw.com.ispan.domain.Members;
import tw.com.ispan.service.MemberService;
import tw.com.ispan.util.JsonWebTokenUtility;

@CrossOrigin
@RestController
@RequestMapping("/rent/member")
public class MembersController {

    @Autowired
    private MemberService memberService;
    
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
        Members member = memberService.getMemberByUsername(username);

        if (member != null) {
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/update")
    public ResponseEntity<Members> updateMemberInfo(@RequestBody Members updatedMember) {
        Members member = memberService.updateMember(updatedMember);
        return ResponseEntity.ok(member);
    }

    
    @PostMapping("/upload-photo")
    public ResponseEntity<Members> uploadPhoto(@RequestParam("file") MultipartFile file, @RequestParam("username") String username) {
        Members updatedMember = memberService.updateMemberPhoto(file, username);
        return ResponseEntity.ok(updatedMember);
    }

}
