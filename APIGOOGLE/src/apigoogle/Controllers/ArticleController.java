package apigoogle.Controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import apigoogle.Models.Article;
import apigoogle.Models.Author;
import apigoogle.Utils.ParameterStringBuilder;

public class ArticleController {
	

	private AuthorController authorControoller = new AuthorController();
	private static String url = "https://serpapi.com/search?";
	private static String API_KEY = "a0b8ed88d72d5850ef0d400172ec5cf0385cb7e70bb77523035932c36ba8d01e";
	public static Map<String, String> parameters = new HashMap<>();
	public static ParameterStringBuilder parameterBuilder = new ParameterStringBuilder();
	


	public void saveArticles(ArrayList<Article> articles) {
		articles.forEach((a)->{
			a.saveArticle(a);
		});
	}
	
	
	public void getArticles() throws IOException, InterruptedException {
		
		/* Esta consulta lo que hace es por cada autor del top 10 saca su id
		 * y pide los articulos del mismo, esto los guarda en un arreglo
		 * y posteriormente en la BDD */
		
		ArrayList<Author> top10autores = new ArrayList<Author> ();
		top10autores = authorControoller.getAuthorsDeLaUniversidad();
		ArrayList<Article> articles = new ArrayList<Article>();
		
		parameters.put("engine", "google_scholar_author");
    	
    	parameters.put("api_key", API_KEY);
    	
    	
    	
    	
	    	top10autores.forEach(author ->{
	    		
	    		try {
		    		parameters.put("author_id", author.getAuthorID());
		    		
		    		System.out.println(author);
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
			        JsonNode articlesNode = rootNode.get("articles");
			        JsonNode[] articlesArray = objectMapper.treeToValue(articlesNode, JsonNode[].class);
				
			        
			        for(int i = 0; i< Math.min(articlesArray.length, 10) ; i++) {
						JsonNode article = articlesArray[i];
						String title = article.get("title").asText();
						String link = article.get("link").asText();
						String authors = article.get("authors").asText(); 
						String publication = article.get("publication").asText();
						int year = article.get("year").asInt();
						int cited_by = article.get("cited_by").get("value").asInt();
						articles.add(new Article(title, link, authors, publication, year, cited_by));	

			        }
			        
			        
			        parameters.remove("author_id", author.getAuthorID());
	    		}catch(Exception e) {
	    			System.out.println("Ha habido un problema obteniendo los articulos");
		    	}
	    		
	   	
    	});
	    	//save articles in dataBase :D
	    	this.saveArticles(articles);
	        
	        
		}
}
