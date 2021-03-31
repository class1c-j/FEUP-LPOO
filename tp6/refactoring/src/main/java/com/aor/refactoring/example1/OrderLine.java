package com.aor.refactoring.example1;

public class OrderLine {

    private final Product product;
    private final int quantity;
    private double totalValue;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        totalValue += this.product.getPrice() * this.quantity;
    }

    public double getTotal() {
        return totalValue;
    }

    @Override
    public String toString() {
        return product.getName() + "(x" + quantity +
                "): " + totalValue + '\n';
    }

}
