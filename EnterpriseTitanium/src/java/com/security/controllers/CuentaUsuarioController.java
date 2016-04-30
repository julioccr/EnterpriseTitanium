package com.security.controllers;

import com.security.controllers.util.MobilePageController;
import com.security.models.CuentaUsuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cuentaUsuarioController")
@ViewScoped
public class CuentaUsuarioController extends AbstractController<CuentaUsuario> {

    @Inject
    private EntidadController idEntidadController;
    @Inject
    private MobilePageController mobilePageController;

    public CuentaUsuarioController() {
        // Inform the Abstract parent controller of the concrete CuentaUsuario Entity
        super(CuentaUsuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEntidadController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of ControlAccesoDispositivos
     * entities that are retrieved from CuentaUsuario?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ControlAccesoDispositivos page
     */
    public String navigateControlAccesoDispositivosCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ControlAccesoDispositivos_items", this.getSelected().getControlAccesoDispositivosCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/securitymaneger/views/controlAccesoDispositivos/index";
    }

    /**
     * Sets the "items" attribute with a collection of SegAccesoModulo entities
     * that are retrieved from CuentaUsuario?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for SegAccesoModulo page
     */
    public String navigateSegAccesoModuloCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SegAccesoModulo_items", this.getSelected().getSegAccesoModuloCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/securitymaneger/views/segAccesoModulo/index";
    }

    /**
     * Sets the "selected" attribute of the Entidad controller in order to
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
     * Sets the "items" attribute with a collection of DirectivaGrupo entities
     * that are retrieved from CuentaUsuario?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DirectivaGrupo page
     */
    public String navigateDirectivaGrupoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DirectivaGrupo_items", this.getSelected().getDirectivaGrupoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/securitymaneger/views/directivaGrupo/index";
    }

    /**
     * Sets the "items" attribute with a collection of PoliticasAccesoUsuario
     * entities that are retrieved from CuentaUsuario?cap_first and returns the
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

    /**
     * Sets the "items" attribute with a collection of ControlAccesoAplicacion
     * entities that are retrieved from CuentaUsuario?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ControlAccesoAplicacion page
     */
    public String navigateControlAccesoAplicacionCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ControlAccesoAplicacion_items", this.getSelected().getControlAccesoAplicacionCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/securitymaneger/views/controlAccesoAplicacion/index";
    }

}
