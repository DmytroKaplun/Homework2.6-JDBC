package org.example.model.resultset;

public class MaxProjectCountClient {
    private final String name;
    private final long projectCount;

    public MaxProjectCountClient(String name, long projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectCountClient{" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
