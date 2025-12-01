package domain;

public class PurchaseNote {
    Integer clientID;
    Integer productEAN;
    Float saleValue;

    public PurchaseNote() {};

    public PurchaseNote(Integer clientID, Integer productEAN, Float saleValue) {
        this.clientID = clientID;
        this.productEAN = productEAN;
        this.saleValue = saleValue;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Integer getProductEAN() {
        return productEAN;
    }

    public void setProductEAN(Integer productEAN) {
        this.productEAN = productEAN;
    }

    public Float getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(Float saleValue) {
        this.saleValue = saleValue;
    }
}

/*
id bigint not null unique,
client_id bigint not null,
product_ean bigint not null,
sale_value decimal(10,2) not null,
foreign key (client_id) references tb_client(id),
foreign key (product_ean) references tb_product(ean)
* */