package com.administracion.controllers;

import com.administracion.controllers.util.MobilePageControllerAdm;
import com.administracion.models.EntidadAdm;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "entidadAdmController")
@ViewScoped
public class EntidadAdmController extends AbstractController<EntidadAdm> {

    @Inject
    private TablaLogicaAdmController ciudadController;
    @Inject
    private TablaLogicaAdmController generoController;
    @Inject
    private TablaLogicaAdmController nacionalidadController;
    @Inject
    private TablaLogicaAdmController tipoidentificacionController;
    @Inject
    private MobilePageControllerAdm mobilePageController;

    public EntidadAdmController() {
        // Inform the Abstract parent controller of the concrete EntidadAdm Entity
        super(EntidadAdm.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        ciudadController.setSelected(null);
        generoController.setSelected(null);
        nacionalidadController.setSelected(null);
        tipoidentificacionController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Telefonino entities that
 are retrieved from EntidadAdm?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Telefonino page
     */
    public String navigateTelefoninoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Telefonino_items", this.getSelected().getTelefoninoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/core/administration/views/contactmoviles/index";
    }

    /**
     * Sets the "items" attribute with a collection of DireccionElectronica
     * entities that are retrieved from EntidadAdm?cap_first and returns the
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
     * Sets the "items" attribute with a collection of DireccionResidencial
     * entities that are retrieved from EntidadAdm?cap_first and returns the
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
     * Sets the "selected" attribute of the TablaLogicaAdm controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCiudad(ActionEvent event) {
        if (this.getSelected() != null && ciudadController.getSelected() == null) {
            ciudadController.setSelected(this.getSelected().getCiudad());
        }
    }

    /**
     * Sets the "selected" attribute of the TablaLogicaAdm controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGenero(ActionEvent event) {
        if (this.getSelected() != null && generoController.getSelected() == null) {
            generoController.setSelected(this.getSelected().getGenero());
        }
    }

    /**
     * Sets the "selected" attribute of the TablaLogicaAdm controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareNacionalidad(ActionEvent event) {
        if (this.getSelected() != null && nacionalidadController.getSelected() == null) {
            nacionalidadController.setSelected(this.getSelected().getNacionalidad());
        }
    }

    /**
     * Sets the "selected" attribute of the TablaLogicaAdm controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoidentificacion(ActionEvent event) {
        if (this.getSelected() != null && tipoidentificacionController.getSelected() == null) {
            tipoidentificacionController.setSelected(this.getSelected().getTipoidentificacion());
        }
    }
}
