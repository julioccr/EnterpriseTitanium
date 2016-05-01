/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.schedule.models;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
public class EntidadComp implements Serializable {
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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idEntidad")
    private CuentaUsuarioComp cuentaUsuario;
    @JoinColumn(name = "Ciudad", referencedColumnName = "id_codec")
    @ManyToOne
    private TablaLogicaComp ciudad;
    @JoinColumn(name = "Genero", referencedColumnName = "id_codec")
    @ManyToOne
    private TablaLogicaComp genero;
    @JoinColumn(name = "Nacionalidad", referencedColumnName = "id_codec")
    @ManyToOne
    private TablaLogicaComp nacionalidad;
    @JoinColumn(name = "Tipo_identificacion", referencedColumnName = "id_codec")
    @ManyToOne(optional = false)
    private TablaLogicaComp tipoidentificacion;

    public EntidadComp() {
    }

    public EntidadComp(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public EntidadComp(Integer idEntidad, String dni, String nombre) {
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

    public CuentaUsuarioComp getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(CuentaUsuarioComp cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }

    public TablaLogicaComp getCiudad() {
        return ciudad;
    }

    public void setCiudad(TablaLogicaComp ciudad) {
        this.ciudad = ciudad;
    }

    public TablaLogicaComp getGenero() {
        return genero;
    }

    public void setGenero(TablaLogicaComp genero) {
        this.genero = genero;
    }

    public TablaLogicaComp getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(TablaLogicaComp nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public TablaLogicaComp getTipoidentificacion() {
        return tipoidentificacion;
    }

    public void setTipoidentificacion(TablaLogicaComp tipoidentificacion) {
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
        if (!(object instanceof EntidadComp)) {
            return false;
        }
        EntidadComp other = (EntidadComp) object;
        if ((this.idEntidad == null && other.idEntidad != null) || (this.idEntidad != null && !this.idEntidad.equals(other.idEntidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modules.models.Entidad[ idEntidad=" + idEntidad + " ]";
    }
    
}
