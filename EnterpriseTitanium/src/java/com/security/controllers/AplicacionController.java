package com.security.controllers;

import com.security.controllers.util.MobilePageController;
import com.security.models.Aplicacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "aplicacionController")
@ViewScoped
public class AplicacionController extends AbstractController<Aplicacion> {

    @Inject
    private MobilePageController mobilePageController;

    public AplicacionController() {
        // Inform the Abstract parent controller of the concrete Aplicacion Entity
        super(Aplicacion.class);
    }

    /**
     * Sets the "items" attribute with a collection of Modulo entities that are
     * retrieved from Aplicacion?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Modulo page
     */
    public String navigateModuloCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Modulo_items", this.getSelected().getModuloCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/securitymaneger/views/modulo/index";
    }

    /**
     * Sets the "items" attribute with a collection of ControlAccesoAplicacion
     * entities that are retrieved from Aplicacion?cap_first and returns the
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
