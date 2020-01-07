package io.training;

public class Bar {
    int size;

    public Bar(int area) {
        this.size = area;
    }

    public static Bar unit() {
        return new Bar(1);
    }
}

