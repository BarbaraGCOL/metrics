package br.com.metrics.model;

import static br.com.metrics.pattern.DesignPatterns.SUFIXO_METRICA;
import static br.com.metrics.pattern.DesignPatterns.SUFIXO_VALOR_METRICA;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author barbara.lopes
 *
 */
@Entity
@Table(name = "Valor_Metrica")
public class Value implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_"+SUFIXO_VALOR_METRICA, nullable = false,unique = true)
    private int id;

    @Column(name = "Name_"+SUFIXO_VALOR_METRICA)
    private String name;
    
    @Column(name = "Source_"+SUFIXO_VALOR_METRICA)
    private String source;
    
    @Column(name = "Pack_"+SUFIXO_VALOR_METRICA)
    private String pack;
    
    @Column(name = "Value_"+SUFIXO_VALOR_METRICA)
    private Float value;
    
    @ManyToOne
    @JoinColumn(name = "Id_" + SUFIXO_METRICA)
    private Metric metric;

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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Metric getMetric() {
		return metric;
	}

	public void setMetric(Metric metric) {
		this.metric = metric;
	}
}