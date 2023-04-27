package apigoogle.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {
	private String author_id;
    private String name;
    private String affiliations;
    private int cited_by;

    // Constructor, getters y setters
  
    public Author(String author_id, String name, String affiliations, int cited_by) {
		super();
		this.author_id = author_id;
		this.name = name;
		this.affiliations = affiliations;
		this.cited_by = cited_by;
	}
    

	public String getAuthorID() {
    	return this.author_id;
    }
    


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAffiliation() {
		return affiliations;
	}


	public void setAffiliation(String affiliation) {
		this.affiliations = affiliation;
	}


	public int getCitations() {
		return cited_by;
	}


	public void setCitations(int citations) {
		this.cited_by = citations;
	}


	public void setAuthorID(String authorID) {
		this.author_id = authorID;
	}


	public String toString() {
        return "Author [Nombre=" + name + ", Afiliacion=" + affiliations + ", Citaciones=" + cited_by +  ", Authord id=" + author_id + "]";
    }


}

