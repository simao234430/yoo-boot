package com.yoo.boot.starter.redis.prop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * redis配置
 *
 * @author pangu
 */
@Getter
@Setter
@ConfigurationProperties(YooRedisProperties.PREFIX)
public class YooRedisProperties {
    /**
     * 前缀
     */
    public static final String PREFIX = "spring.redis";
    /**
     * 是否开启Lettuce
     */
    private Boolean enable = true;
}
