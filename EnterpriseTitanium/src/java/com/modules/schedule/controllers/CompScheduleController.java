package com.modules.schedule.controllers;

import com.modules.schedule.controllers.util.MobilePageController;
import com.modules.schedule.models.CompSchedule;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "compScheduleController")
@ViewScoped
public class CompScheduleController extends AbstractController<CompSchedule> {

    @Inject
    private CuentaUsuarioCompController idCuentaController;
    @Inject
    private MobilePageController mobilePageController;

    public CompScheduleController() {
        // Inform the Abstract parent controller of the concrete CompSchedule Entity
        super(CompSchedule.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCuentaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the CuentaUsuarioComp controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCuenta(ActionEvent event) {
        if (this.getSelected() != null && idCuentaController.getSelected() == null) {
            idCuentaController.setSelected(this.getSelected().getIdCuenta());
        }
    }
}
