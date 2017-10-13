package util;

public enum OperacoesCrud {
  NOVO(Integer.valueOf(1)),  EDITAR(Integer.valueOf(2)),  EXCLUIR(Integer.valueOf(3));
  
  private final Integer operacao;
  
  private OperacoesCrud(Integer operacao) {
    this.operacao = operacao;
  }
  
  public Integer getOperacao() {
    return operacao;
  }
}