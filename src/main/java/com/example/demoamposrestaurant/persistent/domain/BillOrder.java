package com.example.demoamposrestaurant.persistent.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "BILL_ORDER")
public class BillOrder implements Serializable {

    private static final long serialVersionUID = -774728089637527974L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isChecked;

    @OneToMany(mappedBy = "billOrder")
    private Set<OrderDetail> details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    public Set<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(Set<OrderDetail> details) {
        this.details = details;
    }
}
