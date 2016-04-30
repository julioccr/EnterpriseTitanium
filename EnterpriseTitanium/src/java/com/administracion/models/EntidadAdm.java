/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "adm_entidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidad.findAll", query = "SELECT e FROM Entidad e"),
    @NamedQuery(name = "Entidad.findByIdEntidad", query = "SELECT e FROM Entidad e WHERE e.idEntidad = :idEntidad"),
    @NamedQuery(name = "Entidad.findByTipoEmpresa", query = "SELECT e FROM Entidad e WHERE e.tipoEmpresa = :tipoEmpresa"),
    @NamedQuery(name = "Entidad.findByDni", query = "SELECT e FROM Entidad e WHERE e.dni = :dni"),
    @NamedQuery(name = "Entidad.findByNombre", query = "SELECT e FROM Entidad e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Entidad.findByApellido", query = "SELECT e FROM Entidad e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Entidad.findBySenalUsuario", query = "SELECT e FROM Entidad e WHERE e.senalUsuario = :senalUsuario")})
public class EntidadAdm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entidad")
    private Integer idEntidad;
    @Column(name = "tipo_empresa")
    private Integer tipoEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Senal_Usuario")
    private Boolean senalUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntidad")
    private Collection<Telefonino> telefoninoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntidad")
    private Collection<DireccionElectronica> direccionElectronicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntidad")
    private Collection<DireccionResidencial> direccionResidencialCollection;
    @JoinColumn(name = "Ciudad", referencedColumnName = "id_codec")
    @ManyToOne
    private TablaLogicaAdm ciudad;
    @JoinColumn(name = "Genero", referencedColumnName = "id_codec")
    @ManyToOne
    private TablaLogicaAdm genero;
    @JoinColumn(name = "Nacionalidad", referencedColumnName = "id_codec")
    @ManyToOne
    private TablaLogicaAdm nacionalidad;
    @JoinColumn(name = "Tipo_identificacion", referencedColumnName = "id_codec")
    @ManyToOne(optional = false)
    private TablaLogicaAdm tipoidentificacion;

    public EntidadAdm() {
    }

    public EntidadAdm(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public EntidadAdm(Integer idEntidad, String dni, String nombre) {
        this.idEntidad = idEntidad;
        this.dni = dni;
        this.nombre = nombre;
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Integer getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(Integer tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Boolean getSenalUsuario() {
        return senalUsuario;
    }

    public void setSenalUsuario(Boolean senalUsuario) {
        this.senalUsuario = senalUsuario;
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
    public Collection<DireccionResidencial> getDireccionResidencialCollection() {
        return direccionResidencialCollection;
    }

    public void setDireccionResidencialCollection(Collection<DireccionResidencial> direccionResidencialCollection) {
        this.direccionResidencialCollection = direccionResidencialCollection;
    }

    public TablaLogicaAdm getCiudad() {
        return ciudad;
    }

    public void setCiudad(TablaLogicaAdm ciudad) {
        this.ciudad = ciudad;
    }

    public TablaLogicaAdm getGenero() {
        return genero;
    }

    public void setGenero(TablaLogicaAdm genero) {
        this.genero = genero;
    }

    public TablaLogicaAdm getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(TablaLogicaAdm nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public TablaLogicaAdm getTipoidentificacion() {
        return tipoidentificacion;
    }

    public void setTipoidentificacion(TablaLogicaAdm tipoidentificacion) {
        this.tipoidentificacion = tipoidentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidad != null ? idEntidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadAdm)) {
            return false;
        }
        EntidadAdm other = (EntidadAdm) object;
        if ((this.idEntidad == null && other.idEntidad != null) || (this.idEntidad != null && !this.idEntidad.equals(other.idEntidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administracion.models.Entidad[ idEntidad=" + idEntidad + " ]";
    }
    
}
