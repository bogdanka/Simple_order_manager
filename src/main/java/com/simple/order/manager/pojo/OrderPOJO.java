package com.simple.order.manager.pojo;

import com.simple.order.manager.model.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_order")
@Data
public class OrderPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "request", nullable = false)
    private String request;

    @Column(name = "bid", nullable = false)
    private Double bid;

    @Column(name = "due_date", nullable = false)
    private String due_date;

    @Column(name = "order_status", nullable = false)
    private Status status;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    private UserPOJO user;

    public OrderPOJO() {
    }

    public OrderPOJO(Double bid, Status status, UserPOJO userPOJO) {
        this.bid = bid;
        this.status = status;
        this.user = userPOJO;
    }
}
