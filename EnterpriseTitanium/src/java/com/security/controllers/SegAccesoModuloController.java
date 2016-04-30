package com.security.controllers;

import com.security.controllers.util.MobilePageController;
import com.security.models.SegAccesoModulo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "segAccesoModuloController")
@ViewScoped
public class SegAccesoModuloController extends AbstractController<SegAccesoModulo> {

    @Inject
    private ModuloController idAppModuloController;
    @Inject
    private CuentaUsuarioController idCuentaController;
    @Inject
    private MobilePageController mobilePageController;

    public SegAccesoModuloController() {
        // Inform the Abstract parent controller of the concrete SegAccesoModulo Entity
        super(SegAccesoModulo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idAppModuloController.setSelected(null);
        idCuentaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Modulo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdAppModulo(ActionEvent event) {
        if (this.getSelected() != null && idAppModuloController.getSelected() == null) {
            idAppModuloController.setSelected(this.getSelected().getIdAppModulo());
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
