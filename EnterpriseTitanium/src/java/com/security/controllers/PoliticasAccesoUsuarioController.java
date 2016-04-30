package com.security.controllers;

import com.security.controllers.util.MobilePageController;
import com.security.models.PoliticasAccesoUsuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "politicasAccesoUsuarioController")
@ViewScoped
public class PoliticasAccesoUsuarioController extends AbstractController<PoliticasAccesoUsuario> {

    @Inject
    private CuentaUsuarioController idCuentaController;
    @Inject
    private TransaccionController idTransaccionController;
    @Inject
    private MobilePageController mobilePageController;

    public PoliticasAccesoUsuarioController() {
        // Inform the Abstract parent controller of the concrete PoliticasAccesoUsuario Entity
        super(PoliticasAccesoUsuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCuentaController.setSelected(null);
        idTransaccionController.setSelected(null);
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

    /**
     * Sets the "selected" attribute of the Transaccion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTransaccion(ActionEvent event) {
        if (this.getSelected() != null && idTransaccionController.getSelected() == null) {
            idTransaccionController.setSelected(this.getSelected().getIdTransaccion());
        }
    }
}
