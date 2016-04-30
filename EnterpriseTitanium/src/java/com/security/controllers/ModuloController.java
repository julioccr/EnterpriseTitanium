package com.security.controllers;

import com.security.controllers.util.MobilePageController;
import com.security.models.Modulo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "moduloController")
@ViewScoped
public class ModuloController extends AbstractController<Modulo> {

    @Inject
    private AplicacionController idAplicativoController;
    @Inject
    private MobilePageController mobilePageController;

    public ModuloController() {
        // Inform the Abstract parent controller of the concrete Modulo Entity
        super(Modulo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idAplicativoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Transaccion entities that
     * are retrieved from Modulo?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Transaccion page
     */
    public String navigateTransaccionCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Transaccion_items", this.getSelected().getTransaccionCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/securitymaneger/views/transaccion/index";
    }

    /**
     * Sets the "items" attribute with a collection of SegAccesoModulo entities
     * that are retrieved from Modulo?cap_first and returns the navigation
     * outcome.
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
     * Sets the "selected" attribute of the Aplicacion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdAplicativo(ActionEvent event) {
        if (this.getSelected() != null && idAplicativoController.getSelected() == null) {
            idAplicativoController.setSelected(this.getSelected().getIdAplicativo());
        }
    }
}
