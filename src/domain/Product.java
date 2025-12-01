package domain;

public class Product {
    Float ean;
    String name;
    Float value;

    public Product() {};

    public Product(Float ean, String name, Float value) {
        this.ean = ean;
        this.name = name;
        this.value = value;
    }

    public Float getEan() {
        return ean;
    }

    public void setEan(Float ean) {
        this.ean = ean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}

/*
ean bigint not null unique,
name varchar(50) not null unique,
value decimal(10, 2) not null,
constraint pk_product_ean primary key (ean)
*/