package org.litespring.beans;

import java.util.List;

public interface BeanDefinition {
	public static final String SCOPE_SINGLETON = "singleton";
	public static final String SCOPE_PROTOTYPE = "prototyppe";
	public static final String SCOPE_DEFAULT = "";
	public boolean isSingleton();
	public boolean isPrototype();
	String getScope();
	void setScope(String scope);

	String getBeanClassName();
	
	public List<PropertyValue> getPropertyValues();
	
	public ConstructorArgument getConstructorArgument();

}
