package br.com.metrics.model;

import static br.com.metrics.pattern.DesignPatterns.*;
import static javax.persistence.CascadeType.PERSIST;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author barbara.lopes
 *
 */
@Entity
@Table(name = "Projeto")
public class Project implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_"+SUFIXO_PROJETO, nullable = false,unique = true)
    private int id;
    
    @Column(name = "Nom_" + SUFIXO_PROJETO, nullable = false)
    private String name;
   
    @Column(name = "Desc_" + SUFIXO_PROJETO, nullable = false)
    private String description;
    
    @OneToMany(cascade=PERSIST, mappedBy="project", fetch = FetchType.EAGER)
    List<Update> updates;
	
	@Column(name = "Dat_Criacao_" + SUFIXO_PROJETO, nullable = false)
	@Temporal(TemporalType.TIMESTAMP) 
	private Date date;

	@Column(name = "Diretorio_" + SUFIXO_PROJETO, nullable = false)
	private String directory;
	
	@OneToMany(cascade= CascadeType.PERSIST, mappedBy="project", fetch = FetchType.EAGER)
	private Set<Monitoring> monitorings;

	@ManyToMany(mappedBy = "projects")
	private Set<User> users;
	
	@ManyToOne
    @JoinColumn(name = "Id_" + SUFIXO_GERENTE)
	private User manager;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Update> getUpdates() {
		return updates;
	}

	public void setUpdates(List<Update> updates) {
		this.updates = updates;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public Set<Monitoring> getMonitorings() {
		return monitorings;
	}

	public void setMonitorings(Set<Monitoring> monitorings) {
		this.monitorings = monitorings;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}
}
