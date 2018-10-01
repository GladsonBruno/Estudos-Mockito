package com.estudos.mockito.annotations.injectmocks;

import com.estudos.mockito.annotations.injectmocks.dependencys.*;

public class ArticleManager {

	private User user;
	private ArticleDataBase database;
	
	public ArticleManager(User user, ArticleDataBase database) {
		super();
		this.user = user;
		this.database = database;
	}
	
	public void initialize() {
		database.addListener(new ArticleListener());
	}
}
