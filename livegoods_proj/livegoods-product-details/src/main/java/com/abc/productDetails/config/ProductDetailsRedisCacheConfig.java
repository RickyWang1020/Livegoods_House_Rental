package com.abc.productDetails.config;

import com.abc.redis.config.RedisCacheConfig;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class ProductDetailsRedisCacheConfig extends RedisCacheConfig {

    @Bean
    @Override
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return super.cacheManager(redisConnectionFactory);
    }
}
