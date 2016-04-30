/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Julio Cortorreal
 */
@Entity
@Table(name = "app_aplicativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aplicacion.findAll", query = "SELECT a FROM Aplicacion a"),
    @NamedQuery(name = "Aplicacion.findByIdAplicativo", query = "SELECT a FROM Aplicacion a WHERE a.idAplicativo = :idAplicativo"),
    @NamedQuery(name = "Aplicacion.findByNombre", query = "SELECT a FROM Aplicacion a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Aplicacion.findByDescripcion", query = "SELECT a FROM Aplicacion a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Aplicacion.findBySoporte", query = "SELECT a FROM Aplicacion a WHERE a.soporte = :soporte"),
    @NamedQuery(name = "Aplicacion.findByEstadoApp", query = "SELECT a FROM Aplicacion a WHERE a.estadoApp = :estadoApp")})
public class Aplicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAplicativo")
    private Integer idAplicativo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "Soporte")
    private String soporte;
    @Size(max = 45)
    @Column(name = "estado_app")
    private String estadoApp;
    @OneToMany(mappedBy = "idAplicativo")
    private Collection<Modulo> moduloCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idApp")
    private Collection<ControlAccesoAplicacion> controlAccesoAplicacionCollection;

    public Aplicacion() {
    }

    public Aplicacion(Integer idAplicativo) {
        this.idAplicativo = idAplicativo;
    }

    public Aplicacion(Integer idAplicativo, String nombre) {
        this.idAplicativo = idAplicativo;
        this.nombre = nombre;
    }

    public Integer getIdAplicativo() {
        return idAplicativo;
    }

    public void setIdAplicativo(Integer idAplicativo) {
        this.idAplicativo = idAplicativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSoporte() {
        return soporte;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }

    public String getEstadoApp() {
        return estadoApp;
    }

    public void setEstadoApp(String estadoApp) {
        this.estadoApp = estadoApp;
    }

    @XmlTransient
    public Collection<Modulo> getModuloCollection() {
        return moduloCollection;
    }

    public void setModuloCollection(Collection<Modulo> moduloCollection) {
        this.moduloCollection = moduloCollection;
    }

    @XmlTransient
    public Collection<ControlAccesoAplicacion> getControlAccesoAplicacionCollection() {
        return controlAccesoAplicacionCollection;
    }

    public void setControlAccesoAplicacionCollection(Collection<ControlAccesoAplicacion> controlAccesoAplicacionCollection) {
        this.controlAccesoAplicacionCollection = controlAccesoAplicacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAplicativo != null ? idAplicativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aplicacion)) {
            return false;
        }
        Aplicacion other = (Aplicacion) object;
        if ((this.idAplicativo == null && other.idAplicativo != null) || (this.idAplicativo != null && !this.idAplicativo.equals(other.idAplicativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.security.models.Aplicacion[ idAplicativo=" + idAplicativo + " ]";
    }
    
}
