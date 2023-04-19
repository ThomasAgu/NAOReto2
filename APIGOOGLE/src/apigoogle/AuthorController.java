package apigoogle;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorController {
	
	private Author model;
	private AuthorView view;
	
	private static String url = "https://serpapi.com/search?";
	private static String API_KEY = "a0b8ed88d72d5850ef0d400172ec5cf0385cb7e70bb77523035932c36ba8d01e";
	public static Map<String, String> parameters = new HashMap<>();
	public static ParameterStringBuilder parameterBuilder = new ParameterStringBuilder();
	
	
	public AuthorController(AuthorView view) {
        this.view = view;
    }
	
	public void getAuthors() throws IOException, InterruptedException {
		
		parameters.put("engine", "google_scholar_author");
    	parameters.put("author_id", "LSsXyncAAAAJ");
    	parameters.put("api_key", API_KEY);
    	
    	String parametros = parameterBuilder.getParamsString(parameters);
    	
    	
    	url = url +parametros;
    	
    	

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        
    	   
        HttpResponse<String> response = client.send(request,
        HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

	}

}


