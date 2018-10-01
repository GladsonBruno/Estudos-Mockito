package com.estudos.mockito.powermock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CollaboratorWithFinalMethods.class})
public class PowerMockTest {

	
	
	@Test
	public void testingFinalMethods() {
		
		try {
			
			CollaboratorWithFinalMethods mock = mock(CollaboratorWithFinalMethods.class);
			
			whenNew(CollaboratorWithFinalMethods.class).withNoArguments().thenReturn(mock);
			
			CollaboratorWithFinalMethods collaborator = new CollaboratorWithFinalMethods();
			verifyNew(CollaboratorWithFinalMethods.class).withNoArguments();
			
			when(collaborator.helloMethod()).thenReturn("Hello Baeldung!");
			
			String welcome = collaborator.helloMethod();
			
			verify(collaborator).helloMethod();
			Assert.assertEquals("Hello Baeldung!", welcome);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	
}

