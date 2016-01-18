package br.com.metrics.dao;
 
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.metrics.model.Project;
import br.com.metrics.model.Update;
import br.com.metrics.util.HibernateUtil;
 
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
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Project> projects = new ArrayList<Project>();
		Transaction t = null;
		
		try {
			t=session.beginTransaction();
			Query query = session.createQuery("from Project");
			projects = (ArrayList<Project>)query.list(); 
		} catch (HibernateException e) {
			t.rollback();
		} finally {
			session.close();
		}
		return projects;
	}

	@Override
	public Update lastUpdate(Project project) {
		return null;
	}
}