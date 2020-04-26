package com.cenfotec.exam.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Patent {

	@Id
	private String id;
	private String guid;
	private String name;
	private String discovered_by;
	private Date entry_date;
	private String microorganism;

	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	public Patent() {

	}

	public Patent(String spice_name, String discovered_by, String micro) {
		this.name = spice_name;
		this.discovered_by = discovered_by;
		this.microorganism = micro;
		this.entry_date = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMicroorganism(String microorganism) {
		this.microorganism = microorganism;
	}

	public String getCreatedAsShort() {
		return format.format(entry_date);
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getGuid() {
		return this.guid;
	}

	public String getName() {
		return name;
	}

	public void setName(String spice_name) {
		this.name = spice_name;
	}

	public String getDiscovered_by() {
		return discovered_by;
	}

	public void setDiscovered_by(String discovered_name) {
		this.discovered_by = discovered_name;
	}

	public Date getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	public SimpleDateFormat getFormat() {
		return format;
	}

	public void setFormat(SimpleDateFormat format) {
		this.format = format;
	}

	public String getMicroorganism() {
		return microorganism;
	}

	@Override
	public String toString() {
		return "Patent \n" + "id: " + id + "\n" + "guid: " + guid + "\n" + "name: " + name + "\n" + "discovered_by: "
				+ discovered_by + "\n" + "entry_date: " + entry_date + "\n" + "microorganism: " + microorganism;
	}

}
