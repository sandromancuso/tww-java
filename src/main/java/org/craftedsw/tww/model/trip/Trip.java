package org.craftedsw.tww.model.trip;

import static org.craftedsw.tww.model.trip.Trip.ALL_TRIPS_QUERY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(name=ALL_TRIPS_QUERY,
			query="SELECT t FROM Trip t")

@Entity
public class Trip {

	public static final String ALL_TRIPS_QUERY = "ALL TRIPS";
	
	private int id;
	private String name = "NO NAME";
	private String description;

	public Trip() {
	}
	
	public Trip(String name) {
		this.name = name;
	}
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
