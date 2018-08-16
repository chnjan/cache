/**
 * 
 */
package com.chnjan.cache.ehcache;

import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

/**
 * @author chenjian
 * @date 2018年7月23日
 */
public class CacheDemo {
	
	private CacheManager cacheManager;
	
	public Cache getCurrentUserCache() {
		Cache currentUserCache = cacheManager.getCache("currentUser");
		currentUserCache.put("2018", "666666666");
		return currentUserCache;
	}
	
	public Object getCacheValue(String cacheName, Object key) {
		Cache cache = cacheManager.getCache(cacheName);
		System.out.println(cache);
		if (cache == null) {
			return null;
		}
		ValueWrapper valueWrapper = cache.get(key);
		if (valueWrapper == null) {
			return null;
		}
		return valueWrapper.get();
	}
	
	public void putCacheValue(String cacheName, Object key, Object value) {
		Cache cache = cacheManager.getCache(cacheName);
		if (cache == null) {
			return;
		}
		cache.put(key, value);
	}

	/**
	 * @return the cacheManager
	 */
	public CacheManager getCacheManager() {
		return cacheManager;
	}

	/**
	 * @param cacheManager the cacheManager to set
	 */
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	
}
