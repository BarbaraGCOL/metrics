package br.com.metrics.business;
 
import br.com.metrics.dao.ProfileDao;
import br.com.metrics.dao.util.DAOFactory;
import br.com.metrics.model.Profile;

import java.util.Properties;

public class ProfileBusiness {
  
	private ProfileDao ProfileDao;
    
    public ProfileBusiness() {
        super();
        setProfileDao(DAOFactory.createProfile());
    }    
     
    private void setProfileDao(ProfileDao profileDao) {
        ProfileDao = profileDao;
    }
 
    public void save(Profile Profile){
        ProfileDao.save(Profile);
    }
     
    public boolean existsEmail(String email){
        return ProfileDao.existsEmail(email);
    }
     
    public Properties profileActives(){
        return ProfileDao.profileActives();
    }  
}