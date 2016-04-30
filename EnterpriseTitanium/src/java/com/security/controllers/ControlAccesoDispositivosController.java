package com.security.controllers;

import com.security.controllers.util.MobilePageController;
import com.security.models.ControlAccesoDispositivos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "controlAccesoDispositivosController")
@ViewScoped
public class ControlAccesoDispositivosController extends AbstractController<ControlAccesoDispositivos> {

    @Inject
    private CuentaUsuarioController segCuentaCuentaIdController;
    @Inject
    private TablaLogicaController deviceTypeController;
    @Inject
    private MobilePageController mobilePageController;

    public ControlAccesoDispositivosController() {
        // Inform the Abstract parent controller of the concrete ControlAccesoDispositivos Entity
        super(ControlAccesoDispositivos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        segCuentaCuentaIdController.setSelected(null);
        deviceTypeController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the CuentaUsuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSegCuentaCuentaId(ActionEvent event) {
        if (this.getSelected() != null && segCuentaCuentaIdController.getSelected() == null) {
            segCuentaCuentaIdController.setSelected(this.getSelected().getSegCuentaCuentaId());
        }
    }

    /**
     * Sets the "selected" attribute of the TablaLogica controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDeviceType(ActionEvent event) {
        if (this.getSelected() != null && deviceTypeController.getSelected() == null) {
            deviceTypeController.setSelected(this.getSelected().getDeviceType());
        }
    }
}
