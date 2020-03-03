package modelAndView;

public class Caixa {
    public Caixa(int numero, String identificacaoEtiqueta, String cor) {
        this.numero = numero;
        this.identificacaoEtiqueta = identificacaoEtiqueta;
        this.cor = cor;
    }
    
    private int numero;
    private String identificacaoEtiqueta;
    private String cor;
    
    
    // GET and Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getIdentificacaoEtiqueta() {
        return identificacaoEtiqueta;
    }

    public void setIdentificacaoEtiqueta(String identificacaoEtiqueta) {
        this.identificacaoEtiqueta = identificacaoEtiqueta;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    //fim dos Get and Setters    
    
}
