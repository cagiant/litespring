package org.litespring.test.v1;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.service.v1.PetStoreService;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.core.io.ClassPathResource;;
public class BeanFactoryTest {
	DefaultBeanFactory factory = null;
	XmlBeanDefinitionReader reader = null;
	
	@Before
	public void setUp() {
		factory = new DefaultBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
	}

	@Test
	public void testGetBean() {
		
		reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
		
		
		BeanDefinition bd = factory.getBeanDefinition("petStore");
		
		assertTrue(bd.isSingleton());
		assertFalse(bd.isPrototype());
		
		assertEquals(BeanDefinition.SCOPE_DEFAULT, bd.getScope());
		
		assertEquals("org.litespring.service.v1.PetStoreService", bd.getBeanClassName());
		
		PetStoreService petStore = (PetStoreService)factory.getBean("petStore");
		
		assertNotNull(petStore);
		
		PetStoreService petStore1 = (PetStoreService)factory.getBean("petStore");
		assertTrue(petStore.equals(petStore1));
	}
	
	@Test
	public void testGetInvalidBean() {
		
		reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
		
		try {
			factory.getBean("invalid-bean-id");
		} catch (BeanCreationException e) {
			return;
		}
		Assert.fail("expecting bean creation exception");
	}
	
	@Test
	public void testInvalidXML() {
		try {
			reader.loadBeanDefinitions(new ClassPathResource("xxx.xml"));
		} catch (BeanDefinitionStoreException e) {
			return;
		}
		Assert.fail("expecting bean definition store exception");
	}

}
