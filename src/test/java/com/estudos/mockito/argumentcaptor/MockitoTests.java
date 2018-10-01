package com.estudos.mockito.argumentcaptor;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTests {

	@Captor
	private ArgumentCaptor<List<String>> captor;
	
	@Test
	public final void shouldContainCertainListItem() {
		List<String> asList = Arrays.asList("someElement_test", "someElement");
		
		final List<String> mockedList = mock(List.class);
		mockedList.addAll(asList);
		
		verify(mockedList).addAll(captor.capture());
		final List<String> capturedArgument = captor.getValue();
		assertThat(capturedArgument, hasItem("someElement"));
		
	}
	
}
