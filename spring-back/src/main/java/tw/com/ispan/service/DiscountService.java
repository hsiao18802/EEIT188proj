package tw.com.ispan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ispan.domain.Discount;
import tw.com.ispan.exception.ResourceNotFoundException;
import tw.com.ispan.repository.DiscountRepository;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public Discount findDiscountByCode(String code) {
        return discountRepository.findByCode(code);
    }
    
 // 查詢所有折扣碼
    public List<Discount> findAllDiscounts() {
        return discountRepository.findAll();
    }

    // 保存或新增折扣碼
    public Discount saveDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    // 更新折扣碼
    public Discount updateDiscount(Integer id, Discount discountDetails) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("折扣碼未找到"));
        
        discount.setCode(discountDetails.getCode());
        discount.setDescription(discountDetails.getDescription());
        discount.setDiscountType(discountDetails.getDiscountType());
        discount.setDiscountValue(discountDetails.getDiscountValue());
        discount.setStartDate(discountDetails.getStartDate());
        discount.setEndDate(discountDetails.getEndDate());
        discount.setUsageLimit(discountDetails.getUsageLimit());
        discount.setUsageCount(discountDetails.getUsageCount());
        discount.setIsActive(discountDetails.getIsActive());
        
        return discountRepository.save(discount);
    }

    // 刪除折扣碼
    public boolean deleteDiscount(Integer id) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("折扣碼未找到"));
        discountRepository.delete(discount);
        return true;
    }
    
    
    
}
