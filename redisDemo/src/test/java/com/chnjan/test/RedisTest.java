/**
 * 
 */
package com.chnjan.test;

import org.junit.Test;

import com.chnjan.redis.RedisDemo;

/**
 * @author chenjian
 * @date 2018年7月25日
 */
public class RedisTest {

	@Test
	public void cacheRedisTest() {
		RedisDemo rd = new RedisDemo();
		rd.setvalue("2018", "666666");
		String rs = rd.getvalue("2018");
		System.out.println(rs);
	}
	
	@Test
	public void cacheRedisPoolTest() {
		RedisDemo rd = new RedisDemo();
		rd.setvaluePool("2018", "666666，88888888");
		String rs = rd.getvaluePool("2018");
		System.out.println(rs);
	}
}
