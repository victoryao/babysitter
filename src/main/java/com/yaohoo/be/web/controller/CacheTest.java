package com.yaohoo.be.web.controller;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheTest {
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping("/cache/{k}")
	public String getSalesBillno(@PathVariable(value = "k") String k) {

		final byte[] key = ( k).getBytes();
		
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.set(key, "qiangyao".getBytes());
				return connection.get(key).toString();
			}
		});
		
		
	}

}
