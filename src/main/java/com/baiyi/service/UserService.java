package com.baiyi.service;

import com.baiyi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void save(User user);

    /**
     * 根据 id 删除用户信息
     * @param id
     */
    void delete(String id);

    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    User findOne (String id);

    /**
     * 根据 id 修改用户信息
     * @param user
     */
    void update(User user);

    /**
     * 根据姓名或电话进行模糊搜索
     * @param name
     * @param phoneCode
     * @return
     */
    List<User> findNameOrPhoneCode(String name, String phoneCode);
}
