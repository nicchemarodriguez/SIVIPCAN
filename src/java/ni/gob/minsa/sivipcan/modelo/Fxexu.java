/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ni.gob.minsa.sivipcan.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author WIN 7
 */
@Entity
@Table(name = "FXEXU", catalog = "", schema = "SIVIPCAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fxexu.findAll", query = "SELECT f FROM Fxexu f"),
    @NamedQuery(name = "Fxexu.findByIdExamen", query = "SELECT f FROM Fxexu f WHERE f.fxexuPK.idExamen = :idExamen"),
    @NamedQuery(name = "Fxexu.findByIdFecha", query = "SELECT f FROM Fxexu f WHERE f.fxexuPK.idFecha = :idFecha"),
    @NamedQuery(name = "Fxexu.findByValor", query = "SELECT f FROM Fxexu f WHERE f.valor = :valor"),
     @NamedQuery(name = "Fxexu.findByValorXfechaMeustra", query = "SELECT f FROM Fxexu f WHERE f.valor Between :valor1 AND :valor2 "
            + " AND f.fxexuPK.idFecha = :idFecha"),
    @NamedQuery(name = "Fxexu.findByCodigoSanitario", query = "SELECT f FROM Fxexu f WHERE f.medicoId = :medicoId"),
    @NamedQuery(name = "Fxexu.findByIdUsuario", query = "SELECT f FROM Fxexu f WHERE f.idUsuario = :idUsuario")})
public class Fxexu implements Serializable {

//    @ManyToOne
//    @JoinColumn(name = "CATALOGO_ID")
    @Column(name = "TIPO_SEGUIMIENTO")
    private Long tipoSeguimiento;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FxexuPK fxexuPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date valor;
    @JoinColumn(name = "MEDICO_ID", referencedColumnName = "MEDICO_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SisMedicos medicoId;
    @Size(max = 15)
    @Column(name = "ID_USUARIO", length = 15)
    private String idUsuario;
    @JoinColumn(name = "ID_FECHA", referencedColumnName = "ID_FECHA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Fecha fecha;
    @JoinColumn(name = "ID_EXAMEN", referencedColumnName = "ID_EXAMEN", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Examen examen;

    public Fxexu() {
    }

    public Fxexu(FxexuPK fxexuPK) {
        this.fxexuPK = fxexuPK;
    }

    public Fxexu(FxexuPK fxexuPK, Date valor, SisMedicos medicoId) {
        this.fxexuPK = fxexuPK;
        this.valor = valor;
        this.medicoId = medicoId;
    }

   

    public Fxexu(long idExamen, long idFecha) {
        this.fxexuPK = new FxexuPK(idExamen, idFecha);
    }

    public FxexuPK getFxexuPK() {
        return fxexuPK;
    }

    public void setFxexuPK(FxexuPK fxexuPK) {
        this.fxexuPK = fxexuPK;
    }

    public Date getValor() {
        return valor;
    }

    public void setValor(Date valor) {
        this.valor = valor;
    }

    public SisMedicos getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(SisMedicos medicoId) {
        this.medicoId = medicoId;
    }

   

   

   

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fxexuPK != null ? fxexuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fxexu)) {
            return false;
        }
        Fxexu other = (Fxexu) object;
        if ((this.fxexuPK == null && other.fxexuPK != null) || (this.fxexuPK != null && !this.fxexuPK.equals(other.fxexuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.gob.minsa.sivipcan.modelo.Fxexu[ fxexuPK=" + fxexuPK + " ]";
    }

    public Long getTipoSeguimiento() {
        return tipoSeguimiento;
    }

    public void setTipoSeguimiento(Long tipoSeguimiento) {
        this.tipoSeguimiento = tipoSeguimiento;
    }

   
}
