package br.com.metrics.dao.impl;
 
import java.util.List;
import java.util.Properties;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import br.com.metrics.dao.ProfileDao;
import br.com.metrics.model.Profile;
import br.com.metrics.model.User;
  
public class ProfileDaoImpl implements ProfileDao {
  
	private Session session;
	 
    public void setSession(Session session) {
        this.session = session;
    }
     
    @Override
    public void save(Profile profile) {
        session.saveOrUpdate(profile);
    }
     
    public boolean existsEmail(String email){
        return  session.bySimpleNaturalId(Profile.class ).load(email) != null ? true : false;
    }
 
    @Override
    public Properties profileActives() {
         
        List<Object> objects = null;
        Properties prop = new Properties();        
        Criteria criteria = this.session.createCriteria(User.class);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.rowCount())
                .add(Projections.groupProperty("active")));
         
        objects = criteria.list();
         
        for(Object o : objects){
            Object[] objArr = (Object[]) o;
            // chave: active, valor: quantidade
            prop.setProperty(objArr[1].toString(), objArr[0].toString());                
        }        
        return prop;
    }
}