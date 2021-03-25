package com.yoo.boot.starter.redis.service;


import cn.hutool.core.util.ObjectUtil;
import lombok.Data;
import com.yoo.boot.starter.redis.listener.YooRedisListerer;
import com.yoo.boot.common.base.BaseMap;
import com.yoo.boot.common.constant.GlobalConstants;
import com.yoo.boot.common.util.SpringContextHolder;
import org.springframework.stereotype.Component;

@Component
@Data
public class RedisReceiver {


    /**
     * 接受消息并调用业务逻辑处理器
     *
     * @param params
     */
    public void onMessage(BaseMap params) {
        Object handlerName = params.get(GlobalConstants.HANDLER_NAME);
        YooRedisListerer messageListener = SpringContextHolder.getHandler(handlerName.toString(), YooRedisListerer.class);
        if (ObjectUtil.isNotEmpty(messageListener)) {
            messageListener.onMessage(params);
        }
    }

}
