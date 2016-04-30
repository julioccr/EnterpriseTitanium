package com.security.controllers;

import com.security.controllers.util.MobilePageController;
import com.security.models.Transaccion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "transaccionController")
@ViewScoped
public class TransaccionController extends AbstractController<Transaccion> {

    @Inject
    private ModuloController appModuloCodModuloController;
    @Inject
    private MobilePageController mobilePageController;

    public TransaccionController() {
        // Inform the Abstract parent controller of the concrete Transaccion Entity
        super(Transaccion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        appModuloCodModuloController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Modulo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAppModuloCodModulo(ActionEvent event) {
        if (this.getSelected() != null && appModuloCodModuloController.getSelected() == null) {
            appModuloCodModuloController.setSelected(this.getSelected().getAppModuloCodModulo());
        }
    }

    /**
     * Sets the "items" attribute with a collection of PoliticasAccesoGrupo
     * entities that are retrieved from Transaccion?cap_first and returns the
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
     * Sets the "items" attribute with a collection of PoliticasAccesoUsuario
     * entities that are retrieved from Transaccion?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PoliticasAccesoUsuario page
     */
    public String navigatePoliticasAccesoUsuarioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PoliticasAccesoUsuario_items", this.getSelected().getPoliticasAccesoUsuarioCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/securitymaneger/views/politicasAccesoUsuario/index";
    }

}
