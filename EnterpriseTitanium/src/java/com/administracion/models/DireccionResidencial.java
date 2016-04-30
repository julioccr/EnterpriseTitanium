/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julio Cortorreal
 */
@Entity
@Table(name = "adm_direccion_fisico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DireccionResidencial.findAll", query = "SELECT d FROM DireccionResidencial d"),
    @NamedQuery(name = "DireccionResidencial.findByIdDireccion", query = "SELECT d FROM DireccionResidencial d WHERE d.idDireccion = :idDireccion"),
    @NamedQuery(name = "DireccionResidencial.findByCalle", query = "SELECT d FROM DireccionResidencial d WHERE d.calle = :calle"),
    @NamedQuery(name = "DireccionResidencial.findByNumero", query = "SELECT d FROM DireccionResidencial d WHERE d.numero = :numero"),
    @NamedQuery(name = "DireccionResidencial.findByNivel", query = "SELECT d FROM DireccionResidencial d WHERE d.nivel = :nivel"),
    @NamedQuery(name = "DireccionResidencial.findByReferencia", query = "SELECT d FROM DireccionResidencial d WHERE d.referencia = :referencia"),
    @NamedQuery(name = "DireccionResidencial.findByFechaRegistro", query = "SELECT d FROM DireccionResidencial d WHERE d.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "DireccionResidencial.findByEstado", query = "SELECT d FROM DireccionResidencial d WHERE d.estado = :estado")})
public class DireccionResidencial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_direccion")
    private Integer idDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Calle")
    private String calle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numero")
    private int numero;
    @Column(name = "Nivel")
    private Integer nivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Referencia")
    private String referencia;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "Ciudad", referencedColumnName = "id_codec")
    @ManyToOne(optional = false)
    private TablaLogicaAdm ciudad;
    @JoinColumn(name = "id_entidad", referencedColumnName = "id_entidad")
    @ManyToOne(optional = false)
    private EntidadAdm idEntidad;
    @JoinColumn(name = "Lugar", referencedColumnName = "id_codec")
    @ManyToOne(optional = false)
    private TablaLogicaAdm lugar;
    @JoinColumn(name = "Pais", referencedColumnName = "id_codec")
    @ManyToOne(optional = false)
    private TablaLogicaAdm pais;
    @JoinColumn(name = "Sector", referencedColumnName = "id_codec")
    @ManyToOne(optional = false)
    private TablaLogicaAdm sector;
    @JoinColumn(name = "Urbanizacion", referencedColumnName = "id_codec")
    @ManyToOne(optional = false)
    private TablaLogicaAdm urbanizacion;

    public DireccionResidencial() {
    }

    public DireccionResidencial(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public DireccionResidencial(Integer idDireccion, String calle, int numero, String referencia) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.numero = numero;
        this.referencia = referencia;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TablaLogicaAdm getCiudad() {
        return ciudad;
    }

    public void setCiudad(TablaLogicaAdm ciudad) {
        this.ciudad = ciudad;
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

    public TablaLogicaAdm getPais() {
        return pais;
    }

    public void setPais(TablaLogicaAdm pais) {
        this.pais = pais;
    }

    public TablaLogicaAdm getSector() {
        return sector;
    }

    public void setSector(TablaLogicaAdm sector) {
        this.sector = sector;
    }

    public TablaLogicaAdm getUrbanizacion() {
        return urbanizacion;
    }

    public void setUrbanizacion(TablaLogicaAdm urbanizacion) {
        this.urbanizacion = urbanizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionResidencial)) {
            return false;
        }
        DireccionResidencial other = (DireccionResidencial) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administracion.models.DireccionResidencial[ idDireccion=" + idDireccion + " ]";
    }
    
}
