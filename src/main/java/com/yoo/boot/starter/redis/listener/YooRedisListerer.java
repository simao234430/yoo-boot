package com.yoo.boot.starter.redis.listener;

import com.yoo.boot.common.base.BaseMap;

/**
 * 自定义消息监听
 */
public interface YooRedisListerer {

    void onMessage(BaseMap message);

}
