package br.com.metrics.dao.impl;
 
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.metrics.dao.ProjectDao;
import br.com.metrics.dao.util.HibernateUtil;
import br.com.metrics.model.Project;
import br.com.metrics.model.Update;
 
public class ProjectDaoImpl implements ProjectDao {
 
    private Session session;
    private Transaction t = null;
    
    public void setSession(Session session) {
        this.session = session;
    }
 
    @Override
    public void saveOrUpdate(Project project){
    	session = HibernateUtil.getSessionFactory().openSession();
		try {
			t=session.beginTransaction();
			session.saveOrUpdate(project);
			t.commit();
			System.out.println("Projeto " + project.getName() + " Cadastrado com sucesso!");
		} catch (HibernateException e) {
			t.rollback();
			System.out.println("Não foi possível cadastrar o projeto: " + e);
		} finally {
			session.close();
		}
    }

	@Override
	public void delete(Project project) {
		session.delete(project);
	}

	@Override
	public List<Project> list() {
		session = HibernateUtil.getSessionFactory().openSession();
		List<Project> projects = new ArrayList<Project>();
		
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
    public Update lastUpdate(Project project){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        List<Update> list = new ArrayList<Update>();

        try {
            t = session.beginTransaction();
            Query query = session.createQuery("from Atualizacao a "
                    + "where a.id = (select max(id) "
                    + "from Atualizacao "
                    + "where projeto.id = " + project.getId() + ")");
            
            list = (ArrayList<Update>) query.list();
        } catch (HibernateException e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            session.close();
        }
        if(list == null || list.isEmpty()){
            return new Update();
        }
            
        return list.get(0);
    }
}