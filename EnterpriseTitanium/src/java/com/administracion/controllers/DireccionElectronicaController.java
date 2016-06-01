package com.administracion.controllers;

import com.administracion.controllers.util.MobilePageControllerAdm;
import com.administracion.models.DireccionElectronica;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
   
@Named(value = "direccionElectronicaController")
@ViewScoped
public class DireccionElectronicaController extends AbstractController<DireccionElectronica> {

    @Inject
    private EntidadAdmController idEntidadController;
    @Inject
    private TablaLogicaAdmController lugarController;
    @Inject
    private TablaLogicaAdmController tipoCorreoController;
    @Inject
    private TablaLogicaAdmController tipoUrlController;
    @Inject
    private MobilePageControllerAdm mobilePageController;

    public DireccionElectronicaController() {
        // Inform the Abstract parent controller of the concrete DireccionElectronica Entity
        super(DireccionElectronica.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEntidadController.setSelected(null);
        lugarController.setSelected(null);
        tipoCorreoController.setSelected(null);
        tipoUrlController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the EntidadAdm controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEntidad(ActionEvent event) {
        if (this.getSelected() != null && idEntidadController.getSelected() == null) {
            idEntidadController.setSelected(this.getSelected().getIdEntidad());
        }
    }

    /**
     * Sets the "selected" attribute of the TablaLogicaAdm controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLugar(ActionEvent event) {
        if (this.getSelected() != null && lugarController.getSelected() == null) {
            lugarController.setSelected(this.getSelected().getLugar());
        }
    }

    /**
     * Sets the "selected" attribute of the TablaLogicaAdm controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoCorreo(ActionEvent event) {
        if (this.getSelected() != null && tipoCorreoController.getSelected() == null) {
            tipoCorreoController.setSelected(this.getSelected().getTipoCorreo());
        }
    }

    /**
     * Sets the "selected" attribute of the TablaLogicaAdm controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoUrl(ActionEvent event) {
        if (this.getSelected() != null && tipoUrlController.getSelected() == null) {
            tipoUrlController.setSelected(this.getSelected().getTipoUrl());
        }
    }
}
