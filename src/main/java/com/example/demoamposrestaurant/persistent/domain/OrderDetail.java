package com.example.demoamposrestaurant.persistent.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ORDER_DETAIL")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = -2324260438769076899L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    @Column(columnDefinition = "TIMESTAMP NULL DEFAULT NULL")
    private Date orderedTime;
    @Column(columnDefinition = "TIMESTAMP NULL DEFAULT NULL")
    private Date checkedTime;

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

    public Date getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(Date orderedTime) {
        this.orderedTime = orderedTime;
    }

    public Date getCheckedTime() {
        return checkedTime;
    }

    public void setCheckedTime(Date checkedTime) {
        this.checkedTime = checkedTime;
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
