package modelAndView;

public class Revista {

    public Revista(int numeroEdicao, int ano, Caixa caixa, Colecao colecao) {
        this.numeroEdicao = numeroEdicao;
        this.ano = ano;
        this.caixa = caixa;
        this.colecao = colecao;
        this.estaEmprestada = false;
    }
    
    private int numeroEdicao;
    private int ano;
    private Caixa caixa;
    private Colecao colecao;
    private boolean estaEmprestada;
    
    // Getters and setters
    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Caixa getCaixa() {
        return caixa;
    }
    
    public Colecao getColecao() {
        return this.colecao;
    }
    
    public boolean getEstaEmprestada() {
        return this.estaEmprestada;
    }
    
    public void setEstaEmprestada(boolean estaEmprestada) {
        this.estaEmprestada = estaEmprestada;
    }
    // Fim dos Getters and Setters   
}
