package com.simple.order.manager.repository;

import com.simple.order.manager.model.Status;
import com.simple.order.manager.pojo.OrderPOJO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRepository extends CrudRepository<OrderPOJO, Long> {

    @Query("FROM OrderPOJO WHERE status=?1")
    List<OrderPOJO> findOrOrderPOJOSByStatus(Status status);


    OrderPOJO findOrderPOJOById(Long id);

    OrderPOJO  save(OrderPOJO orderPOJO);
}
