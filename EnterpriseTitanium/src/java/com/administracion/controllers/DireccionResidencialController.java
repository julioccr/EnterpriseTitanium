package com.administracion.controllers;

import com.administracion.controllers.util.MobilePageControllerAdm;
import com.administracion.models.DireccionResidencial;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "direccionResidencialController")
@ViewScoped
public class DireccionResidencialController extends AbstractController<DireccionResidencial> {

    @Inject
    private TablaLogicaAdmController ciudadController;
    @Inject
    private EntidadAdmController idEntidadController;
    @Inject
    private TablaLogicaAdmController lugarController;
    @Inject
    private TablaLogicaAdmController paisController;
    @Inject
    private TablaLogicaAdmController sectorController;
    @Inject
    private TablaLogicaAdmController urbanizacionController;
    @Inject
    private MobilePageControllerAdm mobilePageController;

    public DireccionResidencialController() {
        // Inform the Abstract parent controller of the concrete DireccionResidencial Entity
        super(DireccionResidencial.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        ciudadController.setSelected(null);
        idEntidadController.setSelected(null);
        lugarController.setSelected(null);
        paisController.setSelected(null);
        sectorController.setSelected(null);
        urbanizacionController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TablaLogicaAdm controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCiudad(ActionEvent event) {
        if (this.getSelected() != null && ciudadController.getSelected() == null) {
            ciudadController.setSelected(this.getSelected().getCiudad());
        }
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
    public void preparePais(ActionEvent event) {
        if (this.getSelected() != null && paisController.getSelected() == null) {
            paisController.setSelected(this.getSelected().getPais());
        }
    }

    /**
     * Sets the "selected" attribute of the TablaLogicaAdm controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSector(ActionEvent event) {
        if (this.getSelected() != null && sectorController.getSelected() == null) {
            sectorController.setSelected(this.getSelected().getSector());
        }
    }

    /**
     * Sets the "selected" attribute of the TablaLogicaAdm controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUrbanizacion(ActionEvent event) {
        if (this.getSelected() != null && urbanizacionController.getSelected() == null) {
            urbanizacionController.setSelected(this.getSelected().getUrbanizacion());
        }
    }
}
