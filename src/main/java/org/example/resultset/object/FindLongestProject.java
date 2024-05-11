package org.example.model.resultset;

import java.math.BigDecimal;

public class FindLongestProject {
    private final Long projectId;
    private final BigDecimal monthCount;

    public FindLongestProject(Long projectId, BigDecimal monthCount) {
        this.projectId = projectId;
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "FindLongestProject{" +
                "projectId=" + projectId +
                ", monthCount=" + monthCount +
                '}';
    }
}
