/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

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
 * @author Administrator
 */
@Entity
@Table(name = "wardtb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wardtb.findAll", query = "SELECT w FROM Wardtb w"),
    @NamedQuery(name = "Wardtb.findByWardId", query = "SELECT w FROM Wardtb w WHERE w.wardId = :wardId"),
    @NamedQuery(name = "Wardtb.findByWardName", query = "SELECT w FROM Wardtb w WHERE w.wardName = :wardName")})
public class Wardtb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ward_id")
    private Integer wardId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ward_name")
    private String wardName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wardId")
    private Collection<QuestionWard> questionWardCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wardId")
    private Collection<UserAnswer> userAnswerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wardId")
    private Collection<Usertb> usertbCollection;
    @JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
    @ManyToOne(optional = false)
    private Zonetb zoneId;

    public Wardtb() {
    }

    public Wardtb(Integer wardId) {
        this.wardId = wardId;
    }

    public Wardtb(Integer wardId, String wardName) {
        this.wardId = wardId;
        this.wardName = wardName;
    }

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    @XmlTransient
    public Collection<QuestionWard> getQuestionWardCollection() {
        return questionWardCollection;
    }

    public void setQuestionWardCollection(Collection<QuestionWard> questionWardCollection) {
        this.questionWardCollection = questionWardCollection;
    }

    @XmlTransient
    public Collection<UserAnswer> getUserAnswerCollection() {
        return userAnswerCollection;
    }

    public void setUserAnswerCollection(Collection<UserAnswer> userAnswerCollection) {
        this.userAnswerCollection = userAnswerCollection;
    }

    @XmlTransient
    public Collection<Usertb> getUsertbCollection() {
        return usertbCollection;
    }

    public void setUsertbCollection(Collection<Usertb> usertbCollection) {
        this.usertbCollection = usertbCollection;
    }

    public Zonetb getZoneId() {
        return zoneId;
    }

    public void setZoneId(Zonetb zoneId) {
        this.zoneId = zoneId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wardId != null ? wardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wardtb)) {
            return false;
        }
        Wardtb other = (Wardtb) object;
        if ((this.wardId == null && other.wardId != null) || (this.wardId != null && !this.wardId.equals(other.wardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Wardtb[ wardId=" + wardId + " ]";
    }
    
}
