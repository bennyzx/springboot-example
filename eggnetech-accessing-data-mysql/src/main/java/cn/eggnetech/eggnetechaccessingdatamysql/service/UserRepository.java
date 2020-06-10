package cn.eggnetech.eggnetechaccessingdatamysql.service;

import cn.eggnetech.eggnetechaccessingdatamysql.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * CRUD refers Create, Read, Update, Delete
 *
 * @name:
 * @description: Created by Benny Zhou on 2020/3/17
 */
public interface UserRepository extends CrudRepository<User, Integer> {


}
