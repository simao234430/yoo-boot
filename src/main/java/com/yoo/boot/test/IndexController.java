package com.yoo.boot.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("index")
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index() {
        log.error("111");
        return "helloword!";
    }

//    @RequestMapping(value = "/testResult")
//    @ResponseBody
//    public Result<JSONObject> test() {
//        Result<JSONObject> result = new Result<JSONObject>();
//        return result.error500("3337766");
//    }
}