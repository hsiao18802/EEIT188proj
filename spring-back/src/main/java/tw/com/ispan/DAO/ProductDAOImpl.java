package tw.com.ispan.DAO;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import tw.com.ispan.domain.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Product> find(JSONObject obj) {
        // 解析傳入的 JSON 查詢條件
        Integer categoryId = obj.isNull("categoryId") ? null : obj.getInt("categoryId");
        String productName = obj.isNull("name") ? null : obj.getString("name");
        Integer start = obj.isNull("start") ? 0 : obj.getInt("start");
        Integer max = obj.isNull("max") ? 10 : obj.getInt("max");
        Boolean dir = obj.isNull("dir") ? false : obj.getBoolean("dir");
        String order = obj.isNull("order") ? "productId" : obj.getString("order");

        // 打印解析出來的查詢條件
        System.out.println("Parsed Query Conditions:");
        System.out.println("Category ID: " + categoryId);
        System.out.println("Product Name: " + productName);
        System.out.println("Start: " + start);
        System.out.println("Max: " + max);
        System.out.println("Dir (Descending Order): " + dir);
        System.out.println("Order by: " + order);

        // 使用 Criteria API 構建查詢
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        // 加入條件查詢
        if (categoryId != null && categoryId != -1) {
            predicates.add(cb.equal(product.get("categoryId"), categoryId));
            System.out.println("Added Category Predicate: categoryId = " + categoryId);
        }
        if (productName != null && !productName.isEmpty()) {
            predicates.add(cb.like(product.get("productName"), "%" + productName + "%"));
            System.out.println("Added Name Predicate: productName LIKE '%" + productName + "%'");
        }

        // 加入 status_id = 2 的條件
        predicates.add(cb.equal(product.get("statusId"), 2));
        System.out.println("Added Status Predicate: statusId = 2");

        // 如果有條件，將其加入到查詢中
        if (!predicates.isEmpty()) {
            cq.where(predicates.toArray(new Predicate[0]));
            System.out.println("Final Predicates applied.");
        } else {
            System.out.println("No predicates applied.");
        }

        // 排序
        if (dir) {
            cq.orderBy(cb.desc(product.get(order)));
            System.out.println("Applied Sorting: " + order + " DESC");
        } else {
            cq.orderBy(cb.asc(product.get(order)));
            System.out.println("Applied Sorting: " + order + " ASC");
        }

        // 執行查詢並返回結果
        TypedQuery<Product> query = entityManager.createQuery(cq)
            .setFirstResult(start)
            .setMaxResults(max);
        
        System.out.println("Query ready to execute.");
        System.out.println("Executing query with start=" + start + " and max=" + max);

        List<Product> result = query.getResultList();

        // 打印查詢結果數量
        System.out.println("Query executed. Total results: " + result.size());

        return result;
    }


    @Override
    public Long count(JSONObject obj) {
        Integer categoryId = obj.isNull("categoryId") ? null : obj.getInt("categoryId");
        String productName = obj.isNull("name") ? null : obj.getString("name");

        // 使用 Criteria API 計算符合條件的總筆數
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Product> product = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();
        if (categoryId != null && categoryId != -1) {
            predicates.add(cb.equal(product.get("categoryId"), categoryId));
        }
        if (productName != null && !productName.isEmpty()) {
            predicates.add(cb.like(product.get("productName"), "%" + productName + "%"));
        }

        // 加入 status_id = 2 的條件
        predicates.add(cb.equal(product.get("statusId"), 2));

        if (!predicates.isEmpty()) {
            cq.where(predicates.toArray(new Predicate[0]));
        }

        // 設定 select count(*)
        cq.select(cb.count(product));

        return entityManager.createQuery(cq).getSingleResult();
    }


}
