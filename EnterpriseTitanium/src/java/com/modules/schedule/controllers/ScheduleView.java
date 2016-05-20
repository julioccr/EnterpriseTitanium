/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.schedule.controllers;

import com.global.general.GlobalMetods;
import com.global.general.VarSystem;
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
public class ScheduleView   extends GlobalMetods implements Serializable {
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
    private CompSchedule evento, eventoSelect, eventoDetalle ;
    private List<CompSchedule> listadeevento = new  ArrayList<CompSchedule>();
    
    //datos de evento
    private String tipoEvento;
    private String Categoria;
    private String prioridad;
 
    private GlobalMetods Global;
    private VarSystem    varSystem;
     /************************************************************************************************* 
     *PROCESO PARA CARGAR EL SCHEDULE O AGENDA DE EVENTOS EN EL SISTEMA                               *                                                                                                *                                                                                                * 
     *                                                                                                *
     ************************************************************************************************** 
     */ 
    @PostConstruct
    public void init() {
        //Se crearon dos event model uno para dar mantenimiento y otro solo para cargar contenido
        eventModel = new DefaultScheduleModel();
        eventModel2 = new DefaultScheduleModel();
        //ejecuta la consulta en la tabla de eventos  para cargar los eventos como objetos
        getListadeevento();
         //se genera una lista
         for(int i = 0; i < getListadeevento().size(); i++){
           
            //por cada entidad consultada procede a guardarla en el objeto evento
            evento =  getListadeevento().get(i);
              //Instanciamos un objeto de la calse DefaultScheduleEvent, es la que define los atributos de un evento
              DefaultScheduleEvent itemEvent = new DefaultScheduleEvent();
              
              //agregamos los atributos del evento a las propiedades de la isntancia de DefaultScheduleEvent itemEvent
              itemEvent.setId(String.valueOf(evento.getIdSchedule()));
              itemEvent.setTitle(evento.getAsunto());
              itemEvent.setStartDate(formatoCalendar(evento.getFechaInicio()));
              itemEvent.setEndDate(formatoCalendar(evento.getFechaFin()));
              itemEvent.setStyleClass(evento.getCategoria());
              itemEvent.setDescription(evento.getDescripcion());
             
              //eventModel2 es para gestionar los eventos
              eventModel2.addEvent(itemEvent);
              //añadimos todos los eventos hasta que finalice el for a la agenda.
              //eventModel es para mostrar contenido
              eventModel.addEvent(itemEvent);
        
        }
         
    }
     
   
     
    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
         
        return calendar.getTime();
    }
     
    /************************************************************************************************** 
     *PROCESO PARA MOSTRAR TODOS LOS EVENTOS EN LA AGENDA DEL SISTEMA                                 *                                                                                                *                                                                                                * 
     ************************************************************************************************** 
     * @return 
     */ 
    public ScheduleModel getEventModel() {
        return eventModel;
    } // fin del metodo

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
    
     /************************************************************************************************* 
     *PROCESO DE MANTENIMIENTO DE EVENTOS GESTIONADOS POR LOS USUARIOS DEL SISTEMA                    *                                                                                                *                                                                                                * 
     *El metodo procede a añadir evento si no existe en el sistema, si existe procede actualizarlo    *
     ************************************************************************************************** 
     * @param actionEvent
     * @throws javax.transaction.RollbackException
     */  
    
    public void addEvent(ActionEvent actionEvent) throws javax.transaction.RollbackException  {
      //VALIDACION DE LA EXISTENCIA DEL EVENTO
        if(event.getId() == null && eventoSelect == null) {
            // SI NO EXISTE
            /***************************************************************************************************
             * PROCEDEMOS A AñADIR EL EVENTO AL SISTEMA                                                        * 
             * *************************************************************************************************
             */
      
            eventoSelect= new CompSchedule (null, event.getTitle(), event.getStartDate(), event.getEndDate(), event.getDescription(),eventoDetalle.getCategoria(), eventoSelect.getUbicacion(),eventoSelect.getPrioridad(), Global.fecha_system(), null ); 
         
        try {
         
           
            utx.begin();
            em.persist(eventoSelect);
            utx.commit();
                       
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, ":D Se añadio el evento \""+ event.getTitle() +"\" exitosamente", "");
                 addMessage(message);
            
            
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException e) {
     
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, ":( ERROR al actualizar el evento"+ event.getTitle() +" ",  e.getMessage());
                 addMessage(message);
            
        } 
       
         
        
        }  else
              // SI NO EXISTE
            
      try {
            /***************************************************************************************************
             * PROCEDEMOS A ACTUALIZAR EL EVENTO AL SISTEMA                                                    * 
             * *************************************************************************************************
             */
         if (eventoSelect.getFechaRegistro() == null) {
             eventoSelect.setFechaRegistro(fecha_system());  
          }else{
          eventoSelect.setFechaRegistro(eventoSelect.getFechaRegistro());
          }
        eventoSelect.setIdSchedule(eventoSelect.getIdSchedule());
        eventoSelect.setAsunto(event.getTitle());
        eventoSelect.setUbicacion(eventoSelect.getUbicacion());
        eventoSelect.setFechaInicio( event.getStartDate());
        eventoSelect.setFechaFin( event.getEndDate());
        eventoSelect.setDescripcion(event.getDescription());
        eventoSelect.setCategoria(eventoSelect.getCategoria());
        eventoSelect.setPrioridad(eventoSelect.getPrioridad());
               
        eventoDetalle.setFechaActualizacion(fecha_system());
          try {
            utx.begin();
            em.merge(eventoSelect);
           utx.commit();
           // MUESTRA NOTIFICACION EN PALANTALLA EXITOSO
           FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, ":D Se actualizo el evento \""+ event.getTitle() +"\" exitosamente", "");
           addMessage(message);
           
          } catch (NotSupportedException | SystemException | javax.transaction.RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException e) {
              //SI EXISTE ALGUNA EXCEPCION O ERROR MUESTRA EL TIPO DE ERROR
          FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, ":) ERROR al actualizar el evento "+ event.getTitle() +" ", e.getMessage());
                 addMessage(message);
         
          }
        
              
         
       
          
        } catch (Exception e) {
      JsfUtil.addErrorMessage("Error al registrar el evento" + event.getTitle()+  " :" + e.getMessage());
        }
        event = new DefaultScheduleEvent();
    }
    
   public void eliminarEvento()  throws javax.transaction.RollbackException {
       buscarEvento(event.getTitle(), event.getDescription());
       try {
            utx.begin();
            em.remove(eventoSelect);
           utx.commit(); 
           
            // MUESTRA NOTIFICACION EN PALANTALLA EXITOSO
           FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, ":D Se elimino el evento \""+ event.getTitle() +"\" exitosamente", "");
           addMessage(message);
       } catch (Exception e) {
      
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, ":) ERROR al actualizar el evento "+ event.getTitle() +" ", e.getMessage());
                 addMessage(message);
       }
   
     
   } 
    
   public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
        event2 = (ScheduleEvent) selectEvent.getObject();
   
         buscarEvento();
         eventoDetalle  = eventoSelect;
       
      
       
        
    }
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
         event2 = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    } 
     
    /**************************************************************************************************
     *PROCESO PARA ACTUALIZAR EVENTO, DESPUES DE MOVERLO EN LA AGENDA                                 *                                                                                                *                                                                                                * 
     *Realiza cambio de fecha de inicio y fin del evento                                              * 
     ************************************************************************************************** 
     * @param eventMove
     */
    
    public void onEventMove(ScheduleEntryMoveEvent eventMove) {
          
           if(eventMove.getScheduleEvent().getId() != null){
               //Buscamos el evento seleccionado en la base de datos
               buscarEvento(eventMove.getScheduleEvent().getTitle(),eventMove.getScheduleEvent().getDescription());
                
               //si existe
               if (eventoSelect != null) {
                 
                  try {
                /**
                 * PROCEDEMOS A ACTUCALIZAR DEL EVENTO, CON LA FECHA  DE INICIO Y FIN
                 * 
                 */
                        if (eventoSelect.getFechaRegistro() == null) {
                            DateNative =  fecha_system()  ;
                            
                        }else{
                        DateNative =  eventoSelect.getFechaRegistro();
                           }
                      
                         CompSchedule  eventoMover = 
                             new CompSchedule(eventoSelect.getIdSchedule(),
                                         eventMove.getScheduleEvent().getTitle(),
                                         formatoCalendar(eventMove.getScheduleEvent().getStartDate())       ,
                                         formatoCalendar(eventMove.getScheduleEvent().getEndDate()), 
                                         eventMove.getScheduleEvent().getDescription(),
                                         eventoSelect.getCategoria(),
                                         eventoSelect.getUbicacion(),
                                         eventoSelect.getPrioridad(),
                                         DateNative,
                                         new Date());
                         
                         
         
                       try {
                        //em.getTransaction().begin();
                         utx.begin();
                         em.merge(eventoMover);
                         utx.commit();
                        // em.getTransaction().commit();

                            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Se movio el evento \"" + eventMove.getScheduleEvent().getTitle() + "\" desde "
                                 + eventMove.getScheduleEvent().getStartDate() + " hasta " + eventMove.getScheduleEvent().getEndDate(), "");
                            addMessage(message);
                            
                            FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO,"Fecha Registro : \"" + new Date() + "\" desde "
                                 + eventMove.getScheduleEvent().getStartDate() + " hasta " + eventMove.getScheduleEvent().getEndDate(), "");
                            addMessage(message1);


                        }//fin del try
                       catch (NotSupportedException | SystemException | javax.transaction.RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException e) {
                            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, ":) ERROR al mover el evento "+ eventMove.getScheduleEvent().getTitle() +" ", e.getMessage());
                                   addMessage(message);

                            }        
        } catch (Exception e) {
              FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error al registrar el evento" + eventMove.getScheduleEvent().getTitle()+  " :" + e.getMessage(), "");
                   addMessage(message);
        }finally{
                    // varSystem.DateNative = null;
                  }
               }
      
           }
        
        
    } // fin del metodo mover
    
      /**************************************************************************************************
     *PROCESO PARA REAJUSTAR O MODIFICAR LA FECHA DE LOS EVENTOS DE LA AGENDA                         *                                                                                                *                                                                                                * 
     *Realiza cambio de fecha de inicio y fin del evento                                              * 
     ************************************************************************************************** 
     * @param event
     */
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
      
           
           if(event.getScheduleEvent().getId() != null){
               //Buscamos el evento seleccionado en la base de datos
               buscarEvento(event.getScheduleEvent().getTitle(),event.getScheduleEvent().getDescription());
                
               //si existe
               if (eventoSelect != null) {
                 
                  try {
                /**
                 * PROCEDEMOS A ACTUCALIZAR DEL EVENTO, CON LA FECHA  DE INICIO Y FIN
                 * 
                 */
                        if (eventoSelect.getFechaRegistro() == null) {
                            DateNative =  fecha_system()  ;
                            
                        }else{
                        DateNative =  eventoSelect.getFechaRegistro();
                           }
                      
                         CompSchedule  eventoMover = 
                             new CompSchedule(eventoSelect.getIdSchedule(),
                                         event.getScheduleEvent().getTitle(),
                                         formatoCalendar(event.getScheduleEvent().getStartDate())       ,
                                         formatoCalendar(event.getScheduleEvent().getEndDate()), 
                                         event.getScheduleEvent().getDescription(),
                                         eventoSelect.getCategoria(),
                                         eventoSelect.getUbicacion(),
                                         eventoSelect.getPrioridad(),
                                         DateNative,
                                         new Date());
                         
                         
         
                       try {
                        //em.getTransaction().begin();
                         utx.begin();
                         em.merge(eventoMover);
                         utx.commit();
                        // em.getTransaction().commit();

                            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Se movio el evento \"" + event.getScheduleEvent().getTitle() + "\" desde "
                                 + event.getScheduleEvent().getStartDate() + " hasta " + event.getScheduleEvent().getEndDate(), "");
                            addMessage(message);
                            
                             

                        }//fin del try
                       catch (NotSupportedException | SystemException | javax.transaction.RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException e) {
                            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, ":) ERROR al mover el evento "+ event.getScheduleEvent().getTitle() +" ", e.getMessage());
                                   addMessage(message);

                            }        
        } catch (Exception e) {
              FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error al registrar el evento" + event.getScheduleEvent().getTitle()+  " :" + e.getMessage(), "");
                   addMessage(message);
        }finally{
                    // varSystem.DateNative = null;
                  }
               }
      
           }
        
          
    }
    
      /************************************************************************************************* 
     *PROCESO PARA BUSCAR EVENTO SELECCIONADO POR EL USUARIO                                          *                                                                                                *                                                                                                * 
     *Busca el evento parametrizado por asusto y descripcion version 1 fecha 13-05-2016               *
     ************************************************************************************************** 
     * @return 
     */ 
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
    
        public CompSchedule buscarEvento (String AsuntoP, String DescripcionP){
        eventoSelect = new CompSchedule();
    
          
               if(DescripcionP.isEmpty()){
                      eventoSelect = (CompSchedule) em.createQuery("SELECT s FROM CompSchedule s WHERE s.asunto =:asunto  ")
                    .setParameter("asunto", AsuntoP )
                    .getSingleResult();
                            
                    }else{
                    eventoSelect = (CompSchedule) em.createQuery("SELECT s FROM CompSchedule s WHERE s.asunto =:asunto and s.descripcion = :descripcion")
                    .setParameter("asunto", AsuntoP )
                    .setParameter("descripcion", DescripcionP)
                    .getSingleResult();
                            
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

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public CompSchedule getEventoDetalle() {
        return eventoDetalle;
    }

    public void setEventoDetalle(CompSchedule eventoDetalle) {
//        this.eventoDetalle = eventoDetalle;
    }
    
     
    
}