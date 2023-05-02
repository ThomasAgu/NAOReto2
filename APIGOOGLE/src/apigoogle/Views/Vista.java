package apigoogle.Views;

import java.io.IOException;

import apigoogle.Controllers.AuthorController;

public class Vista {
	
	private AuthorController controller = new AuthorController();
	
	 public void getAuthors() throws InterruptedException, IOException {
	        controller.getAuthorsDeLaUniversidad();
	 }

}
 