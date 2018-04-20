package practice3;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;


    public Order(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = new BigDecimal(0.1);
    }

    public List<OrderLineItem> getOrderLineItemList() {
        return orderLineItemList;
    }

    public List<BigDecimal> getDiscounts() {
        return discounts;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setOrderLineItemList(List<OrderLineItem> orderLineItemList) {
        this.orderLineItemList = orderLineItemList;
    }

    public void setDiscounts(List<BigDecimal> discounts) {
        this.discounts = discounts;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal calculate() {
        PriceCaculator caculator = new PriceCaculator(this);

        // calculate GrandTotal
        BigDecimal grandTotal = caculator.calculateTotal();

        return grandTotal;
    }
}
