package com.estudos.mockito.annotations;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.estudos.mockito.annotations.injectmocks.ArticleManager;
import com.estudos.mockito.annotations.injectmocks.dependencys.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleManagerTest {

	@Mock ArticleDataBase database;
	
	@Mock User user;
	
	@InjectMocks private ArticleManager manager;
	
	@Test public void facaAlgumaCoisa() {
		manager.initialize();
		
		
		verify(database).addListener(any(ArticleListener.class));
	}
	
}
