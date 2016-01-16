package br.com.metrics.dao;
 
import java.util.Properties;
 

import br.com.metrics.model.Profile;
 
public interface ProfileDao {
 
    public void save(Profile profile);
     
    public boolean existsEmail(String email);
     
    public Properties profileActives();
}