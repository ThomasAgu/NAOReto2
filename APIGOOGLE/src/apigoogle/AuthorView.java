package apigoogle;

import java.io.IOException;

public class AuthorView {
	
	private AuthorController controller = new AuthorController(this);
	
	 public void getAuthors() throws InterruptedException, IOException {
	        controller.getAuthors();
	 }

}
