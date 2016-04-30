/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.models;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "app_transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t"),
    @NamedQuery(name = "Transaccion.findByIdTransaccion", query = "SELECT t FROM Transaccion t WHERE t.idTransaccion = :idTransaccion"),
    @NamedQuery(name = "Transaccion.findByNombreTrans", query = "SELECT t FROM Transaccion t WHERE t.nombreTrans = :nombreTrans"),
    @NamedQuery(name = "Transaccion.findByDescripcionTrans", query = "SELECT t FROM Transaccion t WHERE t.descripcionTrans = :descripcionTrans"),
    @NamedQuery(name = "Transaccion.findByEstadoTransf", query = "SELECT t FROM Transaccion t WHERE t.estadoTransf = :estadoTransf")})
public class Transaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Transaccion")
    private Integer idTransaccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Nombre_Trans")
    private String nombreTrans;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Descripcion_Trans")
    private String descripcionTrans;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Estado_Transf")
    private String estadoTransf;
    @JoinColumn(name = "App_Modulo_Cod_Modulo", referencedColumnName = "Cod_Modulo")
    @ManyToOne(optional = false)
    private Modulo appModuloCodModulo;
    @OneToMany(mappedBy = "idTransaccion")
    private Collection<PoliticasAccesoGrupo> politicasAccesoGrupoCollection;
    @OneToMany(mappedBy = "idTransaccion")
    private Collection<PoliticasAccesoUsuario> politicasAccesoUsuarioCollection;

    public Transaccion() {
    }

    public Transaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Transaccion(Integer idTransaccion, String nombreTrans, String descripcionTrans, String estadoTransf) {
        this.idTransaccion = idTransaccion;
        this.nombreTrans = nombreTrans;
        this.descripcionTrans = descripcionTrans;
        this.estadoTransf = estadoTransf;
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getNombreTrans() {
        return nombreTrans;
    }

    public void setNombreTrans(String nombreTrans) {
        this.nombreTrans = nombreTrans;
    }

    public String getDescripcionTrans() {
        return descripcionTrans;
    }

    public void setDescripcionTrans(String descripcionTrans) {
        this.descripcionTrans = descripcionTrans;
    }

    public String getEstadoTransf() {
        return estadoTransf;
    }

    public void setEstadoTransf(String estadoTransf) {
        this.estadoTransf = estadoTransf;
    }

    public Modulo getAppModuloCodModulo() {
        return appModuloCodModulo;
    }

    public void setAppModuloCodModulo(Modulo appModuloCodModulo) {
        this.appModuloCodModulo = appModuloCodModulo;
    }

    @XmlTransient
    public Collection<PoliticasAccesoGrupo> getPoliticasAccesoGrupoCollection() {
        return politicasAccesoGrupoCollection;
    }

    public void setPoliticasAccesoGrupoCollection(Collection<PoliticasAccesoGrupo> politicasAccesoGrupoCollection) {
        this.politicasAccesoGrupoCollection = politicasAccesoGrupoCollection;
    }

    @XmlTransient
    public Collection<PoliticasAccesoUsuario> getPoliticasAccesoUsuarioCollection() {
        return politicasAccesoUsuarioCollection;
    }

    public void setPoliticasAccesoUsuarioCollection(Collection<PoliticasAccesoUsuario> politicasAccesoUsuarioCollection) {
        this.politicasAccesoUsuarioCollection = politicasAccesoUsuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaccion != null ? idTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.security.models.Transaccion[ idTransaccion=" + idTransaccion + " ]";
    }
    
}
