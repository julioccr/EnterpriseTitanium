package com.modules.schedule.controllers;

import com.modules.schedule.controllers.util.MobilePageController;
import com.modules.schedule.models.CuentaUsuarioComp;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cuentaUsuarioCompController")
@ViewScoped
public class CuentaUsuarioCompController extends AbstractController<CuentaUsuarioComp> {

    @Inject
    private EntidadCompController idEntidadController;
    @Inject
    private MobilePageController mobilePageController;

    public CuentaUsuarioCompController() {
        // Inform the Abstract parent controller of the concrete CuentaUsuarioComp Entity
        super(CuentaUsuarioComp.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEntidadController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the EntidadComp controller in order to
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
     * Sets the "items" attribute with a collection of CompSchedule entities
     * that are retrieved from CuentaUsuarioComp?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CompSchedule page
     */
    public String navigateCompScheduleCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CompSchedule_items", this.getSelected().getCompScheduleCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/modules/schedule_events/views/compSchedule/index";
    }

}
