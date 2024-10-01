package tw.com.ispan.DAO;

import java.util.List;
import org.json.JSONObject;
import tw.com.ispan.domain.Product;

public interface ProductDAO {
	public abstract Long count(JSONObject obj);
	public abstract List<Product> find(JSONObject obj);
}