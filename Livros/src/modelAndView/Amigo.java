package modelAndView;

public class Amigo { 
    public Amigo(String nome, String telefone, String localAmigo) {
        this.nome = nome;
        this.telefone = telefone;
        this.localAmigo = localAmigo;
    }
    private String nome;
    private String telefone;
    private String localAmigo;
        
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
    
    // Fim dos Getters and Setters
}
