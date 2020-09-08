package com.baiyi.controller;

import com.alibaba.druid.util.StringUtils;
import com.baiyi.entity.User;
import com.baiyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserService userService;

    /**
     * 查询所有方法
     * @return
     */
    @GetMapping("findAll")
    public List<User> findAll(){
        List<User> users = userService.findAll();
        return users;
    }

    /**
     * 保存用户
     * @param user 用户信息
     * @return
     */
    @PostMapping("save")
    public Map<String,Object> save(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        try {
            if (StringUtils.isEmpty(user.getId())){
                userService.save(user);
            }else {
                userService.update(user);
            }
            map.put("success", true);
        } catch (Exception exception) {
            map.put("success", false);
            map.put("message", "用户保存或更新失败!");
        }
        return map;
    }

    /**
     * 删除方法
     * @param id 用户 id
     * @return
     */
    @GetMapping("delete")
    public Map<String,Object> delete(String id){
        Map<String, Object> map = new HashMap<>();
        try {
            userService.delete(id);
            map.put("success", true);
        } catch (Exception exception) {
            map.put("success", false);
            map.put("message", "用户删除失败!");
        }
        return map;
    }

    /**
     * 根据 id 查询一个人
     * @param id 用户 id
     * @return 用户的信息
     */
    @GetMapping("findOne")
    public User findOne(String id){
        return userService.findOne(id);
    }

    /**
     * 模糊搜索
     * @param name 用户名
     * @param phoneCode 电话号码
     * @return 用户集
     */
    @GetMapping("findLike")
    public List<User> findNameOrPhoneCode(String name, String phoneCode){
        return userService.findNameOrPhoneCode(name, phoneCode);
    }
}
