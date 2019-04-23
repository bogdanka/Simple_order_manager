package com.simple.order.manager.repository;

import com.simple.order.manager.pojo.OrderPOJO;
import com.simple.order.manager.pojo.UserPOJO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderPOJO, Long> {

    List<OrderPOJO> findAllByUser( UserPOJO userPOJO);

    OrderPOJO save(OrderPOJO orderPOJO);


}
