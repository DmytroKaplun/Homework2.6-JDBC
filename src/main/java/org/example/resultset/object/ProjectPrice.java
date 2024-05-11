package org.example.model.resultset;

import java.math.BigDecimal;

public class ProjectPrice {
    private final long projectId;
    private final BigDecimal price;

    public ProjectPrice(long projectId, BigDecimal price) {
        this.projectId = projectId;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +
                "projectId=" + projectId +
                ", price=" + price +
                '}';
    }
}
