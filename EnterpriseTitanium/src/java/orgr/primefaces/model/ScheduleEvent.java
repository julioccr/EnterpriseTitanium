/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orgr.primefaces.model;

import java.util.Date;

/**
 *
 * @author Julio Cortorreal
 */
public interface ScheduleEvent {
  public String getId();

    public void setId(String string);

    public Object getData();

    public String getTitle();

    public Date getStartDate();

    public Date getEndDate();
    
    public Date getStartHourDate();

    public Date getEndHourDate();
    
    public boolean isAllDay();

    public String getStyleClass();

    public boolean isEditable();

    public String getDescription();  
    
    public String getCategoria();
    
    public String getPrioridad();
   
    public String getTipo();
    
    // Dias
     public String getLunes();  
     public String getMartes();  
     public String getMiercoles();  
     public String getJueves();  
     public String getViernes();  
     public String getSabado();  
     public String getDomingo();  
    
    
    
}
