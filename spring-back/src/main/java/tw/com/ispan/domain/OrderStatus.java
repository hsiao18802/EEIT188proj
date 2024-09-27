package tw.com.ispan.domain;

public enum OrderStatus {
    PENDING(0),     // 待付款
    PAID(1),        // 已付款
    SHIPPED(2),     // 運送中
    DELIVERED(3),   // 已送達
    DONE(4),        // 交易完成
    CANCELLED(5),   // 不成立
    RETURNED(6);    // 退貨/退款

	private final int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static OrderStatus fromValue(int value) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}