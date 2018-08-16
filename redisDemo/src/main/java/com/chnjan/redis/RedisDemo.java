/**
 * 
 */
package com.chnjan.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author chenjian
 * @date 2018年7月25日
 */
public class RedisDemo {
	
	private static String host = "127.0.0.1";
	private static int port = 6379;
	
	private Jedis getJedis() {
		Jedis jedis = new Jedis(host, port);
		//设置密码
		//jedis.auth("");
		return jedis;
	}
	
	public void setvalue(String key, String value) {
		Jedis jedis = getJedis();
		jedis.set(key,value);
		jedis.close();
	}
	
	public String getvalue(String key) {
		Jedis jedis = getJedis();
		String res = jedis.get(key);
		jedis.close();
		return res;
	}
	
	private JedisPool getJedisPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(10);
		JedisPool jedisPool = new JedisPool(config, host, port);
		return jedisPool;
	}
	
	public void setvaluePool(String key, String value) {
		JedisPool jedisPool = getJedisPool();
		Jedis jedis = jedisPool.getResource();
		jedis.set(key,value);
		jedis.close();
		jedisPool.close();
	}
	
	public String getvaluePool(String key) {
		JedisPool jedisPool = getJedisPool();
		Jedis jedis = jedisPool.getResource();
		String res = jedis.get(key);
		jedis.close();
		jedisPool.close();
		return res;
	}
}
