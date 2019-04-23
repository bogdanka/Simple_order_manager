package com.simple.order.manager.service;

import com.simple.order.manager.pojo.OrderPOJO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<OrderPOJO> getAllRecordsByUserId();
    List<OrderPOJO> saveNewRequest(OrderPOJO orderPOJO );

}
