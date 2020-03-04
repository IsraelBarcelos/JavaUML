package modelAndView;

public class Amigo { 
    public Amigo(String nome, String telefone, String localAmigo) {
        this.nome = nome;
        this.telefone = telefone;
        this.localAmigo = localAmigo;
        this.emprestado = false;
    }
    private String nome;
    private String telefone;
    private String localAmigo;
    private boolean emprestado;
        
    // Getters and Setters
    public String getNome() {
        return this.nome;
    }
    public String getTelefone() {
        return this.telefone;
    }
    public String getLocalAmigo() {
        return this.localAmigo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.nome = telefone;
    }
    public void setAocalAmigo(String localAmigo) {
        this.nome = localAmigo;
    }
    
    public boolean getEmprestado() {
        return this.emprestado;
    }
    
    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
    
    // Fim dos Getters and Setters
}
