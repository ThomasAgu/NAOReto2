package apigoogle.Views;

import java.io.IOException;

import apigoogle.Controllers.ArticleController;

public class Vista {
	
	private ArticleController controller = new ArticleController();
	
	 public void getAuthors() throws InterruptedException, IOException {
	        controller.getArticles();
	 }

}
 