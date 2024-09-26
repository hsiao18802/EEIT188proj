package tw.com.ispan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ispan.domain.Discount;
import tw.com.ispan.repository.DiscountRepository;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public Discount findDiscountByCode(String code) {
        return discountRepository.findByCode(code);
    }
}
