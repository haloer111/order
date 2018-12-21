package com.aojing.redstore.order.config;

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author gexiao
 * @date 2018/12/20 10:42
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.aojing.redstore.order.dao")
public class MybatisPlusConfig {

    /**
     * SQL执行效率插件
     */
    @Bean
   // @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }
}
