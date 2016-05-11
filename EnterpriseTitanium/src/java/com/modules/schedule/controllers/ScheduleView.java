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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent; 
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
/**
 *
 * @author Julio Cortorreal
 */
@ManagedBean
@ViewScoped
public class ScheduleView   implements Serializable {
    private ScheduleModel eventModel, eventModel2;
     /*
Primefaces                         Recreadas
Interface ScheduleModel         =  ScheduleModelExtender  // Define los metodos de mantenimiento de los eventos
Interface ScheduleEvent         =  ScheduleEventExtender  // Define los metodos informativos del evento
Clase     DefaultScheduleModel  =  ScheduleEventExtenderImplementent // implementa el constructor con la definicion de los metodos ScheduleModelExtender y
							      algunos metodos de ScheduleEventExtender 

*/
      private int id ;
   
    
     @PersistenceContext
     EntityManager em;
    
     @Resource
     UserTransaction utx;
     
    private ScheduleModel lazyEventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
     private ScheduleEvent event2 = new DefaultScheduleEvent();
    @Inject
    private CompScheduleFacade ejbSchedule;
    
    private CompSchedule evento, eventoSelect ;
    private List<CompSchedule> listadeevento = new  ArrayList<CompSchedule>();
            
 
    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
        eventModel2 = new DefaultScheduleModel();
         getListadeevento();
         
         for(int i = 0; i < getListadeevento().size(); i++){
           
            //por cada entidad consultada procede a guardarla en evento
            evento =  getListadeevento().get(i);
              
              DefaultScheduleEvent itemEvent = new DefaultScheduleEvent();
             
              
              itemEvent.setId(String.valueOf(evento.getIdSchedule()));
              itemEvent.setTitle(evento.getAsunto());
              itemEvent.setStartDate(evento.getFechaInicio());
              itemEvent.setEndDate(evento.getFechaFin());
              itemEvent.setStyleClass(evento.getCategoria());
             //se procede a llenar la descripcion
              itemEvent.setDescription(evento.getDescripcion());
              
              eventModel2.addEvent(itemEvent);
              eventModel.addEvent(itemEvent);
        
        }
         
    }
     
   
     
    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
         
        return calendar.getTime();
    }
     
    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public ScheduleEvent getEvent2() {
        return event2;
    }

    public void setEvent2(ScheduleEvent event2) {
        this.event2 = event2;
    }

    public ScheduleModel getEventModel2() {
        return eventModel2;
    }
    
 
     
    public ScheduleModel getLazyEventModel() {
          
        return lazyEventModel;
    }
 
    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
 
        return calendar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     

     
    public ScheduleEvent getEvent() {
       
        return event;
    }
 
    public void setEvent(ScheduleEvent event) {
        
       
        this.event = event;
    }

    
     private Date diaCompletoInicio() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 12);
        
         
        return t.getTime();
    }
    
    private Date diaCompletoFin() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 12);
        return t.getTime();
    }

    public CompSchedule getEventoSelect() {
        return eventoSelect;
    }

    public void setEventoSelect(CompSchedule eventoSelect) {
        this.eventoSelect = eventoSelect;
    }
    
    
    
    public void addEvent(ActionEvent actionEvent) throws javax.transaction.RollbackException  {
       
        if(event.getId() == null && eventoSelect == null) {
            
            eventoSelect= new CompSchedule (null, event.getTitle(), event.getStartDate(), event.getEndDate(), event.getDescription()); 
        try {
         
           
            utx.begin();
            em.persist(eventoSelect);
            utx.commit();
                       
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, ":) Se añadio el evento"+ event.getTitle() +"exitosamente", "");
                 addMessage(message);
            
            
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException e) {
     
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, ":) ERROR al actualizar el evento"+ event.getTitle() +" ",  e.getMessage());
                 addMessage(message);
            
        } 
       
         
        
        }  else
              
      try {
         
         evento.setIdSchedule(evento.getIdSchedule());
         evento.setAsunto(event.getTitle());
         evento.setFechaInicio( event.getStartDate());
         evento.setFechaFin( event.getEndDate());
                 evento.setDescripcion(event.getDescription());
        
          try {
            utx.begin();
            em.merge(evento);
           utx.commit();
           
           FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, ":) Se actualizo el evento"+ event.getTitle() +"exitosamente", "");
           addMessage(message);
          } catch (Exception e) {
          FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, ":) ERROR al actualizar el evento"+ event.getTitle() +" ", e.getMessage());
                 addMessage(message);
         
          }
        
             
         
       
          
        } catch (Exception e) {
      JsfUtil.addErrorMessage("Error al registrar el evento" + event.getTitle()+  " :" + e.getMessage());
        }finally{
        
        em.close();
        
        }
         
        event = new DefaultScheduleEvent();
    }
    
    
    
   public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
        event2 = (ScheduleEvent) selectEvent.getObject();
   
       buscarEvento();
       
     
       
        
    }
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
         event2 = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    } 
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
          
    }
    
 
       public CompSchedule buscarEvento (){
    eventoSelect = new CompSchedule();
        // si no ese ha seleccionado ningun evento
        if (event.getId().isEmpty() || event.getId() == null) {
             //enviamelo null
            eventoSelect = null;
        
        }else{       //en caso de que exista procede a buscarlo por parametros
                    if(event2.getDescription().isEmpty() || event2.getDescription() == null){
                      eventoSelect = (CompSchedule) em.createQuery("SELECT s FROM CompSchedule s WHERE s.asunto =:asunto  ")
                    .setParameter("asunto", event2.getTitle() )
                    .getSingleResult();

                    }else{
                    eventoSelect = (CompSchedule) em.createQuery("SELECT s FROM CompSchedule s WHERE s.asunto =:asunto and s.descripcion = :descripcion")
                    .setParameter("asunto", event2.getTitle() )
                    .setParameter("descripcion", event2.getDescription())
                    .getSingleResult();

                    }
    
        }
         return eventoSelect;
    
    }// fin de buscar el evento
    
     
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
    
     private java.sql.Date formatoCalendar( Date Fecha){
     java.sql.Date fecha_valida = null;
         
     Calendar FechaFormato = Calendar.getInstance();
     FechaFormato.set(Fecha.getYear() + 1900, Fecha.getMonth(), Fecha.getDate());
     
     fecha_valida = new java.sql.Date(FechaFormato.getTime().getTime());
     return  fecha_valida;
     }
    
    
}
