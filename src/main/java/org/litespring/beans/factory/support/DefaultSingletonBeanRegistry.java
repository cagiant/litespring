package org.litespring.beans.factory.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.litespring.beans.factory.config.SingletonBeanRegistry;
import org.litespring.util.Assert;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
	private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);
	@Override
	public void registerSingleton(String beanName, Object singletonObject) {
		// TODO Auto-generated method stub
		Assert.notNull(beanName, "'beanName' must not be null");
		Object oldObject = this.singletonObjects.get(beanName);
		if (oldObject != null) {
			throw new IllegalStateException("Could not registre object [" + singletonObject + 
					"] under bean name'" + beanName + "': there is already object[" + oldObject + "'");
		}
		this.singletonObjects.put(beanName, singletonObject);
	}

	@Override
	public Object getSingleton(String beanName) {
		// TODO Auto-generated method stub
		return this.singletonObjects.get(beanName);
	}

}
