/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.models;

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
    @NamedQuery(name = "TablaLogica.findAll", query = "SELECT t FROM TablaLogica t"),
    @NamedQuery(name = "TablaLogica.findByIdCodec", query = "SELECT t FROM TablaLogica t WHERE t.idCodec = :idCodec"),
    @NamedQuery(name = "TablaLogica.findByTipotabla", query = "SELECT t FROM TablaLogica t WHERE t.tipotabla = :tipotabla"),
    @NamedQuery(name = "TablaLogica.findByCodePadre", query = "SELECT t FROM TablaLogica t WHERE t.codePadre = :codePadre"),
    @NamedQuery(name = "TablaLogica.findByNombreCorto", query = "SELECT t FROM TablaLogica t WHERE t.nombreCorto = :nombreCorto"),
    @NamedQuery(name = "TablaLogica.findByNombreLargo", query = "SELECT t FROM TablaLogica t WHERE t.nombreLargo = :nombreLargo"),
    @NamedQuery(name = "TablaLogica.findByCodelang", query = "SELECT t FROM TablaLogica t WHERE t.codelang = :codelang"),
    @NamedQuery(name = "TablaLogica.findByEstado", query = "SELECT t FROM TablaLogica t WHERE t.estado = :estado"),
    @NamedQuery(name = "TablaLogica.findByDescripcion", query = "SELECT t FROM TablaLogica t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TablaLogica.findByFechaRegistro", query = "SELECT t FROM TablaLogica t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "TablaLogica.findByFechaModificacion", query = "SELECT t FROM TablaLogica t WHERE t.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "TablaLogica.findByUserRegistro", query = "SELECT t FROM TablaLogica t WHERE t.userRegistro = :userRegistro"),
    @NamedQuery(name = "TablaLogica.findByUserModificion", query = "SELECT t FROM TablaLogica t WHERE t.userModificion = :userModificion")})
public class TablaLogicaAdm implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lugar")
    private Collection<Telefonino> telefoninoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lugar")
    private Collection<DireccionElectronica> direccionElectronicaCollection;
    @OneToMany(mappedBy = "tipoCorreo")
    private Collection<DireccionElectronica> direccionElectronicaCollection1;
    @OneToMany(mappedBy = "tipoUrl")
    private Collection<DireccionElectronica> direccionElectronicaCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private Collection<DireccionResidencial> direccionResidencialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lugar")
    private Collection<DireccionResidencial> direccionResidencialCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private Collection<DireccionResidencial> direccionResidencialCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sector")
    private Collection<DireccionResidencial> direccionResidencialCollection3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "urbanizacion")
    private Collection<DireccionResidencial> direccionResidencialCollection4;
    @OneToMany(mappedBy = "ciudad")
    private Collection<EntidadAdm> entidadCollection;
    @OneToMany(mappedBy = "genero")
    private Collection<EntidadAdm> entidadCollection1;
    @OneToMany(mappedBy = "nacionalidad")
    private Collection<EntidadAdm> entidadCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoidentificacion")
    private Collection<EntidadAdm> entidadCollection3;

    public TablaLogicaAdm() {
    }

    public TablaLogicaAdm(Integer idCodec) {
        this.idCodec = idCodec;
    }

    public TablaLogicaAdm(Integer idCodec, String tipotabla, String nombreCorto, String nombreLargo) {
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
    public Collection<Telefonino> getTelefoninoCollection() {
        return telefoninoCollection;
    }

    public void setTelefoninoCollection(Collection<Telefonino> telefoninoCollection) {
        this.telefoninoCollection = telefoninoCollection;
    }

    @XmlTransient
    public Collection<DireccionElectronica> getDireccionElectronicaCollection() {
        return direccionElectronicaCollection;
    }

    public void setDireccionElectronicaCollection(Collection<DireccionElectronica> direccionElectronicaCollection) {
        this.direccionElectronicaCollection = direccionElectronicaCollection;
    }

    @XmlTransient
    public Collection<DireccionElectronica> getDireccionElectronicaCollection1() {
        return direccionElectronicaCollection1;
    }

    public void setDireccionElectronicaCollection1(Collection<DireccionElectronica> direccionElectronicaCollection1) {
        this.direccionElectronicaCollection1 = direccionElectronicaCollection1;
    }

    @XmlTransient
    public Collection<DireccionElectronica> getDireccionElectronicaCollection2() {
        return direccionElectronicaCollection2;
    }

    public void setDireccionElectronicaCollection2(Collection<DireccionElectronica> direccionElectronicaCollection2) {
        this.direccionElectronicaCollection2 = direccionElectronicaCollection2;
    }

    @XmlTransient
    public Collection<DireccionResidencial> getDireccionResidencialCollection() {
        return direccionResidencialCollection;
    }

    public void setDireccionResidencialCollection(Collection<DireccionResidencial> direccionResidencialCollection) {
        this.direccionResidencialCollection = direccionResidencialCollection;
    }

    @XmlTransient
    public Collection<DireccionResidencial> getDireccionResidencialCollection1() {
        return direccionResidencialCollection1;
    }

    public void setDireccionResidencialCollection1(Collection<DireccionResidencial> direccionResidencialCollection1) {
        this.direccionResidencialCollection1 = direccionResidencialCollection1;
    }

    @XmlTransient
    public Collection<DireccionResidencial> getDireccionResidencialCollection2() {
        return direccionResidencialCollection2;
    }

    public void setDireccionResidencialCollection2(Collection<DireccionResidencial> direccionResidencialCollection2) {
        this.direccionResidencialCollection2 = direccionResidencialCollection2;
    }

    @XmlTransient
    public Collection<DireccionResidencial> getDireccionResidencialCollection3() {
        return direccionResidencialCollection3;
    }

    public void setDireccionResidencialCollection3(Collection<DireccionResidencial> direccionResidencialCollection3) {
        this.direccionResidencialCollection3 = direccionResidencialCollection3;
    }

    @XmlTransient
    public Collection<DireccionResidencial> getDireccionResidencialCollection4() {
        return direccionResidencialCollection4;
    }

    public void setDireccionResidencialCollection4(Collection<DireccionResidencial> direccionResidencialCollection4) {
        this.direccionResidencialCollection4 = direccionResidencialCollection4;
    }

    @XmlTransient
    public Collection<EntidadAdm> getEntidadCollection() {
        return entidadCollection;
    }

    public void setEntidadCollection(Collection<EntidadAdm> entidadCollection) {
        this.entidadCollection = entidadCollection;
    }

    @XmlTransient
    public Collection<EntidadAdm> getEntidadCollection1() {
        return entidadCollection1;
    }

    public void setEntidadCollection1(Collection<EntidadAdm> entidadCollection1) {
        this.entidadCollection1 = entidadCollection1;
    }

    @XmlTransient
    public Collection<EntidadAdm> getEntidadCollection2() {
        return entidadCollection2;
    }

    public void setEntidadCollection2(Collection<EntidadAdm> entidadCollection2) {
        this.entidadCollection2 = entidadCollection2;
    }

    @XmlTransient
    public Collection<EntidadAdm> getEntidadCollection3() {
        return entidadCollection3;
    }

    public void setEntidadCollection3(Collection<EntidadAdm> entidadCollection3) {
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
        if (!(object instanceof TablaLogicaAdm)) {
            return false;
        }
        TablaLogicaAdm other = (TablaLogicaAdm) object;
        if ((this.idCodec == null && other.idCodec != null) || (this.idCodec != null && !this.idCodec.equals(other.idCodec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administracion.models.TablaLogica[ idCodec=" + idCodec + " ]";
    }
    
}
