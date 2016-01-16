package br.com.metrics.model;

import static br.com.metrics.pattern.DesignPatterns.*;
import static javax.persistence.CascadeType.PERSIST;

import java.io.Serializable;
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

/**
 * 
 * @author barbara.lopes
 *
 */
@Entity
@Table(name = "Metrica")
public class Metric implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_"+SUFIXO_METRICA, nullable = false,unique = true)
    private int id;
   
	@ManyToOne(cascade = PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_" + SUFIXO_TIPO_METRICA, nullable = false)
	private MetricAvailable type;
	
    @ManyToOne(cascade = PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_" + SUFIXO_ATUALIZACAO, nullable = false)
    private Update update;
    
    @OneToMany(mappedBy="metric")
    Set<Value>values;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MetricAvailable getType() {
		return type;
	}

	public void setType(MetricAvailable type) {
		this.type = type;
	}

	public Update getUpdate() {
		return update;
	}

	public void setUpdate(Update update) {
		this.update = update;
	}

	public Set<Value> getValues() {
		return values;
	}

	public void setValues(Set<Value> values) {
		this.values = values;
	}
}
