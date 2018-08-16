/**
 * 
 */
package com.chnjan.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chnjan.cache.ehcache.CacheDemo;
import com.chnjan.domain.UserInfo;

/**
 * @author chenjian
 * @date 2018年7月23日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class CacheTest {
	
	@Autowired
	private CacheDemo cacheDemo;
	
	@Test
	public void testCache() throws InterruptedException {
		Cache usercache = cacheDemo.getCurrentUserCache();
		Thread.sleep(2000);
		String res = (String) usercache.get("2018").get();
		System.out.println(res);
	}
	
	//测试缓存的时间相关
	@Test
	public void testCacheF() throws InterruptedException {
		cacheDemo.putCacheValue("currentUser", "2019", "88888");
		String cacheValue = (String) cacheDemo.getCacheValue("currentUser", "2019");
		System.out.println("1："+cacheValue);
		Thread.sleep(4000);
		String cacheValue2 = (String) cacheDemo.getCacheValue("currentUser", "2019");
		System.out.println("2："+cacheValue2);
		Thread.sleep(1000);
		String cacheValue3 = (String) cacheDemo.getCacheValue("currentUser", "2019");
		System.out.println("3："+cacheValue3);
	}
	
	//没有配的cache会返回空
	@Test
	public void testdefault() {
		cacheDemo.getCacheValue("ccu", "2019");
	}
	
	//测试缓存对象,本地对象可以不用序列化
	@Test
	public void testObjectCache() {
		UserInfo userInfo = new UserInfo();
		userInfo.setName("陈");
		userInfo.setAge(28);
		cacheDemo.putCacheValue("currentUser", "2019", userInfo);
		UserInfo userInfo2 = (UserInfo) cacheDemo.getCacheValue("currentUser", "2019");
		System.out.println(userInfo2);
	}

}
