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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julio Cortorreal
 */
@Entity
@Table(name = "seg_acceso_device")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlAccesoDispositivos.findAll", query = "SELECT c FROM ControlAccesoDispositivos c"),
    @NamedQuery(name = "ControlAccesoDispositivos.findByIdSegAccesoDevice", query = "SELECT c FROM ControlAccesoDispositivos c WHERE c.idSegAccesoDevice = :idSegAccesoDevice"),
    @NamedQuery(name = "ControlAccesoDispositivos.findByDeviceName", query = "SELECT c FROM ControlAccesoDispositivos c WHERE c.deviceName = :deviceName"),
    @NamedQuery(name = "ControlAccesoDispositivos.findByDeviceOS", query = "SELECT c FROM ControlAccesoDispositivos c WHERE c.deviceOS = :deviceOS"),
    @NamedQuery(name = "ControlAccesoDispositivos.findByDeviceIp", query = "SELECT c FROM ControlAccesoDispositivos c WHERE c.deviceIp = :deviceIp"),
    @NamedQuery(name = "ControlAccesoDispositivos.findByDeviceCode", query = "SELECT c FROM ControlAccesoDispositivos c WHERE c.deviceCode = :deviceCode"),
    @NamedQuery(name = "ControlAccesoDispositivos.findByDeviceEstado", query = "SELECT c FROM ControlAccesoDispositivos c WHERE c.deviceEstado = :deviceEstado")})
public class ControlAccesoDispositivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSeg_Acceso_Device")
    private Integer idSegAccesoDevice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Device_Name")
    private String deviceName;
    @Size(max = 45)
    @Column(name = "Device_OS")
    private String deviceOS;
    @Size(max = 45)
    @Column(name = "Device_Ip")
    private String deviceIp;
    @Column(name = "Device_Code")
    private Integer deviceCode;
    @Size(max = 45)
    @Column(name = "Device_Estado")
    private String deviceEstado;
    @JoinColumn(name = "Seg_Cuenta_Cuenta_Id", referencedColumnName = "Cuenta_Id")
    @ManyToOne(optional = false)
    private CuentaUsuario segCuentaCuentaId;
    @JoinColumn(name = "Device_Type", referencedColumnName = "id_codec")
    @ManyToOne
    private TablaLogica deviceType;

    public ControlAccesoDispositivos() {
    }

    public ControlAccesoDispositivos(Integer idSegAccesoDevice) {
        this.idSegAccesoDevice = idSegAccesoDevice;
    }

    public ControlAccesoDispositivos(Integer idSegAccesoDevice, String deviceName) {
        this.idSegAccesoDevice = idSegAccesoDevice;
        this.deviceName = deviceName;
    }

    public Integer getIdSegAccesoDevice() {
        return idSegAccesoDevice;
    }

    public void setIdSegAccesoDevice(Integer idSegAccesoDevice) {
        this.idSegAccesoDevice = idSegAccesoDevice;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceOS() {
        return deviceOS;
    }

    public void setDeviceOS(String deviceOS) {
        this.deviceOS = deviceOS;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public Integer getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(Integer deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceEstado() {
        return deviceEstado;
    }

    public void setDeviceEstado(String deviceEstado) {
        this.deviceEstado = deviceEstado;
    }

    public CuentaUsuario getSegCuentaCuentaId() {
        return segCuentaCuentaId;
    }

    public void setSegCuentaCuentaId(CuentaUsuario segCuentaCuentaId) {
        this.segCuentaCuentaId = segCuentaCuentaId;
    }

    public TablaLogica getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(TablaLogica deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSegAccesoDevice != null ? idSegAccesoDevice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlAccesoDispositivos)) {
            return false;
        }
        ControlAccesoDispositivos other = (ControlAccesoDispositivos) object;
        if ((this.idSegAccesoDevice == null && other.idSegAccesoDevice != null) || (this.idSegAccesoDevice != null && !this.idSegAccesoDevice.equals(other.idSegAccesoDevice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.security.models.ControlAccesoDispositivos[ idSegAccesoDevice=" + idSegAccesoDevice + " ]";
    }
    
}
