package com.leszeknowinski.ShopAssistant.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop")
@Getter @Setter
@NoArgsConstructor
public class ShopEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String nip;
    private String address;
    private String email;
    private String login;
    private String password;

//    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    List<ProductEntity>warehouse;

}
