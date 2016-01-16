package br.com.metrics.dao;
 
import br.com.metrics.model.User;
 
public interface UserDao {
     public boolean existsValidation(String validation);
     public void save(User user);
}