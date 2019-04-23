package com.simple.order.manager.pojo;

import com.simple.order.manager.model.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_user")
@Data
public class UserPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<OrderPOJO> orderPOJOS;


    public UserPOJO(String name, Role role, List<OrderPOJO> orderPOJOS) {
        this.name = name;
        this.role = role;
        this.orderPOJOS = orderPOJOS;
    }

    public UserPOJO() {
    }




}
