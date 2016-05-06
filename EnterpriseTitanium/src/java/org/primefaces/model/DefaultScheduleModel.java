/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Julio Cortorreal
 */
public class DefaultScheduleModel implements ScheduleModel , Serializable {

     private List<ScheduleEvent> events;
    private boolean eventLimit = false;

    public DefaultScheduleModel() {
    }

    public DefaultScheduleModel(List<ScheduleEvent> events) {
        this.events = events;
    }
      
    @Override
    public void addEvent(ScheduleEvent event) {
       event.setId(UUID.randomUUID().toString());
			events.add(event);
    }

    @Override
    public boolean deleteEvent(ScheduleEvent event) {
        return events.remove(event);
    }

    @Override
    public List<ScheduleEvent> getEvents() {
        return  events;
    }

    @Override
    public ScheduleEvent getEvent(String Id) {
        
        for(ScheduleEvent event : events) {
			if(event.getId().equals(Id))
				return event;
		}
		
		return null;
        
        
    }

    @Override
    public void updateEvent(ScheduleEvent event) {
     
        int index = -1;
 		
 		for(int i = 0 ; i < events.size(); i++) {
 			if(events.get(i).getId().equals(event.getId())) {
 				index = i;
 				
 				break;
 			}
 		}
 		
 		if(index >= 0) {
 			events.set(index, event);
 		}
        
    }

    @Override
    public int getEventCount() {
        return events.size();
    }

    @Override
    public void clear() {
         events = new ArrayList<ScheduleEvent>();
    }

    @Override
    public boolean isEventLimit() {
       return  eventLimit;
    }
    
}
