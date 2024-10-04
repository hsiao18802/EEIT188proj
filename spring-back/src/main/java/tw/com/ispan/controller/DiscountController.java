package tw.com.ispan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    
 // 查詢所有折扣碼
    @GetMapping("/all")
    public ResponseEntity<List<Discount>> getAllDiscounts() {
        List<Discount> discounts = discountService.findAllDiscounts();
        return ResponseEntity.ok(discounts);
    }

    // 新增折扣碼
    @PostMapping("/add")
    public ResponseEntity<Discount> addDiscount(@RequestBody Discount discount) {
        Discount newDiscount = discountService.saveDiscount(discount);
        return ResponseEntity.ok(newDiscount);
    }

    // 更新折扣碼
    @PutMapping("/update/{id}")
    public ResponseEntity<Discount> updateDiscount(@PathVariable Integer id, @RequestBody Discount discountDetails) {
        Discount updatedDiscount = discountService.updateDiscount(id, discountDetails);
        return ResponseEntity.ok(updatedDiscount);
    }

    // 刪除折扣碼
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDiscount(@PathVariable Integer id) {
        boolean deleted = discountService.deleteDiscount(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }
}
