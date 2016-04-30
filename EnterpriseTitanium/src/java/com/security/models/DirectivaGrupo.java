/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Julio Cortorreal
 */
@Entity
@Table(name = "seg_directiva_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DirectivaGrupo.findAll", query = "SELECT d FROM DirectivaGrupo d"),
    @NamedQuery(name = "DirectivaGrupo.findByIdSegDirectivaGrupo", query = "SELECT d FROM DirectivaGrupo d WHERE d.idSegDirectivaGrupo = :idSegDirectivaGrupo"),
    @NamedQuery(name = "DirectivaGrupo.findByNombre", query = "SELECT d FROM DirectivaGrupo d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DirectivaGrupo.findByDescripcion", query = "SELECT d FROM DirectivaGrupo d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DirectivaGrupo.findByEstado", query = "SELECT d FROM DirectivaGrupo d WHERE d.estado = :estado"),
    @NamedQuery(name = "DirectivaGrupo.findByFechaRegistro", query = "SELECT d FROM DirectivaGrupo d WHERE d.fechaRegistro = :fechaRegistro")})
public class DirectivaGrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSeg_Directiva_Grupo")
    private Integer idSegDirectivaGrupo;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 120)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "Fecha_Registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupo")
    private Collection<PoliticasAccesoGrupo> politicasAccesoGrupoCollection;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "Cuenta_Id")
    @ManyToOne(optional = false)
    private CuentaUsuario idCuenta;

    public DirectivaGrupo() {
    }

    public DirectivaGrupo(Integer idSegDirectivaGrupo) {
        this.idSegDirectivaGrupo = idSegDirectivaGrupo;
    }

    public Integer getIdSegDirectivaGrupo() {
        return idSegDirectivaGrupo;
    }

    public void setIdSegDirectivaGrupo(Integer idSegDirectivaGrupo) {
        this.idSegDirectivaGrupo = idSegDirectivaGrupo;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public Collection<PoliticasAccesoGrupo> getPoliticasAccesoGrupoCollection() {
        return politicasAccesoGrupoCollection;
    }

    public void setPoliticasAccesoGrupoCollection(Collection<PoliticasAccesoGrupo> politicasAccesoGrupoCollection) {
        this.politicasAccesoGrupoCollection = politicasAccesoGrupoCollection;
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
        hash += (idSegDirectivaGrupo != null ? idSegDirectivaGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DirectivaGrupo)) {
            return false;
        }
        DirectivaGrupo other = (DirectivaGrupo) object;
        if ((this.idSegDirectivaGrupo == null && other.idSegDirectivaGrupo != null) || (this.idSegDirectivaGrupo != null && !this.idSegDirectivaGrupo.equals(other.idSegDirectivaGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.security.models.DirectivaGrupo[ idSegDirectivaGrupo=" + idSegDirectivaGrupo + " ]";
    }
    
}
