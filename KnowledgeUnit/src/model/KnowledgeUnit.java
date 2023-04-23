package model;

import java.util.List;
import java.util.ArrayList;

public class KnowledgeUnit {

	private String id;
	private String description;
	private Type type;
	private String learnedLessons;
	private Status status;
	private List<String> hashtags;
	public KnowledgeUnit(String id, String description, Type type, String learnedLessons) {

		this.id = id;
		this.description = description;
		this.type = type;
		this.learnedLessons = learnedLessons;
		hashtags=new ArrayList<String>();
		this.status = Status.UNDEFINED;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getLearnedLessons() {
		return learnedLessons;
	}

	public void setLearnedLessons(String learnedLessons) {
		this.learnedLessons = learnedLessons;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String toString() {

		String msg = "";

		msg = "\nID:" + id + "\nDescription: " + description + "\nType: " + type+ "\nHashtags: " 
				+ "\nLeason Learned: " + learnedLessons + "\nStatus: " + status+ "\n";

		return msg;

	}
	public void addKnowledgeUnitHashtag(String hashtag){
        hashtags.add("#"+hashtag+"#");
    }
	
	public String getKnowledgeUnitHashtags() {
        String msg="";
        int c=0;
        for(String sup:hashtags){
            c++;
            msg+=sup+"";
        }
        return msg;
	}
	

}
