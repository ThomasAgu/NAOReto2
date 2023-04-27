package apigoogle.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import apigoogle.Utils.ConexionDB;

public class Article {
	private String idArticle;
	private String title;
	private String link;
	private String authors; //los autor/es del articulo
	private String publication;
	private int year;
	private int cited_by;
	
	
	public Article( String title, String link, String authors, String publication, int year, int cited_by) {
		super();
		this.title = title;
		this.link = link;
		this.authors = authors;
		this.publication = publication;
		this.year = year;
		this.cited_by = cited_by;
	}
	
	public void saveArticle(Article article) {
		String sql = "INSERT INTO article (title, link, authors, publication, year, cited_by) VALUES ('" + article.getTitle() + "', '" + article.getLink() + "', '" + article.getAuthors() + "', '" + article.getPublication() + "', '" + article.getYear() + "', '" + article.getCited_by() + "')";
		System.out.println(sql);
		try {
			ConexionDB c = new ConexionDB();
			Statement stmt = c.getConexion().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			c.cerrarConexion();
		}
		catch(Exception e) {
			System.out.println("Hubo un problema en la insercion del articulo");
		}
					
	}

	

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public String getAuthors() {
		return authors;
	}



	public void setAuthors(String authors) {
		this.authors = authors;
	}



	public String getPublication() {
		return publication;
	}



	public void setPublication(String publication) {
		this.publication = publication;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public int getCited_by() {
		return cited_by;
	}



	public void setCited_by(int cited_by) {
		this.cited_by = cited_by;
	}



	@Override
	public String toString() {
		return "Articles [title=" + title + ", link=" + link + ", authors=" + authors + ", publication=" + publication
				+ ", year=" + year + ", cited_by=" + cited_by +  "]";
	}

	
}
