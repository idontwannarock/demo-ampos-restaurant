package com.example.demoamposrestaurant.persistent.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ORDER_DETAIL")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 5224555272335798975L;
    @Id
    private Long id;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_order_order_detail"))
    private BillOrder billOrder;

    @ManyToOne
    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "fk_item_order_detail"))
    private Item item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BillOrder getBillOrder() {
        return billOrder;
    }

    public void setBillOrder(BillOrder billOrder) {
        this.billOrder = billOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
