package com.estudos.mockito.dataacess;

import java.util.ArrayList;
import java.util.List;

import com.estudos.mockito.model.PersonModel;

public class ConsultaDataBaseFachada {

	public ConsultaDataBaseFachada() {
		
	}
	
	List<PersonModel> persons = new ArrayList<PersonModel>() {{
		new PersonModel("Maria", 30);
		new PersonModel("José", 28);
		new PersonModel("Marcia", 28);
	}};
	
	public PersonModel ConsultaDataBase(String name) {
		
		return persons.stream().filter(p -> p.getName().equals(name)).findFirst().get();
		
	}
	
	
}