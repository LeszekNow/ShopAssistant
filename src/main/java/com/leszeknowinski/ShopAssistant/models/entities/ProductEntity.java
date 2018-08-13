package com.leszeknowinski.ShopAssistant.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter @Setter
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "shop_id")
    private int shopId;
    private String barcode;
    private String name;
    private String description;
    private float price;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "shop_id")
//    ShopEntity shop;

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
