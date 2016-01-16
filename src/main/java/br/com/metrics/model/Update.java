package br.com.metrics.model;

import static br.com.metrics.pattern.DesignPatterns.SUFIXO_ATUALIZACAO;
import static br.com.metrics.pattern.DesignPatterns.SUFIXO_PROJETO;
import static javax.persistence.CascadeType.PERSIST;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
*
* @author barbara.lopes
*/
@Entity
@Table(name = "Atualizacao")
public class Update implements Serializable{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name= "Id_"+SUFIXO_ATUALIZACAO, nullable = false, unique = true)
   private int id;
   
   @Column(name = "Dat_" + SUFIXO_ATUALIZACAO, nullable = false)
   @Temporal(TemporalType.DATE) 
   private Date date;
   
   @LazyCollection(LazyCollectionOption.FALSE)
   @ManyToOne(cascade = PERSIST, fetch = FetchType.LAZY)
   @JoinColumn(name = "Id_"+SUFIXO_PROJETO, nullable = false)
   private Project project;

   @OneToMany( cascade = PERSIST, mappedBy="update", fetch = FetchType.EAGER)
   private Set<Metric> metrics;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	public Set<Metric> getMetrics() {
		return metrics;
	}
	
	public void setMetrics(Set<Metric> metrics) {
		this.metrics = metrics;
	}
}

