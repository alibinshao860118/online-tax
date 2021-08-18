package com.alibinshao.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Author:liangbinbin
 * @Date: 2021 - 08 - 14
 * @Description: com.alibinshao.demo
 * @version:1.0
 */
@RestController
@RequestMapping("api/v1/redis")
public class SpringbootRedisController {

    /**
     * StringRedisTemplate是redis的模版
     * 可以通过ctrl+鼠标左键查看对应的redis的实现方法
     * 用的比较多的是StringRedisTemplate.ops开头的方法
     */
    @Autowired
    private StringRedisTemplate redisImpl;

    @GetMapping(value = "add")
    public Object add() {
        redisImpl.opsForValue().set("name","李明");

        return JsonData.buildSuccess("ok");
    }

    @GetMapping(value = "get")
    public Object get() {
        String value=redisImpl.opsForValue().get("name");
        return JsonData.buildSuccess(value);
    }

}
