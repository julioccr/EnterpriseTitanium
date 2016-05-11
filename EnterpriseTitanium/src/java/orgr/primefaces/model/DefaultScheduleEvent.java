/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orgr.primefaces.model;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Julio Cortorreal
 */
public class DefaultScheduleEvent  implements ScheduleEvent,   Serializable {

    
        private String id;
        private String title;
        private Date startDate;
        private Date endDate;
        private boolean allDay;
        private String styleClass;
        private Object data;
        private boolean editable;
        private String description;
        private String Categoria;
        private String  Tipo ;
        private String  Prioridad ;
        private Date StartHourDate;
        private Date EndHourDate;
        private String Lunes;  
        private String Martes;  
        private String Miercoles;  
        private String Jueves;  
        private String Viernes;  
        private String Sabado;  
        private String Domingo;  

        // contructor vacio para crear instacias como objetos
    public DefaultScheduleEvent() {
    }
      // constructor para crear eventos simples
    public DefaultScheduleEvent(String title, Date startDate, Date endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

     
    // constructor para crear eventos simples + descripcion
    public DefaultScheduleEvent(String title, Date startDate, Date endDate, String description) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public DefaultScheduleEvent(String id, String title, Date startDate, Date endDate, boolean allDay, String description, String Categoria, String Tipo, String Prioridad, Date StartHourDate, Date EndHourDate, String Lunes, String Martes, String Miercoles, String Jueves, String Viernes, String Sabado, String Domingo) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.allDay = allDay;
        this.description = description;
        this.Categoria = Categoria;
        this.Tipo = Tipo;
        this.Prioridad = Prioridad;
        this.StartHourDate = StartHourDate;
        this.EndHourDate = EndHourDate;
        this.Lunes = Lunes;
        this.Martes = Martes;
        this.Miercoles = Miercoles;
        this.Jueves = Jueves;
        this.Viernes = Viernes;
        this.Sabado = Sabado;
        this.Domingo = Domingo;
    }

    public DefaultScheduleEvent(String title, boolean allDay) {
        this.title = title;
        this.allDay = allDay;
    }

    public DefaultScheduleEvent(String title, Date startDate, Date endDate, Object data) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.data = data;
    }
   
    
    

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    @Override
    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    /**
     *
     * @return
     */
    @Override
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    @Override
    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    @Override
    public String getPrioridad() {
        return Prioridad;
    }

    public void setPrioridad(String Prioridad) {
        this.Prioridad = Prioridad;
    }

    @Override
    public Date getStartHourDate() {
        return StartHourDate;
    }

    public void setStartHourDate(Date StartHourDate) {
        this.StartHourDate = StartHourDate;
    }

    @Override
    public Date getEndHourDate() {
        return EndHourDate;
    }

    public void setEndHourDate(Date EndHourDate) {
        this.EndHourDate = EndHourDate;
    }

    @Override
    public String getLunes() {
        return Lunes;
    }

    public void setLunes(String Lunes) {
        this.Lunes = Lunes;
    }

    @Override
    public String getMartes() {
        return Martes;
    }

    public void setMartes(String Martes) {
        this.Martes = Martes;
    }

    @Override
    public String getMiercoles() {
        return Miercoles;
    }

    public void setMiercoles(String Miercoles) {
        this.Miercoles = Miercoles;
    }

    @Override
    public String getJueves() {
        return Jueves;
    }

    public void setJueves(String Jueves) {
        this.Jueves = Jueves;
    }

    
    @Override
    public String getViernes() {
        return Viernes;
    }

    public void setViernes(String Viernes) {
        this.Viernes = Viernes;
    }

    @Override
    public String getSabado() {
        return Sabado;
    }

    public void setSabado(String Sabado) {
        this.Sabado = Sabado;
    }

    @Override
    public String getDomingo() {
        return Domingo;
    }

    public void setDomingo(String Domingo) {
        this.Domingo = Domingo;
    }

     
     
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DefaultScheduleEvent other = (DefaultScheduleEvent) obj;
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        if (this.startDate != other.startDate && (this.startDate == null || !this.startDate.equals(other.startDate))) {
            return false;
        }
        if (this.endDate != other.endDate && (this.endDate == null || !this.endDate.equals(other.endDate))) {
            return false;
        }
        return true;
    }
 
    
    
        @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 61 * hash + (this.startDate != null ? this.startDate.hashCode() : 0);
        hash = 61 * hash + (this.endDate != null ? this.endDate.hashCode() : 0);
        return hash;
    }
 
 
        @Override
    public String toString() {
        return "DefaultScheduleEvent{title=" + title + ",startDate=" + startDate + ",endDate=" + endDate + "}";
    }
     
      
     
     
     
}