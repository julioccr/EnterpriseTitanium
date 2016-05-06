/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.schedule.controllers;

import com.modules.schedule.ejb.CompScheduleFacade;
import com.modules.schedule.models.CompSchedule;
import com.security.controllers.util.JsfUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
/**
 *
 * @author Julio Cortorreal
 */
@ManagedBean
@ViewScoped
public class ScheduleView   implements Serializable {
    private ScheduleModel eventModel;
     /*
Primefaces                         Recreadas
Interface ScheduleModel         =  ScheduleModelExtender  // Define los metodos de mantenimiento de los eventos
Interface ScheduleEvent         =  ScheduleEventExtender  // Define los metodos informativos del evento
Clase     DefaultScheduleModel  =  ScheduleEventExtenderImplementent // implementa el constructor con la definicion de los metodos ScheduleModelExtender y
							      algunos metodos de ScheduleEventExtender 

*/

   
    
     @PersistenceContext
     EntityManager em;
    
     @Resource
     UserTransaction utx;
     
    private ScheduleModel lazyEventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
 
    @Inject
    private CompScheduleFacade ejbSchedule;
    
    private CompSchedule evento;
    private List<CompSchedule> listadeevento = new  ArrayList<CompSchedule>();
            
 
    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
     
         getListadeevento();
         
         for(int i = 0; i < getListadeevento().size(); i++){
           
            //por cada entidad consultada procede a guardarla en evento
            evento =  getListadeevento().get(i);
              
              DefaultScheduleEvent itemEvent = new DefaultScheduleEvent();
              itemEvent.setId(String.valueOf(evento.getIdSchedule()));
              itemEvent.setTitle(evento.getAsunto());
              itemEvent.setStartDate(evento.getFechaInicio());
              itemEvent.setEndDate(evento.getFechaInicio());
             //se procede a llenar la descripcion
              itemEvent.setDescription(evento.getDescripcion());
            
              eventModel.addEvent(itemEvent);
        
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
     
    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }
 
    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
 
        return calendar;
    }
     
    
    
    
    private Date previousDay8Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 8);
         
        return t.getTime();
    }
     
    private Date previousDay11Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 11);
         
        return t.getTime();
    }
     
    private Date today1Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 1);
         
        return t.getTime();
    }
     
    private Date theDayAfter3Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);     
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 3);
         
        return t.getTime();
    }
 
    private Date today6Pm() {
        Calendar t = (Calendar) today().clone(); 
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 6);
         
        return t.getTime();
    }
     
    private Date nextDay9Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 9);
         
        return t.getTime();
    }
     
    private Date nextDay11Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 11);
         
        return t.getTime();
    }
     
    private Date fourDaysLater3pm() {
        Calendar t = (Calendar) today().clone(); 
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
        t.set(Calendar.HOUR, 3);
         
        return t.getTime();
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
        
        
        
        
        
        event = new DefaultScheduleEvent();
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
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
