package tw.com.ispan.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class OrderRequestDTO {
    private String merchantTradeNo;  // ECPay 的商店交易編號
    private String merchantTradeDate;  // 商店交易日期
    private Integer totalAmount;  // 交易總金額
    private String tradeDesc;  // 交易描述
    private String itemName;  // 商品名稱
    private String returnURL;  // 交易結果回傳網址
    private String clientBackURL;  // 商店轉跳網址
    private String paymentMethod;  // 付款方式
}