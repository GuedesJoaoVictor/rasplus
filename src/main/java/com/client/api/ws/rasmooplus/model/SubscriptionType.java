package com.client.api.ws.rasmooplus.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "subscriptions_type")
@Entity
public class SubscriptionType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subscriptions_type_id")
    private Long id;
    private String name;
    @Column(name = "access_month")
    private Long accessMonth;
    private BigDecimal price;
    @Column(name = "procduct_key")
    private String procductKey;

    public SubscriptionType() {}

    public SubscriptionType(String name, Long accessMonth, BigDecimal price, String procductKey) {
        this.name = name;
        this.accessMonth = accessMonth;
        this.price = price;
        this.procductKey = procductKey;
    }

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

    public Long getAccessMonth() {
        return accessMonth;
    }

    public void setAccessMonth(Long accessMonth) {
        this.accessMonth = accessMonth;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProcductKey() {
        return procductKey;
    }

    public void setProcductKey(String procductKey) {
        this.procductKey = procductKey;
    }
}
