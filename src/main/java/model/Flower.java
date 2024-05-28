package model;

public class Flower {


    private String name;
    private String type;
    private String color;
    private int length;
    private int price;

    public Flower(String name, String type, String color, int length, int price) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.length = length;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getLength() {
        return length;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flower flower = (Flower) o;
        return length == flower.length && price == flower.price && name.equals(flower.name) && type.equals(flower.type) && color.equals(flower.color);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + length;
        result = 31 * result + price;
        return result;
    }

}

