package model;

import java.text.DecimalFormat;

public abstract class Shape {

    private final String type;
    protected double perimeter;
    protected double area;

    DecimalFormat dF = new DecimalFormat("#.##");

    Shape(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    abstract void calculateParameters();

    public String getTextInfo() {
         return String.format("Тип фигуры: %s\n" +
                              "Площадь: %s кв. мм\n" +
                              "Периметр: %s мм\n", type,
                                                    dF.format(getArea()),
                                                    dF.format(getPerimeter()));
    }

    @Override
    public String toString() {
        return "Shape{" +
                "type='" + type + '\'' +
                ", perimeter=" + perimeter +
                ", area=" + area +
                '}';
    }
}
