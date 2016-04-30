package com.administracion.controllers;

import com.administracion.controllers.util.MobilePageControllerAdm;
import com.administracion.models.TablaLogicaAdm;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tablaLogicaAdmController")
@ViewScoped
public class TablaLogicaAdmController extends AbstractController<TablaLogicaAdm> {

    @Inject
    private MobilePageControllerAdm mobilePageController;

    public TablaLogicaAdmController() {
        // Inform the Abstract parent controller of the concrete TablaLogicaAdm Entity
        super(TablaLogicaAdm.class);
    }

    /**
     * Sets the "items" attribute with a collection of Telefonino entities that
 are retrieved from TablaLogicaAdm?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Telefonino page
     */
    public String navigateTelefoninoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Telefonino_items", this.getSelected().getTelefoninoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/administration/views/telefonino/index";
    }

    /**
     * Sets the "items" attribute with a collection of DireccionElectronica
     * entities that are retrieved from TablaLogicaAdm?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DireccionElectronica page
     */
    public String navigateDireccionElectronicaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DireccionElectronica_items", this.getSelected().getDireccionElectronicaCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/administration/views/direccionElectronica/index";
    }

    /**
     * Sets the "items" attribute with a collection of DireccionElectronica
     * entities that are retrieved from TablaLogicaAdm?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DireccionElectronica page
     */
    public String navigateDireccionElectronicaCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DireccionElectronica_items", this.getSelected().getDireccionElectronicaCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/administration/views/direccionElectronica/index";
    }

    /**
     * Sets the "items" attribute with a collection of DireccionElectronica
     * entities that are retrieved from TablaLogicaAdm?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DireccionElectronica page
     */
    public String navigateDireccionElectronicaCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DireccionElectronica_items", this.getSelected().getDireccionElectronicaCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/administration/views/direccionElectronica/index";
    }

    /**
     * Sets the "items" attribute with a collection of DireccionResidencial
     * entities that are retrieved from TablaLogicaAdm?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DireccionResidencial page
     */
    public String navigateDireccionResidencialCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DireccionResidencial_items", this.getSelected().getDireccionResidencialCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/administration/views/direccionResidencial/index";
    }

    /**
     * Sets the "items" attribute with a collection of DireccionResidencial
     * entities that are retrieved from TablaLogicaAdm?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DireccionResidencial page
     */
    public String navigateDireccionResidencialCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DireccionResidencial_items", this.getSelected().getDireccionResidencialCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/administration/views/direccionResidencial/index";
    }

    /**
     * Sets the "items" attribute with a collection of DireccionResidencial
     * entities that are retrieved from TablaLogicaAdm?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DireccionResidencial page
     */
    public String navigateDireccionResidencialCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DireccionResidencial_items", this.getSelected().getDireccionResidencialCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/administration/views/direccionResidencial/index";
    }

    /**
     * Sets the "items" attribute with a collection of DireccionResidencial
     * entities that are retrieved from TablaLogicaAdm?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DireccionResidencial page
     */
    public String navigateDireccionResidencialCollection3() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DireccionResidencial_items", this.getSelected().getDireccionResidencialCollection3());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/administration/views/direccionResidencial/index";
    }

    /**
     * Sets the "items" attribute with a collection of DireccionResidencial
     * entities that are retrieved from TablaLogicaAdm?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DireccionResidencial page
     */
    public String navigateDireccionResidencialCollection4() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DireccionResidencial_items", this.getSelected().getDireccionResidencialCollection4());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/administration/views/direccionResidencial/index";
    }

    /**
     * Sets the "items" attribute with a collection of EntidadAdm entities that
     * are retrieved from TablaLogicaAdm?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for EntidadAdm page
     */
    public String navigateEntidadCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EntidadAdm_items", this.getSelected().getEntidadCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/administration/views/entidadAdm/index";
    }

    /**
     * Sets the "items" attribute with a collection of EntidadAdm entities that
     * are retrieved from TablaLogicaAdm?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for EntidadAdm page
     */
    public String navigateEntidadCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EntidadAdm_items", this.getSelected().getEntidadCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/administration/views/entidadAdm/index";
    }

    /**
     * Sets the "items" attribute with a collection of EntidadAdm entities that
     * are retrieved from TablaLogicaAdm?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for EntidadAdm page
     */
    public String navigateEntidadCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EntidadAdm_items", this.getSelected().getEntidadCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/administration/views/entidadAdm/index";
    }

    /**
     * Sets the "items" attribute with a collection of EntidadAdm entities that
     * are retrieved from TablaLogicaAdm?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for EntidadAdm page
     */
    public String navigateEntidadCollection3() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EntidadAdm_items", this.getSelected().getEntidadCollection3());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/administration/views/entidadAdm/index";
    }

}
