package br.com.metrics.controller;
 
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
 

import javax.faces.bean.ManagedBean;
 

import org.primefaces.model.chart.PieChartModel;
 

import br.com.metrics.business.ProfileBusiness;
 
@ManagedBean(name = "dashboard")
public class DashboardBean {
 
    private PieChartModel pieModel;
     
    private Properties prop = null;
 
    public DashboardBean() {
        ProfileBusiness profileBusiness = new ProfileBusiness();
        prop = profileBusiness.profileActives();
        createPieModel();
    }
 
    public PieChartModel getPieModel() {
        return pieModel;
    }
 
    private void createPieModel() {
        pieModel = new PieChartModel();
        Set actives = prop.keySet();
        Iterator itr = actives.iterator();
        while (itr.hasNext()) {
            String str = (String) itr.next();
            pieModel.set(str, Integer.parseInt((String) prop.get(str)));
        }
    }
}