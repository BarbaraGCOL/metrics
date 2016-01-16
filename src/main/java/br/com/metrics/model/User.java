package br.com.metrics.model;
 
import static br.com.metrics.pattern.DesignPatterns.SUFIXO_AUTORIZACAO;
import static br.com.metrics.pattern.DesignPatterns.SUFIXO_PROJETO;
import static br.com.metrics.pattern.DesignPatterns.SUFIXO_USUARIO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NaturalId;
  
@Entity
@Table(name="Usuario")
@SequenceGenerator(name = "seq", sequenceName = "seq_ususario", allocationSize = 1, initialValue = 1)
public class User{
      
    @Id
    @GeneratedValue(generator="seq")
    private Long id;
    
    @NaturalId
    @Column(name="Login_" + SUFIXO_USUARIO)
    private String login;
    
    @Column(name="Senha_" + SUFIXO_USUARIO)
    private String password;
    
    @Column(name="Habilitado_" + SUFIXO_USUARIO)
    private Boolean active;
    
    @Column(name="Validacao_" + SUFIXO_USUARIO)
    private String validation;
      
    @ElementCollection(targetClass = String.class)
    @JoinTable(name = SUFIXO_USUARIO + "_" + SUFIXO_AUTORIZACAO,
               uniqueConstraints = { @UniqueConstraint (columnNames = {"id", "autorizacao" })},
               joinColumns = @JoinColumn(name = "id"))
    @Column(name = "autorizacao", length = 40)
    @Cascade(CascadeType.DELETE)
    private Set<String> permissions = new HashSet<String>();    
  
    @ManyToMany
    @Cascade(CascadeType.ALL)
    @JoinTable(
            name = SUFIXO_PROJETO+"_"+SUFIXO_USUARIO,
            joinColumns = @JoinColumn(name = "Projeto_ID"),
            inverseJoinColumns = @JoinColumn(name = "Usuario_ID")
    )
    private Set<Project> projects;

    @OneToMany(mappedBy="manager")
    private Set<Project> managedProjects;
    
    public String getLogin() {
        return login;
    }
  
    public void setLogin(String login) {
        this.login = login;
    }
  
    public String getPassword() {
        return password;
    }
  
    public void setPassword(String password) {
        this.password = password;
    }
  
    public Boolean isActive() {
        return active;
    }
  
    public void setActive(Boolean active) {
        this.active = active;
    }    
  
    public Set<String> getPermissions() {
        return permissions;
    }
  
    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
  
    public Boolean getActive() {
        return active;
    }
  
    public String getValidation() {
        return validation;
    }
  
    public void setValidation(String validation) {
        this.validation = validation;
    }    
    public Long getId() {
        return id;
    }
  
    public void setId(Long id) {
        this.id = id;
    }

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Set<Project> getManagedProjects() {
		return managedProjects;
	}

	public void setManagedProjects(Set<Project> managedProjects) {
		this.managedProjects = managedProjects;
	}    
}