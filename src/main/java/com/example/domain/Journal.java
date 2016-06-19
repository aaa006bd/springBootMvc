package com.example.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Journal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private Date created;
	private String title;
	private String summary;
	
	@Transient
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");

	public Journal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Journal(String created, String title, String summary) throws ParseException {
		super();
		this.created = dateFormatter.parse(created);
		this.title = title;
		this.summary = summary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getCreatedAsShort(){
		return dateFormatter.format(created);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("JournalEntry( ");
		builder.append("id: ");
		builder.append(id);
		builder.append(",title: ");
		builder.append(title);
		builder.append(",Summary: ");
		builder.append(summary);
		builder.append(",created: ");
		builder.append(getCreatedAsShort());
		builder.append(")");
		
		return builder.toString();
	}
	
	
	
	
}
