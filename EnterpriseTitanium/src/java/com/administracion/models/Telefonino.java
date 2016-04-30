/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.models;

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
@Table(name = "adm_direccion_telefonica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefonino.findAll", query = "SELECT t FROM Telefonino t"),
    @NamedQuery(name = "Telefonino.findByIdDireccionTelefonica", query = "SELECT t FROM Telefonino t WHERE t.idDireccionTelefonica = :idDireccionTelefonica"),
    @NamedQuery(name = "Telefonino.findByCodigoPais", query = "SELECT t FROM Telefonino t WHERE t.codigoPais = :codigoPais"),
    @NamedQuery(name = "Telefonino.findByNumTelefonico", query = "SELECT t FROM Telefonino t WHERE t.numTelefonico = :numTelefonico"),
    @NamedQuery(name = "Telefonino.findByEstadoTele", query = "SELECT t FROM Telefonino t WHERE t.estadoTele = :estadoTele")})
public class Telefonino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDireccion_Telefonica")
    private Integer idDireccionTelefonica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_pais")
    private int codigoPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "num_telefonico")
    private String numTelefonico;
    @Size(max = 45)
    @Column(name = "estado_tele")
    private String estadoTele;
    @JoinColumn(name = "id_entidad", referencedColumnName = "id_entidad")
    @ManyToOne(optional = false)
    private EntidadAdm idEntidad;
    @JoinColumn(name = "Lugar", referencedColumnName = "id_codec")
    @ManyToOne(optional = false)
    private TablaLogicaAdm lugar;

    public Telefonino() {
    }

    public Telefonino(Integer idDireccionTelefonica) {
        this.idDireccionTelefonica = idDireccionTelefonica;
    }

    public Telefonino(Integer idDireccionTelefonica, int codigoPais, String numTelefonico) {
        this.idDireccionTelefonica = idDireccionTelefonica;
        this.codigoPais = codigoPais;
        this.numTelefonico = numTelefonico;
    }

    public Integer getIdDireccionTelefonica() {
        return idDireccionTelefonica;
    }

    public void setIdDireccionTelefonica(Integer idDireccionTelefonica) {
        this.idDireccionTelefonica = idDireccionTelefonica;
    }

    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNumTelefonico() {
        return numTelefonico;
    }

    public void setNumTelefonico(String numTelefonico) {
        this.numTelefonico = numTelefonico;
    }

    public String getEstadoTele() {
        return estadoTele;
    }

    public void setEstadoTele(String estadoTele) {
        this.estadoTele = estadoTele;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccionTelefonica != null ? idDireccionTelefonica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefonino)) {
            return false;
        }
        Telefonino other = (Telefonino) object;
        if ((this.idDireccionTelefonica == null && other.idDireccionTelefonica != null) || (this.idDireccionTelefonica != null && !this.idDireccionTelefonica.equals(other.idDireccionTelefonica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.administracion.models.Telefonino[ idDireccionTelefonica=" + idDireccionTelefonica + " ]";
    }
    
}
