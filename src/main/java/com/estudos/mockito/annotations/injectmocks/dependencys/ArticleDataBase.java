package com.estudos.mockito.annotations.injectmocks.dependencys;

public class ArticleDataBase {

	/*
	 * Classe para fins didaticos
	 * Não tem uso real
	 * 
	 * 
	 * */
	private ArticleListener listener;
	
	public ArticleDataBase() {
		
	}
	
	public void addListener(ArticleListener listener) {
		this.listener = listener;
	}
	
}
