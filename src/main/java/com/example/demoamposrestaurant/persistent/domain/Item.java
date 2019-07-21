package com.example.demoamposrestaurant.persistent.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ITEM")
public class Item implements Serializable {

    private static final long serialVersionUID = -792562110473143576L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    private String description;
    private String imageLocation;
    @Column(scale = 5, precision = 20, nullable = false)
    private BigDecimal price;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ITEM_TYPES",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_item_types_item")),
            inverseJoinColumns = @JoinColumn(name = "type_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_item_types_type"))
    )
    private Set<Type> types = new HashSet<>();

    @ManyToMany(mappedBy = "items")
    private Set<Menu> menus = new HashSet<>();

    @OneToMany(mappedBy = "item")
    private Set<OrderDetail> orderDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
