package br.com.metrics.model;

import static br.com.metrics.pattern.DesignPatterns.SUFIXO_METRICA;
import static br.com.metrics.pattern.DesignPatterns.SUFIXO_MONITORAMENTO_METRICA;
import static br.com.metrics.pattern.DesignPatterns.SUFIXO_PROJETO;
import static javax.persistence.CascadeType.PERSIST;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author barbara.lopes
 *
 */
@Entity
@Table(name = "Monitoramento_Metricas")
public class Monitoring implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_" + SUFIXO_MONITORAMENTO_METRICA, nullable = false,unique = true)
    private int id;
    
    @Column(name="minimo", nullable = false)
    private Float minimum = 0f;
    
    @Column(name="maximo")
    private Float maximum;

    @ManyToOne(cascade = PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_"+SUFIXO_METRICA, nullable = false)
    private MetricAvailable metric;
    
    @ManyToOne(cascade = PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_"+SUFIXO_PROJETO, nullable = false)
    private Project project;
    
    @Column(name= SUFIXO_MONITORAMENTO_METRICA + "_Habilitado")
    private boolean activated = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getMinimum() {
		return minimum;
	}

	public void setMinimum(Float minimum) {
		this.minimum = minimum;
	}

	public Float getMaximum() {
		return maximum;
	}

	public void setMaximum(Float maximum) {
		this.maximum = maximum;
	}

	public MetricAvailable getMetric() {
		return metric;
	}

	public void setMetric(MetricAvailable metric) {
		this.metric = metric;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}
}
