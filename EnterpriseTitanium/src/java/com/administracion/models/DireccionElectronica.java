/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julio Cortorreal
 */
@Entity
@Table(name = "adm_direccion_digital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DireccionElectronica.findAll", query = "SELECT d FROM DireccionElectronica d"),
    @NamedQuery(name = "DireccionElectronica.findByIdDireccionDigital", query = "SELECT d FROM DireccionElectronica d WHERE d.idDireccionDigital = :idDireccionDigital"),
    @NamedQuery(name = "DireccionElectronica.findByDireccion", query = "SELECT d FROM DireccionElectronica d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DireccionElectronica.findByEstadoDireccion", query = "SELECT d FROM DireccionElectronica d WHERE d.estadoDireccion = :estadoDireccion")})
public class DireccionElectronica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDireccion_Digital")
    private Integer idDireccionDigital;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "estado_direccion")
    private String estadoDireccion;
    @JoinColumn(name = "id_entidad", referencedColumnName = "id_entidad")
    @ManyToOne(optional = false)
    private EntidadAdm idEntidad;
    @JoinColumn(name = "lugar", referencedColumnName = "id_codec")
    @ManyToOne(optional = false)
    private TablaLogicaAdm lugar;
    @JoinColumn(name = "tipo_correo", referencedColumnName = "id_codec")
    @ManyToOne
    private TablaLogicaAdm tipoCorreo;
    @JoinColumn(name = "tipo_url", referencedColumnName = "id_codec")
    @ManyToOne
    private TablaLogicaAdm tipoUrl;

    public DireccionElectronica() {
    }

    public DireccionElectronica(Integer idDireccionDigital) {
        this.idDireccionDigital = idDireccionDigital;
    }

    public DireccionElectronica(Integer idDireccionDigital, String direccion) {
        this.idDireccionDigital = idDireccionDigital;
        this.direccion = direccion;
    }

    public Integer getIdDireccionDigital() {
        return idDireccionDigital;
    }

    public void setIdDireccionDigital(Integer idDireccionDigital) {
        this.idDireccionDigital = idDireccionDigital;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoDireccion() {
        return estadoDireccion;
    }

    public void setEstadoDireccion(String estadoDireccion) {
        this.estadoDireccion = estadoDireccion;
    }

    public EntidadAdm getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(EntidadAdm idEntidad) {
        this.idEntidad = idEntidad;
    }

    public TablaLogicaAdm getLugar() {
        return lugar;
    }

    public void setLugar(TablaLogicaAdm lugar) {
        this.lugar = lugar;
    }

    public TablaLogicaAdm getTipoCorreo() {
        return tipoCorreo;
    }

    public void setTipoCorreo(TablaLogicaAdm tipoCorreo) {
        this.tipoCorreo = tipoCorreo;
    }

    public TablaLogicaAdm getTipoUrl() {
        return tipoUrl;
    }

    public void setTipoUrl(TablaLogicaAdm tipoUrl) {
        this.tipoUrl = tipoUrl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccionDigital != null ? idDireccionDigital.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionElectronica)) {
            return false;
        }
        DireccionElectronica other = (DireccionElectronica) object;
        if ((this.idDireccionDigital == null && other.idDireccionDigital != null) || (this.idDireccionDigital != null && !this.idDireccionDigital.equals(other.idDireccionDigital))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administracion.models.DireccionElectronica[ idDireccionDigital=" + idDireccionDigital + " ]";
    }
    
}
