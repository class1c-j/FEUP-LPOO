package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderLine> lines;
    private double total = 0;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        OrderLine line = new OrderLine(product, quantity);
        lines.add(line);
        total += line.getTotal();
    }

    public boolean isElegibleForFreeDelivery() {
        return total > 100;
    }

    public String printOrder() {
        StringBuilder printBuffer = new StringBuilder();

        for (OrderLine line : lines)
            printBuffer.append(line.toString());

        printBuffer.append("Total: ").append(total);

        return printBuffer.toString();
    }

}