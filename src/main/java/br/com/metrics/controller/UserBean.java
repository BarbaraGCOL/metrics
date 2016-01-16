package br.com.metrics.controller;
 
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.metrics.business.ProfileBusiness;
import br.com.metrics.model.Profile;
import br.com.metrics.model.User;
import br.com.metrics.utils.GenerateValidation;
import br.com.metrics.utils.ManipulateDate;
import br.com.metrics.utils.Role;
import br.com.metrics.utils.ServiceFinder;
import br.com.metrics.utils.SimpleRegistrationService;
import br.com.metrics.utils.security.GenerateMD5;
 
@ManagedBean(name = "user")
@RequestScoped
public class UserBean {
 
    private User user = null;
    private Profile profile = null;
 
    private int day = 0;
    private int month = 0;
    private int year = 0;
 
    @PostConstruct
    public void init() {
        user = new User();
        profile = new Profile();
    }
 
    public String save() {
        ProfileBusiness profileBusiness = new ProfileBusiness();
        user.setPassword(GenerateMD5.generate(user.getPassword()));
        user.setValidation(GenerateValidation.keyValidation());
        user.getPermissions().add(Role.ROLE_COMMON.getValue());
        user.setActive(false);        
        profile.setUser(user);
        profile.setBirth(ManipulateDate.getDate(year, month, day));
        profileBusiness.save(profile);
      
        SimpleRegistrationService mail = (SimpleRegistrationService) ServiceFinder.findBean("registrationService");
        mail.register(profile);
         
        return "/public/feedback_login";
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    public Profile getProfile() {
        return profile;
    }
 
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
 
    public Map<String, Object> getDays() {
        return ManipulateDate.getDays();
    }
 
    public Map<String, Object> getMonths() {
        return ManipulateDate.getMonths();
    }
 
    public Map<String, Object> getYears() {
        return ManipulateDate.getYears();
    }
 
    public int getDay() {
        return day;
    }
 
    public void setDay(int day) {
        this.day = day;
    }
 
    public int getMonth() {
        return month;
    }
 
    public void setMonth(int month) {
        this.month = month;
    }
 
    public int getYear() {
        return year;
    }
 
    public void setYear(int year) {
        this.year = year;
    }
}