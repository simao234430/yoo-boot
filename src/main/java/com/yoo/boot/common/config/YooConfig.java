package com.yoo.boot.common.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "yoo")
public class YooConfig
{
    /** 项目名称 */
    private String name;

}

