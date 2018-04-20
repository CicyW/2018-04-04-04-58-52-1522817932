package practice3;

import java.math.BigDecimal;

public class PriceCaculator {

    private Order order;

    public PriceCaculator(Order order){
        this.order = order;
    }

    public BigDecimal calculateSubTotal() {
        BigDecimal subTotal = new BigDecimal(0);
        for(OrderLineItem item:order.getOrderLineItemList()){
            subTotal = subTotal.add(item.getPrice());
        }
        return subTotal;
    }

    public BigDecimal calculateDiscountTotal(){
        BigDecimal discountTotal = new BigDecimal(0);
        for(BigDecimal discount:order.getDiscounts()){
            discountTotal = discountTotal.add(discount);
        }
        return discountTotal;
    }

    public BigDecimal calculateTotal(){
        // calculate subTotal
        BigDecimal subTotal = calculateSubTotal();

        // calculate discount
        BigDecimal discountTotal = calculateDiscountTotal();

        subTotal = subTotal.subtract(discountTotal);

        // calculate tax
        BigDecimal tax = subTotal.multiply(order.getTax());
        BigDecimal grandTotal = subTotal.add(tax);

        return grandTotal;
    }

}
