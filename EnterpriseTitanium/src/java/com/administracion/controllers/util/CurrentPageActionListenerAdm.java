/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.controllers.util;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

@Named(value = "currentPageActionListenerAdm")
@RequestScoped
public class CurrentPageActionListenerAdm implements Serializable, ActionListener {

    @Inject
    private MobilePageControllerAdm mobilePageController;

    /**
     * Creates a new instance of CurrentPageActionListener
     */
    public CurrentPageActionListenerAdm() {
    }

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        this.mobilePageController.currentPageListener(event);
    }

}
