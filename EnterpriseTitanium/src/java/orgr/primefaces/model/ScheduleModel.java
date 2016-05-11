/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orgr.primefaces.model;

import java.util.List;


/**
 *
 * @author Julio Cortorreal
 */
public interface ScheduleModel {
    
     public void addEvent(ScheduleEvent se);

    public boolean deleteEvent(ScheduleEvent se);

    public List<ScheduleEvent> getEvents();

    public ScheduleEvent getEvent(String string);

    public void updateEvent(ScheduleEvent se);

    public int getEventCount();

    public void clear();

    public boolean isEventLimit();
}
