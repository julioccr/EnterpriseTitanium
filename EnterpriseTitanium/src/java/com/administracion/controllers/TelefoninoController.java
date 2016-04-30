package com.administracion.controllers;

import com.administracion.controllers.util.MobilePageControllerAdm;
import com.administracion.models.Telefonino;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "telefoninoController")
@ViewScoped
public class TelefoninoController extends AbstractController<Telefonino> {

    @Inject
    private EntidadAdmController idEntidadController;
    @Inject
    private TablaLogicaAdmController lugarController;
    @Inject
    private MobilePageControllerAdm mobilePageController;

    public TelefoninoController() {
        // Inform the Abstract parent controller of the concrete Telefonino Entity
        super(Telefonino.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEntidadController.setSelected(null);
        lugarController.setSelected(null);
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
}
