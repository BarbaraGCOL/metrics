package br.com.metrics.business;
 
import br.com.metrics.dao.UserDao;
import br.com.metrics.dao.utils.DAOFactory;
 
public class UserBusiness {
 
    private UserDao userDao;      
     
    public UserBusiness() {
        super();
        setUserDao(DAOFactory.createUser());
    }
     
    public boolean existsValidation(String validation) {
        return userDao.existsValidation(validation);
    }
 
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }     
}