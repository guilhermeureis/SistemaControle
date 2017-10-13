package model;

import java.sql.Date;
import java.util.Objects;

public class Cliente { private Integer codigo;
  private String nome;
  private String cpf;
  private String sexo;
  private Date dataNascimento;
  private String fone;
  
  public Cliente() {}
  
  public Integer getCodigo() { return codigo; }
  
  public void setCodigo(Integer codigo)
  {
    this.codigo = codigo;
  }
  
  public String getNome() {
    return nome;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public String getCpf() {
    return cpf;
  }
  
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  
  public String getSexo() {
    return sexo;
  }
  
  public void setSexo(String sexo) {
    this.sexo = sexo;
  }
  
  public Date getDataNascimento() {
    return dataNascimento;
  }
  
  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }
  
  public String getFone() {
    return fone;
  }
  
  public void setFone(String fone) {
    this.fone = fone;
  }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        return true;
    }
  
}