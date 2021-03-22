package com.yoo.boot.test;


import com.yoo.boot.common.config.YooConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("test")
public class RestfulController {
    @Autowired
    private YooConfig yooConfig;

    @RequestMapping(value = "tt",method = RequestMethod.GET)
    public List<String> findAllHospital(){
        String tag = "tag1,tag2";
        String[] tags = tag.split(",");
//将数组的每个元素分别添加到list中作为list的元素

        List<String> li = Arrays.asList("a", "b");
        return li;
    }

    @GetMapping("/userInfo")
    public User outputUser(){
        User user=new User();
        user.setId(1001);
        user.setName("Bob");
        user.setAddress("The U.S.A");
        user.setAge(24);
        user.setPhoneNum("13200001111");
        return user;
    }

    @RequestMapping("/test")
    public Map<String, Object> test(){

        Map<String, Object> map = new HashMap<>();
        map.put("version", yooConfig.getName());


        return map;
    }
}
