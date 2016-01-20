package br.com.metrics.dao.util;
 
import br.com.metrics.dao.ProfileDao;
import br.com.metrics.dao.ProjectDao;
import br.com.metrics.dao.UserDao;
import br.com.metrics.dao.impl.ProfileDaoImpl;
import br.com.metrics.dao.impl.ProjectDaoImpl;
import br.com.metrics.dao.impl.UserDaoImpl;
  
public class DAOFactory {
  
    public static ProfileDao createProfile(){
        ProfileDaoImpl profileDaoImpl = new ProfileDaoImpl();
        profileDaoImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return profileDaoImpl;
    }
    
    public static UserDao createUser(){
        UserDaoImpl userImpl = new UserDaoImpl();
        userImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return userImpl;
    }
    
    public static ProjectDao createProject(){
        ProjectDaoImpl projectImpl = new ProjectDaoImpl();
        projectImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return projectImpl;
    }
}