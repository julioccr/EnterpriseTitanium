package com.security.controllers;

import com.security.controllers.util.MobilePageController;
import com.security.models.ControlAccesoAplicacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "controlAccesoAplicacionController")
@ViewScoped
public class ControlAccesoAplicacionController extends AbstractController<ControlAccesoAplicacion> {

    @Inject
    private AplicacionController idAppController;
    @Inject
    private CuentaUsuarioController idCuentaController;
    @Inject
    private MobilePageController mobilePageController;

    public ControlAccesoAplicacionController() {
        // Inform the Abstract parent controller of the concrete ControlAccesoAplicacion Entity
        super(ControlAccesoAplicacion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idAppController.setSelected(null);
        idCuentaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Aplicacion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdApp(ActionEvent event) {
        if (this.getSelected() != null && idAppController.getSelected() == null) {
            idAppController.setSelected(this.getSelected().getIdApp());
        }
    }

    /**
     * Sets the "selected" attribute of the CuentaUsuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCuenta(ActionEvent event) {
        if (this.getSelected() != null && idCuentaController.getSelected() == null) {
            idCuentaController.setSelected(this.getSelected().getIdCuenta());
        }
    }
}
