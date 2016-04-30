/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.models;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julio Cortorreal
 */
@Entity
@Table(name = "seg_politicas_acceso_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoliticasAccesoGrupo.findAll", query = "SELECT p FROM PoliticasAccesoGrupo p"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByIdPoliticasAcceso", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.idPoliticasAcceso = :idPoliticasAcceso"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByRegistro", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.registro = :registro"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByActualizar", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.actualizar = :actualizar"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByEliminar", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.eliminar = :eliminar"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByVerDetalles", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.verDetalles = :verDetalles"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByFechaPoderInicio", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.fechaPoderInicio = :fechaPoderInicio"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByFechaPoderFin", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.fechaPoderFin = :fechaPoderFin"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByDLunes", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.dLunes = :dLunes"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByDMartes", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.dMartes = :dMartes"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByDMiercoles", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.dMiercoles = :dMiercoles"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByDJueves", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.dJueves = :dJueves"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByDViernes", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.dViernes = :dViernes"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByDSabado", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.dSabado = :dSabado"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByDDomingo", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.dDomingo = :dDomingo"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByHoraInicio", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.horaInicio = :horaInicio"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByHoraFin", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.horaFin = :horaFin"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByFechaRegistro", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "PoliticasAccesoGrupo.findByEstadoPoder", query = "SELECT p FROM PoliticasAccesoGrupo p WHERE p.estadoPoder = :estadoPoder")})
public class PoliticasAccesoGrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Politicas_Acceso")
    private Integer idPoliticasAcceso;
    @Size(max = 10)
    @Column(name = "Registro")
    private String registro;
    @Size(max = 10)
    @Column(name = "Actualizar")
    private String actualizar;
    @Size(max = 10)
    @Column(name = "Eliminar")
    private String eliminar;
    @Size(max = 10)
    @Column(name = "VerDetalles")
    private String verDetalles;
    @Column(name = "fecha_poder_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPoderInicio;
    @Column(name = "fecha_poder_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPoderFin;
    @Size(max = 1)
    @Column(name = "d_lunes")
    private String dLunes;
    @Size(max = 1)
    @Column(name = "d_martes")
    private String dMartes;
    @Size(max = 1)
    @Column(name = "d_miercoles")
    private String dMiercoles;
    @Size(max = 1)
    @Column(name = "d_jueves")
    private String dJueves;
    @Size(max = 1)
    @Column(name = "d_viernes")
    private String dViernes;
    @Size(max = 1)
    @Column(name = "d_sabado")
    private String dSabado;
    @Size(max = 1)
    @Column(name = "d_domingo")
    private String dDomingo;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 45)
    @Column(name = "estado_poder")
    private String estadoPoder;
    @JoinColumn(name = "Id_Grupo", referencedColumnName = "idSeg_Directiva_Grupo")
    @ManyToOne(optional = false)
    private DirectivaGrupo idGrupo;
    @JoinColumn(name = "id_transaccion", referencedColumnName = "Id_Transaccion")
    @ManyToOne
    private Transaccion idTransaccion;

    public PoliticasAccesoGrupo() {
    }

    public PoliticasAccesoGrupo(Integer idPoliticasAcceso) {
        this.idPoliticasAcceso = idPoliticasAcceso;
    }

    public Integer getIdPoliticasAcceso() {
        return idPoliticasAcceso;
    }

    public void setIdPoliticasAcceso(Integer idPoliticasAcceso) {
        this.idPoliticasAcceso = idPoliticasAcceso;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getActualizar() {
        return actualizar;
    }

    public void setActualizar(String actualizar) {
        this.actualizar = actualizar;
    }

    public String getEliminar() {
        return eliminar;
    }

    public void setEliminar(String eliminar) {
        this.eliminar = eliminar;
    }

    public String getVerDetalles() {
        return verDetalles;
    }

    public void setVerDetalles(String verDetalles) {
        this.verDetalles = verDetalles;
    }

    public Date getFechaPoderInicio() {
        return fechaPoderInicio;
    }

    public void setFechaPoderInicio(Date fechaPoderInicio) {
        this.fechaPoderInicio = fechaPoderInicio;
    }

    public Date getFechaPoderFin() {
        return fechaPoderFin;
    }

    public void setFechaPoderFin(Date fechaPoderFin) {
        this.fechaPoderFin = fechaPoderFin;
    }

    public String getDLunes() {
        return dLunes;
    }

    public void setDLunes(String dLunes) {
        this.dLunes = dLunes;
    }

    public String getDMartes() {
        return dMartes;
    }

    public void setDMartes(String dMartes) {
        this.dMartes = dMartes;
    }

    public String getDMiercoles() {
        return dMiercoles;
    }

    public void setDMiercoles(String dMiercoles) {
        this.dMiercoles = dMiercoles;
    }

    public String getDJueves() {
        return dJueves;
    }

    public void setDJueves(String dJueves) {
        this.dJueves = dJueves;
    }

    public String getDViernes() {
        return dViernes;
    }

    public void setDViernes(String dViernes) {
        this.dViernes = dViernes;
    }

    public String getDSabado() {
        return dSabado;
    }

    public void setDSabado(String dSabado) {
        this.dSabado = dSabado;
    }

    public String getDDomingo() {
        return dDomingo;
    }

    public void setDDomingo(String dDomingo) {
        this.dDomingo = dDomingo;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstadoPoder() {
        return estadoPoder;
    }

    public void setEstadoPoder(String estadoPoder) {
        this.estadoPoder = estadoPoder;
    }

    public DirectivaGrupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(DirectivaGrupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Transaccion getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Transaccion idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoliticasAcceso != null ? idPoliticasAcceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoliticasAccesoGrupo)) {
            return false;
        }
        PoliticasAccesoGrupo other = (PoliticasAccesoGrupo) object;
        if ((this.idPoliticasAcceso == null && other.idPoliticasAcceso != null) || (this.idPoliticasAcceso != null && !this.idPoliticasAcceso.equals(other.idPoliticasAcceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.security.models.PoliticasAccesoGrupo[ idPoliticasAcceso=" + idPoliticasAcceso + " ]";
    }
    
}
