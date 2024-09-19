package tw.com.ispan.DTO;

import java.util.Base64;
import java.util.Date;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CartDTO {
    private Integer cartId;          
    private Integer productId;       
    private String productName;      
    private Integer count;           
    private byte[] mainPhoto;        
    private Integer dailyFeeOriginal; // 商品原始每日租金
    private Date rentalStartDate;    
    private Date rentalEndDate;      
    private Integer membersId;       
    
    @Override
    public String toString() {
        return "CartDTO{" +
                "cartId=" + cartId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", count=" + count +
                ", mainPhoto=" + (mainPhoto != null ? "[photo data]" : "null") +
                ", dailyFeeOriginal=" + dailyFeeOriginal +
                ", rentalStartDate=" + rentalStartDate +
                ", rentalEndDate=" + rentalEndDate +
                ", membersId=" + membersId +
                '}';
    }
    
    public String getMainPhotoBase64() {
        if (this.mainPhoto != null) {
            return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(this.mainPhoto);
        }
        return null;
    }

}
