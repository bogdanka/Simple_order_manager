package com.simple.order.manager.repository;

import com.simple.order.manager.pojo.UserPOJO;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserPOJO, Long> {

    UserPOJO findUserPOJOByName(String name);

    UserPOJO findUserPOJOById(Long user_id );



}
