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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julio Cortorreal
 */
@Entity
@Table(name = "seg_acceso_modulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegAccesoModulo.findAll", query = "SELECT s FROM SegAccesoModulo s"),
    @NamedQuery(name = "SegAccesoModulo.findByIdSegAccesoModulo", query = "SELECT s FROM SegAccesoModulo s WHERE s.idSegAccesoModulo = :idSegAccesoModulo"),
    @NamedQuery(name = "SegAccesoModulo.findByEstado", query = "SELECT s FROM SegAccesoModulo s WHERE s.estado = :estado")})
public class SegAccesoModulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSeg_Acceso_Modulo")
    private Integer idSegAccesoModulo;
    @Size(max = 1)
    @Column(name = "Estado")
    private String estado;
    @JoinColumn(name = "Id_App_Modulo", referencedColumnName = "Cod_Modulo")
    @ManyToOne
    private Modulo idAppModulo;
    @JoinColumn(name = "Id_Cuenta", referencedColumnName = "Cuenta_Id")
    @ManyToOne(optional = false)
    private CuentaUsuario idCuenta;

    public SegAccesoModulo() {
    }

    public SegAccesoModulo(Integer idSegAccesoModulo) {
        this.idSegAccesoModulo = idSegAccesoModulo;
    }

    public Integer getIdSegAccesoModulo() {
        return idSegAccesoModulo;
    }

    public void setIdSegAccesoModulo(Integer idSegAccesoModulo) {
        this.idSegAccesoModulo = idSegAccesoModulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Modulo getIdAppModulo() {
        return idAppModulo;
    }

    public void setIdAppModulo(Modulo idAppModulo) {
        this.idAppModulo = idAppModulo;
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
        hash += (idSegAccesoModulo != null ? idSegAccesoModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegAccesoModulo)) {
            return false;
        }
        SegAccesoModulo other = (SegAccesoModulo) object;
        if ((this.idSegAccesoModulo == null && other.idSegAccesoModulo != null) || (this.idSegAccesoModulo != null && !this.idSegAccesoModulo.equals(other.idSegAccesoModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.security.models.SegAccesoModulo[ idSegAccesoModulo=" + idSegAccesoModulo + " ]";
    }
    
}
