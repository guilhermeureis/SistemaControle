/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")
    , @NamedQuery(name = "Login.findByIdLogin", query = "SELECT l FROM Login l WHERE l.idLogin = :idLogin")
    , @NamedQuery(name = "Login.findByLogNome", query = "SELECT l FROM Login l WHERE l.logNome = :logNome")
    , @NamedQuery(name = "Login.findByLogSenha", query = "SELECT l FROM Login l WHERE l.logSenha = :logSenha")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdLogin")
    private Integer idLogin;
    @Basic(optional = false)
    @Column(name = "logNome")
    private String logNome;
    @Basic(optional = false)
    @Column(name = "logSenha")
    private String logSenha;

    public Login() {
    }

    public Login(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public Login(Integer idLogin, String logNome, String logSenha) {
        this.idLogin = idLogin;
        this.logNome = logNome;
        this.logSenha = logSenha;
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public String getLogNome() {
        return logNome;
    }

    public void setLogNome(String logNome) {
        this.logNome = logNome;
    }

    public String getLogSenha() {
        return logSenha;
    }

    public void setLogSenha(String logSenha) {
        this.logSenha = logSenha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogin != null ? idLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.idLogin == null && other.idLogin != null) || (this.idLogin != null && !this.idLogin.equals(other.idLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Login[ idLogin=" + idLogin + " ]";
    }
    
}
