package com.yoo.boot.test;


import com.yoo.boot.common.config.YooConfig;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/test")
    public Map<String, Object> test(){

        Map<String, Object> map = new HashMap<>();
        map.put("version", yooConfig.getName());


        return map;
    }
}
