/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.models;

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
@Table(name = "seg_acceso_aplicativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlAccesoAplicacion.findAll", query = "SELECT c FROM ControlAccesoAplicacion c"),
    @NamedQuery(name = "ControlAccesoAplicacion.findByAccesoAppId", query = "SELECT c FROM ControlAccesoAplicacion c WHERE c.accesoAppId = :accesoAppId"),
    @NamedQuery(name = "ControlAccesoAplicacion.findByTiempoSession", query = "SELECT c FROM ControlAccesoAplicacion c WHERE c.tiempoSession = :tiempoSession"),
    @NamedQuery(name = "ControlAccesoAplicacion.findByEstado", query = "SELECT c FROM ControlAccesoAplicacion c WHERE c.estado = :estado")})
public class ControlAccesoAplicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "acceso_app_id")
    private Integer accesoAppId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo_session")
    private int tiempoSession;
    @Size(max = 1)
    @Column(name = "Estado")
    private String estado;
    @JoinColumn(name = "id_app", referencedColumnName = "idAplicativo")
    @ManyToOne(optional = false)
    private Aplicacion idApp;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "Cuenta_Id")
    @ManyToOne(optional = false)
    private CuentaUsuario idCuenta;

    public ControlAccesoAplicacion() {
    }

    public ControlAccesoAplicacion(Integer accesoAppId) {
        this.accesoAppId = accesoAppId;
    }

    public ControlAccesoAplicacion(Integer accesoAppId, int tiempoSession) {
        this.accesoAppId = accesoAppId;
        this.tiempoSession = tiempoSession;
    }

    public Integer getAccesoAppId() {
        return accesoAppId;
    }

    public void setAccesoAppId(Integer accesoAppId) {
        this.accesoAppId = accesoAppId;
    }

    public int getTiempoSession() {
        return tiempoSession;
    }

    public void setTiempoSession(int tiempoSession) {
        this.tiempoSession = tiempoSession;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Aplicacion getIdApp() {
        return idApp;
    }

    public void setIdApp(Aplicacion idApp) {
        this.idApp = idApp;
    }

    public CuentaUsuario getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(CuentaUsuario idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accesoAppId != null ? accesoAppId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlAccesoAplicacion)) {
            return false;
        }
        ControlAccesoAplicacion other = (ControlAccesoAplicacion) object;
        if ((this.accesoAppId == null && other.accesoAppId != null) || (this.accesoAppId != null && !this.accesoAppId.equals(other.accesoAppId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.security.models.ControlAccesoAplicacion[ accesoAppId=" + accesoAppId + " ]";
    }
    
}
