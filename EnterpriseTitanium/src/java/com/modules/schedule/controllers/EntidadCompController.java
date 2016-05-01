package com.modules.schedule.controllers;

import com.modules.schedule.controllers.util.MobilePageController;
import com.modules.schedule.models.EntidadComp;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "entidadCompController")
@ViewScoped
public class EntidadCompController extends AbstractController<EntidadComp> {

    @Inject
    private CuentaUsuarioCompController cuentaUsuarioController;
    @Inject
    private TablaLogicaCompController ciudadController;
    @Inject
    private TablaLogicaCompController generoController;
    @Inject
    private TablaLogicaCompController nacionalidadController;
    @Inject
    private TablaLogicaCompController tipoidentificacionController;
    @Inject
    private MobilePageController mobilePageController;

    public EntidadCompController() {
        // Inform the Abstract parent controller of the concrete EntidadComp Entity
        super(EntidadComp.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        cuentaUsuarioController.setSelected(null);
        ciudadController.setSelected(null);
        generoController.setSelected(null);
        nacionalidadController.setSelected(null);
        tipoidentificacionController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the CuentaUsuarioComp controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCuentaUsuario(ActionEvent event) {
        if (this.getSelected() != null && cuentaUsuarioController.getSelected() == null) {
            cuentaUsuarioController.setSelected(this.getSelected().getCuentaUsuario());
        }
    }

    /**
     * Sets the "selected" attribute of the TablaLogicaComp controller in order
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
     * Sets the "selected" attribute of the TablaLogicaComp controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGenero(ActionEvent event) {
        if (this.getSelected() != null && generoController.getSelected() == null) {
            generoController.setSelected(this.getSelected().getGenero());
        }
    }

    /**
     * Sets the "selected" attribute of the TablaLogicaComp controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareNacionalidad(ActionEvent event) {
        if (this.getSelected() != null && nacionalidadController.getSelected() == null) {
            nacionalidadController.setSelected(this.getSelected().getNacionalidad());
        }
    }

    /**
     * Sets the "selected" attribute of the TablaLogicaComp controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoidentificacion(ActionEvent event) {
        if (this.getSelected() != null && tipoidentificacionController.getSelected() == null) {
            tipoidentificacionController.setSelected(this.getSelected().getTipoidentificacion());
        }
    }
}
