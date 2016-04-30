package com.security.controllers;

import com.security.controllers.util.MobilePageController;
import com.security.models.DirectivaGrupo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "directivaGrupoController")
@ViewScoped
public class DirectivaGrupoController extends AbstractController<DirectivaGrupo> {

    @Inject
    private CuentaUsuarioController idCuentaController;
    @Inject
    private MobilePageController mobilePageController;

    public DirectivaGrupoController() {
        // Inform the Abstract parent controller of the concrete DirectivaGrupo Entity
        super(DirectivaGrupo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCuentaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of PoliticasAccesoGrupo
     * entities that are retrieved from DirectivaGrupo?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PoliticasAccesoGrupo page
     */
    public String navigatePoliticasAccesoGrupoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PoliticasAccesoGrupo_items", this.getSelected().getPoliticasAccesoGrupoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/securitymaneger/views/politicasAccesoGrupo/index";
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
