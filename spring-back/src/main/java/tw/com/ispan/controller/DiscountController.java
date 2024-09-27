package tw.com.ispan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.com.ispan.domain.Discount;
import tw.com.ispan.service.DiscountService;


@CrossOrigin
@RestController
@RequestMapping("/rent/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping("/validate")
    public ResponseEntity<String> validateCoupon(@RequestParam String code) {
        Discount discount = discountService.findDiscountByCode(code);
        if (discount != null && discount.getIsActive()) {
            // 返回有效的 JSON 格式響應
            return ResponseEntity.ok("{\"message\": \"優惠碼有效！折扣：" + discount.getDiscountValue() + "元\"}");
        } else {
            System.out.println("無效的優惠碼: " + code);
            // 返回有效的 JSON 格式響應
            return ResponseEntity.badRequest().body("{\"message\": \"優惠碼無效或已過期。\"}");
        }
    }
}