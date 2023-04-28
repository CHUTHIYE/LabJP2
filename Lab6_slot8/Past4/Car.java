package Lab6_slot8.Past4;

public class Car {
    private String name;
    private int price;
    private int production;

    public Car(String name, int price, int production) {
        this.name = name;
        this.price = price;
        this.production = production;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getProduction() {
        return production;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", production=" + production +
                '}';
    }
}

