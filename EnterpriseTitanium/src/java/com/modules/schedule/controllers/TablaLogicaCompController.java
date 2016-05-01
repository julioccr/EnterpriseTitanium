package com.modules.schedule.controllers;

import com.modules.schedule.controllers.util.MobilePageController;
import com.modules.schedule.models.TablaLogicaComp;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tablaLogicaCompController")
@ViewScoped
public class TablaLogicaCompController extends AbstractController<TablaLogicaComp> {

    @Inject
    private MobilePageController mobilePageController;

    public TablaLogicaCompController() {
        // Inform the Abstract parent controller of the concrete TablaLogicaComp Entity
        super(TablaLogicaComp.class);
    }

    /**
     * Sets the "items" attribute with a collection of EntidadComp entities that
     * are retrieved from TablaLogicaComp?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for EntidadComp page
     */
    public String navigateEntidadCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EntidadComp_items", this.getSelected().getEntidadCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/modules/schedule_events/views/entidadComp/index";
    }

    /**
     * Sets the "items" attribute with a collection of EntidadComp entities that
     * are retrieved from TablaLogicaComp?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for EntidadComp page
     */
    public String navigateEntidadCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EntidadComp_items", this.getSelected().getEntidadCollection1());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/modules/schedule_events/views/entidadComp/index";
    }

    /**
     * Sets the "items" attribute with a collection of EntidadComp entities that
     * are retrieved from TablaLogicaComp?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for EntidadComp page
     */
    public String navigateEntidadCollection2() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EntidadComp_items", this.getSelected().getEntidadCollection2());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/modules/schedule_events/views/entidadComp/index";
    }

    /**
     * Sets the "items" attribute with a collection of EntidadComp entities that
     * are retrieved from TablaLogicaComp?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for EntidadComp page
     */
    public String navigateEntidadCollection3() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EntidadComp_items", this.getSelected().getEntidadCollection3());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/modules/schedule_events/views/entidadComp/index";
    }

}
