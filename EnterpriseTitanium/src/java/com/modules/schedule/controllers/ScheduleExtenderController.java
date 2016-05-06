/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.schedule.controllers;

import com.modules.schedule.ejb.CompScheduleFacade;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.DefaultScheduleModel;
import com.modules.schedule.models.CompSchedule;
import com.security.controllers.util.JsfUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
 
/**
 *
 * @author Julio Cortorreal
 */
@ManagedBean
@ViewScoped
public class ScheduleExtenderController   implements Serializable {
   
     /*
Primefaces                         Recreadas
Interface ScheduleModel         =  ScheduleModel  // Define los metodos de mantenimiento de los eventos
Interface ScheduleEvent         =  ScheduleEvent  // Define los metodos informativos del evento
Clase     DefaultScheduleModel  =  ScheduleModeltExtenderImplementent // implementa el constructor con la definicion de los metodos ScheduleModel y
							      algunos metodos de ScheduleEvent 
Clase     DefaultScheduleModel  =  DefaultScheduleEvent

*/    
     @PersistenceContext
     EntityManager em;
    
     @Resource
     UserTransaction utx;
     
   
    private ScheduleEvent  event =  new DefaultScheduleEvent();
 
 
    
    private CompSchedule evento;
    private List<CompSchedule> listadeevento = new  ArrayList<CompSchedule>();
   
    
    private ScheduleModel eventModel;        
 
    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
     
          getListadeevento();
         for(int i = 0; i < getListadeevento().size(); i++){
        
            evento =  getListadeevento().get(i);
               
                    eventModel.addEvent(new DefaultScheduleEvent(evento.getAsunto(), evento.getFechaInicio(),  evento.getFechaFin()));
        
        }
         
    }
     
    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);    //set random day of month
         
        return date.getTime();
    }
     
    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
         
        return calendar.getTime();
    }
     
    public ScheduleModel getEventModel() {
        return eventModel;
    }
     

 
    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
 
        return calendar;
    }
     
        
    public ScheduleEvent getEvent() {
        return event;
    }
 
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
     
    public void addEvent(ActionEvent actionEvent) {
        if(event.getId() == null) {
        
        try {
            evento = new CompSchedule (event.getTitle(), event.getStartDate(), event.getEndDate()); 
           utx.begin();
            em.persist(evento);
            utx.commit();
            getListadeevento();
            JsfUtil.addSuccessMessage(":) Se añadio el evento "+ event.getTitle() +" exitosamente" );
        } catch (Exception e) {
      JsfUtil.addErrorMessage("Error al registrar el evento" + event.getTitle()+  " :" + e.getMessage());
        }finally{
        
        em.close();
        
        }
       
        
        
        }  else
              
      try {
         evento.setAsunto(event.getTitle());
         evento.setFechaInicio(event.getStartDate());
         evento.setFechaFin(event.getEndDate());
         
           utx.begin();
            em.merge(evento);
             utx.commit();
             getListadeevento();
              JsfUtil.addSuccessMessage(":) Se actualizo el evento"+ event.getTitle() +"exitosamente" );
        } catch (Exception e) {
      JsfUtil.addErrorMessage("Error al registrar el evento" + event.getTitle()+  " :" + e.getMessage());
        }finally{
        
        em.close();
        
        }
        
        
        
        
        
        event = (ScheduleEvent) new DefaultScheduleEvent();
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
          
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }  

    public CompSchedule getEvento() {
        return evento;
    }

    public void setEvento(CompSchedule evento) {
        this.evento = evento;
    }

    public List<CompSchedule> getListadeevento() {
       
        try {
            
            listadeevento = em.createNamedQuery("CompSchedule.findAll", CompSchedule.class).getResultList();
            
            
        } catch (Exception e) {
            JsfUtil.addErrorMessage( "Error del sistema " + e.getMessage());
        }
        
        return listadeevento;
    }

    public void setListadeevento(List<CompSchedule> listadeevento) {
        this.listadeevento = listadeevento;
    }
}
