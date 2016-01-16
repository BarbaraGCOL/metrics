package br.com.metrics.dao;
 
import java.util.List;

import org.hibernate.Session;

import br.com.metrics.model.Project;
 
public class ProjectDaoImpl implements ProjectDao {
 
    private Session session;
 
    public void setSession(Session session) {
        this.session = session;
    }
 
    @Override
    public void saveOrUpdate(Project project){
        session.saveOrUpdate(project);
    }

	@Override
	public void delete(Project project) {
		session.delete(project);
	}

	@Override
	public List<Project> list() {
		@SuppressWarnings("unchecked")
		List<Project> projects = session.createCriteria(Project.class).list();
		return projects;
	}
}