package br.com.metrics.model;

import static br.com.metrics.pattern.DesignPatterns.SUFIXO_METRICA;
import static javax.persistence.CascadeType.PERSIST;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author barbara.lopes
 *
 */
@Entity
@Table(name = "Metrica_Disponivel")
public class MetricAvailable implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_"+SUFIXO_METRICA, nullable = false,unique = true)
    private int id;
    
	@Column(name="Sigla_" + SUFIXO_METRICA, nullable = false)
    private String initials;
	
	@Column(name="Desc_" + SUFIXO_METRICA, nullable = false)
    private String description;
	
	@Column(name="Desc_Port_" + SUFIXO_METRICA, nullable = false)
    private String descriptionPT;
	
	@Column(name="Nivel_" + SUFIXO_METRICA, nullable = false)
    private String level;
	
	@Column(name="Dica_" + SUFIXO_METRICA, nullable = false)
    private String hint;
	
	@Column(name="Dica_Port_" + SUFIXO_METRICA, nullable = false)
    private String hintPT;
	
	@Column(name="Maximo_Sugerido_" + SUFIXO_METRICA, nullable = false)
    private Float maximumSugested;
	
	@OneToMany(cascade=PERSIST, mappedBy="metric")
	private Set<Monitoring> monitorings;
	
	@OneToMany(mappedBy="type")
    Set<Metric>metrics;

	public MetricAvailable(int id, String initials, String description,
			String descriptionPT, String level, String hint, String hintPT,
			Float maximumSugested, Set<Monitoring> monitorings,
			Set<Metric> metrics) {
		super();
		this.id = id;
		this.initials = initials;
		this.description = description;
		this.descriptionPT = descriptionPT;
		this.level = level;
		this.hint = hint;
		this.hintPT = hintPT;
		this.maximumSugested = maximumSugested;
		this.monitorings = monitorings;
		this.metrics = metrics;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionPT() {
		return descriptionPT;
	}

	public void setDescriptionPT(String descriptionPT) {
		this.descriptionPT = descriptionPT;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public String getHintPT() {
		return hintPT;
	}

	public void setHintPT(String hintPT) {
		this.hintPT = hintPT;
	}

	public Float getMaximumSugested() {
		return maximumSugested;
	}

	public void setMaximumSugested(Float maximumSugested) {
		this.maximumSugested = maximumSugested;
	}

	public Set<Monitoring> getMonitorings() {
		return monitorings;
	}

	public void setMonitorings(Set<Monitoring> monitorings) {
		this.monitorings = monitorings;
	}

	public Set<Metric> getMetrics() {
		return metrics;
	}

	public void setMetrics(Set<Metric> metrics) {
		this.metrics = metrics;
	}
}
