package com.security.controllers;

import com.security.controllers.util.MobilePageController;
import com.security.models.TablaLogica;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tablaLogicaController")
@ViewScoped
public class TablaLogicaController extends AbstractController<TablaLogica> {

    @Inject
    private MobilePageController mobilePageController;

    public TablaLogicaController() {
        // Inform the Abstract parent controller of the concrete TablaLogica Entity
        super(TablaLogica.class);
    }

    /**
     * Sets the "items" attribute with a collection of ControlAccesoDispositivos
     * entities that are retrieved from TablaLogica?cap_first and returns the
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
     * Sets the "items" attribute with a collection of Entidad entities that are
     * retrieved from TablaLogica?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Entidad page
     */
    public String navigateEntidadCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Entidad_items", this.getSelected().getEntidadCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/securitymaneger/views/entidad/index";
    }

    /**
     * Sets the "items" attribute with a collection of Entidad entities that are
     * retrieved from TablaLogica?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Entidad page
     */
    public String navigateEntidadCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Entidad_items", this.getSelected().getEntidadCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/securitymaneger/views/entidad/index";
    }

    /**
     * Sets the "items" attribute with a collection of Entidad entities that are
     * retrieved from TablaLogica?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Entidad page
     */
    public String navigateEntidadCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Entidad_items", this.getSelected().getEntidadCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/securitymaneger/views/entidad/index";
    }

    /**
     * Sets the "items" attribute with a collection of Entidad entities that are
     * retrieved from TablaLogica?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Entidad page
     */
    public String navigateEntidadCollection3() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Entidad_items", this.getSelected().getEntidadCollection3());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/securitymaneger/views/entidad/index";
    }

}
