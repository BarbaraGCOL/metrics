package br.com.metrics.model;

import static br.com.metrics.pattern.DesignPatterns.*;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
 
@Entity
@Table(name = "Perfil")
public class Profile {
 
    @Id
    private Long id;
    
    @Column(name="Primeiro_Nome_" + SUFIXO_PERFIL)
    private String firstName;
    
    @Column(name="Ultimo_Nome_" + SUFIXO_PERFIL)
    private String lastName;
    
    @NaturalId
    @Column(name="Email_" + SUFIXO_PERFIL)
    private String email;
    
    @Column(name="Sexo_" + SUFIXO_PERFIL)
    private String sexy;
    
    @Column(name="Aniversario_" + SUFIXO_PERFIL)
    private Date birth;
 
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private User user;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getSexy() {
        return sexy;
    }
 
    public void setSexy(String sexy) {
        this.sexy = sexy;
    }
 
    public Date getBirth() {
        return birth;
    }
 
    public void setBirth(Date birth) {
        this.birth = birth;
    }
}