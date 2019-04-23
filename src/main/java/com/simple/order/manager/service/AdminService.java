package com.simple.order.manager.service;

import com.simple.order.manager.model.Status;
import com.simple.order.manager.pojo.OrderPOJO;

import java.util.List;

public interface AdminService {

    List<OrderPOJO> getAllCurrentRecords();
    List<OrderPOJO> getAllCurrentRecordsByStatus(Status status);
    List<OrderPOJO> completeOrderById(Long id);
    List<OrderPOJO> rejectOrderById(Long id);
}
