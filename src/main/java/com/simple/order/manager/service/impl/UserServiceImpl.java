package com.simple.order.manager.service.impl;

import com.simple.order.manager.model.AppUserPrincipal;
import com.simple.order.manager.model.Status;
import com.simple.order.manager.pojo.OrderPOJO;
import com.simple.order.manager.pojo.UserPOJO;
import com.simple.order.manager.repository.OrderRepository;
import com.simple.order.manager.repository.UserRepository;
import com.simple.order.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderPOJO> getAllRecordsByUserId() {
        UserPOJO userPOJO = getUser();
        return orderRepository.findAllByUser(userPOJO);
    }

    @Transactional
    @Override
    public List<OrderPOJO> saveNewRequest(OrderPOJO orderPOJO) {
        orderPOJO.setUser(getUser());
        orderPOJO.setStatus(Status.ACCEPTED);
        OrderPOJO save = orderRepository.save(orderPOJO);
        List<OrderPOJO> listOrders = orderRepository.findAllByUser(orderPOJO.getUser());
        return listOrders.isEmpty() ? Collections.EMPTY_LIST : listOrders;
    }


    private UserPOJO getUser() {
        AppUserPrincipal principal = (AppUserPrincipal) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return userRepository.findUserPOJOById(principal.getUserId());
    }


}
