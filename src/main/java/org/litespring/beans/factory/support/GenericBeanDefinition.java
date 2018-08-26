package org.litespring.beans.factory.support;
import java.util.ArrayList;
import java.util.List;

import org.litespring.beans.BeanDefinition;
import org.litespring.beans.PropertyValue;
public class GenericBeanDefinition implements BeanDefinition{
	private String id;
	private String beanClassName;
	private boolean singleton = true;
	private boolean prototype = false;
	private String scope = SCOPE_DEFAULT;
	List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();
	public GenericBeanDefinition(String id, String beanClassName) {
		
		this.id = id;
		this.beanClassName = beanClassName;
	}
	@Override
	public String getBeanClassName() {
		// TODO Auto-generated method stub
		return this.beanClassName;
	}
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return this.singleton;
	}
	@Override
	public boolean isPrototype() {
		// TODO Auto-generated method stub
		return this.prototype;
	}
	@Override
	public String getScope() {
		// TODO Auto-generated method stub
		return this.scope;
	}
	@Override
	public void setScope(String scope) {
		// TODO Auto-generated method stub
		this.scope = scope;
		this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
		this.prototype = SCOPE_PROTOTYPE.equals(scope);
	}
	@Override
	public List<PropertyValue> getPropertyValues() {
		return this.propertyValues;
	}

}
