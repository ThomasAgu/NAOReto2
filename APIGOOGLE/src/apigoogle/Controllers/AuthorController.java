package apigoogle.Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import apigoogle.Models.Author;
import apigoogle.Utils.ParameterStringBuilder;


public class AuthorController {
	
	
	private static String url = "https://serpapi.com/search?";
	private static String API_KEY = "a0b8ed88d72d5850ef0d400172ec5cf0385cb7e70bb77523035932c36ba8d01e";
	public static Map<String, String> parameters = new HashMap<>();
	public static ParameterStringBuilder parameterBuilder = new ParameterStringBuilder();
	
	
	
	public AuthorController() {
        
    }
	
	public void saveAuthors(ArrayList<Author> authors) {
		
		for(int i = 0; i< Math.min(authors.size(), 10) ; i++) {
			authors.get(i).saveAuthor(authors.get(i));
		}
	}
	
	
	public void getAuthorsDeLaUniversidad() throws IOException, InterruptedException {
		
		/* Esta funcion llama a la API de google Schoolar Profiles, preguntando por 
		 * aquellos perfiles de la "Universidad del norte" sobre la respuesta de esta 
		 * consulta hace un ordenamiento segun la cantidad de citaciones y devuelve 
		 * los TOP 10 */
		
		
		parameters.put("engine", "google_scholar_profiles");
		parameters.put("mauthors", "UniversidadDelNorte");
    	parameters.put("api_key", API_KEY);
    	
    	String parametros = parameterBuilder.getParamsString(parameters);
    	
    	
    	url = url +parametros;
    	
    	

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        
    	   
        HttpResponse<String> response = client.send(request,
        HttpResponse.BodyHandlers.ofString());
   
        
		ObjectMapper objectMapper = new ObjectMapper();
        String responseBody = response.body();
        JsonNode rootNode = objectMapper.readTree(responseBody.toString());
        JsonNode profilesNode = rootNode.get("profiles");
        JsonNode[] profilesArray = objectMapper.treeToValue(profilesNode, JsonNode[].class);
        
        ArrayList<Author> autores= new ArrayList<Author>();
        
		for(int i = 0; i< profilesArray.length; i++) {
			JsonNode autor = profilesArray[i];
			String author_id = autor.get("author_id").asText();
			String name = autor.get("name").asText();
			String affiliations = autor.get("affiliations").asText();
			int cited_by = autor.get("cited_by").asInt();
			autores.add(new Author(author_id, name, affiliations, cited_by));	
		}
		
		//Ordenarlos segun su Citaciones asi tenemos el top10 de investigadores :D
		autores.sort((autor1, autor2) -> Integer.compare(autor2.getCitations(), autor1.getCitations()));
		
		this.saveAuthors(autores);
		
     
	}
	
	
	
	
	

}


