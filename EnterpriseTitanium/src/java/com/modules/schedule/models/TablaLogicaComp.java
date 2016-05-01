/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.schedule.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "mant_logictabla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TablaLogicaAdm.findAll", query = "SELECT t FROM TablaLogicaAdm t"),
    @NamedQuery(name = "TablaLogicaAdm.findByIdCodec", query = "SELECT t FROM TablaLogicaAdm t WHERE t.idCodec = :idCodec"),
    @NamedQuery(name = "TablaLogicaAdm.findByTipotabla", query = "SELECT t FROM TablaLogicaAdm t WHERE t.tipotabla = :tipotabla"),
    @NamedQuery(name = "TablaLogicaAdm.findByCodePadre", query = "SELECT t FROM TablaLogicaAdm t WHERE t.codePadre = :codePadre"),
    @NamedQuery(name = "TablaLogicaAdm.findByNombreCorto", query = "SELECT t FROM TablaLogicaAdm t WHERE t.nombreCorto = :nombreCorto"),
    @NamedQuery(name = "TablaLogicaAdm.findByNombreLargo", query = "SELECT t FROM TablaLogicaAdm t WHERE t.nombreLargo = :nombreLargo"),
    @NamedQuery(name = "TablaLogicaAdm.findByCodelang", query = "SELECT t FROM TablaLogicaAdm t WHERE t.codelang = :codelang"),
    @NamedQuery(name = "TablaLogicaAdm.findByEstado", query = "SELECT t FROM TablaLogicaAdm t WHERE t.estado = :estado"),
    @NamedQuery(name = "TablaLogicaAdm.findByDescripcion", query = "SELECT t FROM TablaLogicaAdm t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TablaLogicaAdm.findByFechaRegistro", query = "SELECT t FROM TablaLogicaAdm t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "TablaLogicaAdm.findByFechaModificacion", query = "SELECT t FROM TablaLogicaAdm t WHERE t.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "TablaLogicaAdm.findByUserRegistro", query = "SELECT t FROM TablaLogicaAdm t WHERE t.userRegistro = :userRegistro"),
    @NamedQuery(name = "TablaLogicaAdm.findByUserModificion", query = "SELECT t FROM TablaLogicaAdm t WHERE t.userModificion = :userModificion")})
public class TablaLogicaComp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_codec")
    private Integer idCodec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipotabla")
    private String tipotabla;
    @Column(name = "code_padre")
    private Integer codePadre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_corto")
    private String nombreCorto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_largo")
    private String nombreLargo;
    @Size(max = 45)
    @Column(name = "codelang")
    private String codelang;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "user_registro")
    private Integer userRegistro;
    @Column(name = "user_modificion")
    private Integer userModificion;
    @OneToMany(mappedBy = "ciudad")
    private Collection<EntidadComp> entidadCollection;
    @OneToMany(mappedBy = "genero")
    private Collection<EntidadComp> entidadCollection1;
    @OneToMany(mappedBy = "nacionalidad")
    private Collection<EntidadComp> entidadCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoidentificacion")
    private Collection<EntidadComp> entidadCollection3;

    public TablaLogicaComp() {
    }

    public TablaLogicaComp(Integer idCodec) {
        this.idCodec = idCodec;
    }

    public TablaLogicaComp(Integer idCodec, String tipotabla, String nombreCorto, String nombreLargo) {
        this.idCodec = idCodec;
        this.tipotabla = tipotabla;
        this.nombreCorto = nombreCorto;
        this.nombreLargo = nombreLargo;
    }

    public Integer getIdCodec() {
        return idCodec;
    }

    public void setIdCodec(Integer idCodec) {
        this.idCodec = idCodec;
    }

    public String getTipotabla() {
        return tipotabla;
    }

    public void setTipotabla(String tipotabla) {
        this.tipotabla = tipotabla;
    }

    public Integer getCodePadre() {
        return codePadre;
    }

    public void setCodePadre(Integer codePadre) {
        this.codePadre = codePadre;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getNombreLargo() {
        return nombreLargo;
    }

    public void setNombreLargo(String nombreLargo) {
        this.nombreLargo = nombreLargo;
    }

    public String getCodelang() {
        return codelang;
    }

    public void setCodelang(String codelang) {
        this.codelang = codelang;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Integer userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Integer getUserModificion() {
        return userModificion;
    }

    public void setUserModificion(Integer userModificion) {
        this.userModificion = userModificion;
    }

    @XmlTransient
    public Collection<EntidadComp> getEntidadCollection() {
        return entidadCollection;
    }

    public void setEntidadCollection(Collection<EntidadComp> entidadCollection) {
        this.entidadCollection = entidadCollection;
    }

    @XmlTransient
    public Collection<EntidadComp> getEntidadCollection1() {
        return entidadCollection1;
    }

    public void setEntidadCollection1(Collection<EntidadComp> entidadCollection1) {
        this.entidadCollection1 = entidadCollection1;
    }

    @XmlTransient
    public Collection<EntidadComp> getEntidadCollection2() {
        return entidadCollection2;
    }

    public void setEntidadCollection2(Collection<EntidadComp> entidadCollection2) {
        this.entidadCollection2 = entidadCollection2;
    }

    @XmlTransient
    public Collection<EntidadComp> getEntidadCollection3() {
        return entidadCollection3;
    }

    public void setEntidadCollection3(Collection<EntidadComp> entidadCollection3) {
        this.entidadCollection3 = entidadCollection3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCodec != null ? idCodec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TablaLogicaComp)) {
            return false;
        }
        TablaLogicaComp other = (TablaLogicaComp) object;
        if ((this.idCodec == null && other.idCodec != null) || (this.idCodec != null && !this.idCodec.equals(other.idCodec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modules.models.TablaLogicaAdm[ idCodec=" + idCodec + " ]";
    }
    
}
