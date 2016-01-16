package br.com.metrics.controller.initial;
 
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
  
@RequestScoped
@ManagedBean
public class Index {
  
   @PostConstruct
   public void init(){
      System.out.println("Bean executado!");
   }
  
   public String getMessage(){
      return "Hello World JSF!";
   }
    
   public String login(){
          return "/public/login.xhtml";
   }
    
   public String index(){
          return "/public/index.xhtml";
   }
    
   public String register(){
          return "/public/register.xhtml";
   }
}