package br.com.metrics.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import br.com.metrics.dao.ProjectDao;
import br.com.metrics.dao.ProjectDaoImpl;
import br.com.metrics.dao.utils.DAOFactory;
import br.com.metrics.model.Project;
 
@ManagedBean(name="projectController")
@ViewScoped
public class ProjectController implements Serializable {
     
	private static final long serialVersionUID = 1L;
	
	private List<Project> projects;
         
    private ProjectDao projectDao;
     
    @PostConstruct
    public void init() {
    	projectDao = new ProjectDaoImpl();
    	setProjectDao(DAOFactory.createProject());
    }    
     
    private void setProjectDao(ProjectDao projectDao) {
    	this.projectDao = projectDao;
    	projects = projectDao.list();
    }
 
    public List<Project> getProjects() {
        return projects;
    }
     
    public void onRowEdit(RowEditEvent event) {
    	setProjectDao(DAOFactory.createProject());
        FacesMessage msg = new FacesMessage("Project Edited", ((Project) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Project) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
    	setProjectDao(DAOFactory.createProject());
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}