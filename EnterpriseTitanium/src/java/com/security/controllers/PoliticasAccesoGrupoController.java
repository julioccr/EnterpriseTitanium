package com.security.controllers;

import com.security.controllers.util.MobilePageController;
import com.security.models.PoliticasAccesoGrupo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "politicasAccesoGrupoController")
@ViewScoped
public class PoliticasAccesoGrupoController extends AbstractController<PoliticasAccesoGrupo> {

    @Inject
    private DirectivaGrupoController idGrupoController;
    @Inject
    private TransaccionController idTransaccionController;
    @Inject
    private MobilePageController mobilePageController;

    public PoliticasAccesoGrupoController() {
        // Inform the Abstract parent controller of the concrete PoliticasAccesoGrupo Entity
        super(PoliticasAccesoGrupo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idGrupoController.setSelected(null);
        idTransaccionController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the DirectivaGrupo controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdGrupo(ActionEvent event) {
        if (this.getSelected() != null && idGrupoController.getSelected() == null) {
            idGrupoController.setSelected(this.getSelected().getIdGrupo());
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
