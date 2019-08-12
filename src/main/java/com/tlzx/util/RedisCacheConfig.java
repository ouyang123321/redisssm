package com.tlzx.util;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * 通过spring管理redis缓存配置
 *
 * @author Administrator
 *
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
    private volatile JedisConnectionFactory jedisConnectionFactory;
    private volatile RedisTemplate<String, String> redisTemplate;
    private volatile RedisCacheManager redisCacheManager;
    /*
    * volatile:用以声明变量的值可能随时会被别的线程修改，volatile关键词修饰的变量会强制将修改的值立即写入主存，主存中的值更新会使缓存中的值失效。volatile会禁止指令重排
    *               （非volatile变量不具备这样的属性，非volatile变量的值会被缓存，线程A更新了这个值，线程B读取这个变量的值可能读取的并不是更新后的值）
    * 面试区分volatile和synchronized
    * */

    public RedisCacheConfig() {
        super();
    }

    /**
     * 带参数的构造方法 初始化所有的成员变量
     *
     * @param jedisConnectionFactory
     * @param redisTemplate
     * @param redisCacheManager
     */
    public RedisCacheConfig(JedisConnectionFactory jedisConnectionFactory, RedisTemplate<String, String> redisTemplate,
                            RedisCacheManager redisCacheManager) {
        this.jedisConnectionFactory = jedisConnectionFactory;
        this.redisTemplate = redisTemplate;
        this.redisCacheManager = redisCacheManager;
    }

    public JedisConnectionFactory getJedisConnecionFactory() {
        return jedisConnectionFactory;
    }

    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    public RedisCacheManager getRedisCacheManager() {
        return redisCacheManager;
    }

    @Bean
    public KeyGenerator keyGenerator() {/*密钥生成器*/
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                //sb.append(target.getClass().getName());
                sb.append(method.getName());
                if(objects.length != 0){
                    sb.append("_");
                    for (Object obj : objects) {
                        sb.append(obj.toString());
                    }
                }
                return sb.toString();
            }
        };
    }
    /*SimpleKeyGenerator*/
}