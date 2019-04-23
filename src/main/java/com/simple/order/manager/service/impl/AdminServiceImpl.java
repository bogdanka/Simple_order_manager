package com.simple.order.manager.service.impl;

import com.simple.order.manager.model.Status;
import com.simple.order.manager.pojo.OrderPOJO;
import com.simple.order.manager.repository.AdminRepository;
import com.simple.order.manager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<OrderPOJO> getAllCurrentRecords() {
        return adminRepository.findOrOrderPOJOSByStatus(Status.ACCEPTED);

    }

    @Override
    public List<OrderPOJO> getAllCurrentRecordsByStatus(Status status) {
        return adminRepository.findOrOrderPOJOSByStatus(status);
    }

    @Transactional
    @Override
    public List<OrderPOJO> completeOrderById(Long id) {
        OrderPOJO order = adminRepository.findOrderPOJOById(id);
        OrderPOJO savedOrder = null;
        if (order != null) {
            order.setStatus(Status.COMPLETED);
            savedOrder = adminRepository.save(order);
        }
        return savedOrder != null ? adminRepository.findOrOrderPOJOSByStatus(Status.ACCEPTED) : Collections.EMPTY_LIST;

    }

    @Transactional
    @Override
    public List<OrderPOJO> rejectOrderById(Long id) {
        OrderPOJO order = adminRepository.findOrderPOJOById(id);
        OrderPOJO savedOrder = null;
        if (order != null) {
            order.setStatus(Status.REJECTED);
            savedOrder = adminRepository.save(order);
        }
        return savedOrder != null ? adminRepository.findOrOrderPOJOSByStatus(Status.ACCEPTED) : Collections.EMPTY_LIST;
    }
}
