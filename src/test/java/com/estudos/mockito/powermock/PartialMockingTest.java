package com.estudos.mockito.powermock;

import static org.mockito.Mockito.*;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CollaboratorForPartialMocking.class})
public class PartialMockingTest {

	@Test
	public void testStaticMethod() {
		
		PowerMockito.mockStatic(CollaboratorForPartialMocking.class);
		
		PowerMockito.spy(CollaboratorForPartialMocking.class);
		PowerMockito.when(CollaboratorForPartialMocking.staticMethod()).thenReturn("I am a static mock method.");
		
		String returnValue = CollaboratorForPartialMocking.staticMethod();
		
		PowerMockito.verifyStatic();
		CollaboratorForPartialMocking.staticMethod();
		
		Assert.assertEquals("I am a static mock method.", returnValue);

	}
	
	
	@Test
	public void testPrivateMethod() {
		
		CollaboratorForPartialMocking collaborator = new CollaboratorForPartialMocking();
		CollaboratorForPartialMocking mock = PowerMockito.spy(collaborator);
		
		PowerMockito.when(mock.finalMethod()).thenReturn("I am a final mock method.");
		String returnValue = mock.finalMethod();
		Mockito.verify(mock).finalMethod();
		
		Assert.assertEquals("I am a final mock method.", returnValue);
		
		try {
			
			PowerMockito.when(mock, "privateMethod").thenReturn("I am a private mock method.");
			returnValue = mock.privateMethodCaller();
			
			PowerMockito.verifyPrivate(mock).invoke("privateMethod");
			
			Assert.assertEquals("I am a private mock method. Welcome to the Java world.", returnValue);
			
		} catch(Exception e) {
			
			Assert.fail(e.getMessage());
			
		}
	}
	
}
