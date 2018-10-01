package com.estudos.mockito.powermock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CollaboratorWithStaticMethods.class})
public class StaticMethodsPowerMock {

	@Test
	public void testingStaticMethods() {
		
		PowerMockito.mockStatic(CollaboratorWithStaticMethods.class);
		
		PowerMockito.when(CollaboratorWithStaticMethods.firstMethod(Mockito.anyString())).thenReturn("Hello Baeldung!");
		String firstWelcome = CollaboratorWithStaticMethods.firstMethod("Teste");
		String secondWelcome = CollaboratorWithStaticMethods.firstMethod("Teste novo");
		
		PowerMockito.when(CollaboratorWithStaticMethods.secondMethod()).thenReturn("Nothing special");
		CollaboratorWithStaticMethods.secondMethod();
		
		
		Assert.assertEquals("Hello Baeldung!", firstWelcome);
		Assert.assertEquals("Hello Baeldung!", secondWelcome);
		
		verifyStatic(Mockito.times(2));
		CollaboratorWithStaticMethods.firstMethod(Mockito.anyString());
		
		verifyStatic(Mockito.times(1));
		CollaboratorWithStaticMethods.secondMethod();
		
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testeComRetornoExceptionRunTime() {
			
		PowerMockito.mockStatic(CollaboratorWithStaticMethods.class);
		
		when(CollaboratorWithStaticMethods.thirdMethod()).thenThrow(new RuntimeException());
		CollaboratorWithStaticMethods.thirdMethod();
		
	}
	
}

	