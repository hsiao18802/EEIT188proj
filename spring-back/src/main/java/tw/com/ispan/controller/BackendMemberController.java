package tw.com.ispan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ispan.domain.Members;
import tw.com.ispan.service.MemberService;

@CrossOrigin
@RestController
@RequestMapping("/api/backend/members") // 後台 API 前綴
public class BackendMemberController {

    @Autowired
    private MemberService memberService;

    // 取得所有會員資料（用於後台顯示）
    @GetMapping("/all")
    public ResponseEntity<List<Members>> getAllMembers() {
        List<Members> membersList = memberService.getAllMembers();
        return ResponseEntity.ok(membersList);
    }

     //將會員加入黑名單
    @PostMapping("/blacklist/{id}")
    public ResponseEntity<String> addToBlacklist(@PathVariable Integer id) {
        memberService.addToBlacklist(id);
        return ResponseEntity.ok("會員已加入黑名單");
    }

    // 將會員移出黑名單
    @PostMapping("/removeBlacklist/{id}")
    public ResponseEntity<String> removeFromBlacklist(@PathVariable Integer id) {
        memberService.removeFromBlacklist(id);
        return ResponseEntity.ok("會員已移出黑名單");
    }
}
