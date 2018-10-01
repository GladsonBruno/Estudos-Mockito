package com.estudos.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.estudos.mockito.dataacess.ConsultaDataBaseFachada;
import com.estudos.mockito.model.PersonModel;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EstudosMockitoApplicationTests {

	@Mock
	ConsultaDataBaseFachada consultaDatabaseService;
	
	PersonModel personEsperada;
	
	@Before
	public void init() {
		personEsperada = new PersonModel("Maria", 30);
	}
	
	@Test
	public void testeConsulta() {
		
		when(consultaDatabaseService.ConsultaDataBase("Maria")).thenReturn(personEsperada);
		PersonModel result = consultaDatabaseService.ConsultaDataBase("Maria");
		assertEquals(personEsperada, result);
		verify(consultaDatabaseService).ConsultaDataBase("Maria");
	}
	
	@Test(expected = NullPointerException.class)
	public void testeConsultaSemResultado() {
		
		when(consultaDatabaseService.ConsultaDataBase("Pedro")).thenThrow(new NullPointerException());
		PersonModel result = consultaDatabaseService.ConsultaDataBase("Pedro");
		verify(consultaDatabaseService).ConsultaDataBase("Pedro");
	}

}
