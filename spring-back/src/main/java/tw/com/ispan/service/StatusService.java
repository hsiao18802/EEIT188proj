package tw.com.ispan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.ispan.domain.ProductStatus;
import tw.com.ispan.repository.ProductStatusRepository;

@Service
@Transactional
public class StatusService {

    @Autowired
    private ProductStatusRepository statusRepository;

    public List<ProductStatus> findAllCategories() {
        return statusRepository.findAll();
    }
}
