package modelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Emprestimo {
    public Emprestimo(Date dataEmprestimo, Date dataDevolucao, Amigo amigo) {
        super();
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.amigo = amigo;
    }
    
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Amigo amigo;

    // Inicio dos Getters and Setters
    
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    public Amigo getAmigo() {
        return this.amigo;
    }
    
    // Fim dos Getters and Setters    
    
        public static void main(String[] args) {
        
        ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
        ArrayList<Colecao> colecoes = new ArrayList<Colecao>();
        ArrayList<Amigo> amigos = new ArrayList<Amigo>(); 
        ArrayList<Revista> revistas = new ArrayList<Revista>();
        ArrayList<Caixa> caixas = new ArrayList<Caixa>();
        
        Scanner ler = new Scanner(System.in);        
        
        do{
            System.out.println("Olá novamente senhor João Messias, o que deseja fazer?\n\n"
                    + "(1) - Adicionar novo empréstimo\n"
                    + "(2) - Recolher emprestimo\n"
                    + "(5) - Adicionar novo amigo\n"
                    + "(6) - SAIR");
            int escolha1 = ler.nextInt();


            switch(escolha1) {
                case 1:
                    
                    if(amigos.isEmpty()) {
                        System.out.println("Digite o nome do amigo \n");
                        String nomeDoAmigo = ler.nextLine();
                        System.out.println("Digite o telefone do amigo \n");
                        String telefoneDoAmigo = ler.nextLine();
                        System.out.println("Digite o local do amigo\n");
                        String localAmigo = ler.nextLine();
                        Amigo padrao = new Amigo(nomeDoAmigo, telefoneDoAmigo, localAmigo);
                        amigos.add(padrao);
                        
                        if(revistas.isEmpty()){
                            
                            System.out.println("Parece que não temos revistas disponíveis, vamos adicionar uma: \n");
                            ler.next();
                            System.out.println("Digite o numero da edição do livro: \n");
                            int numeroEdicao = ler.nextInt();
                            System.out.println("Digite o ano do livro: \n");
                            int anoDoLivro = ler.nextInt();
                            System.out.println("Digite o formato da caixa a ser colocado o livro: \n");
                            
                            
                            
                            if(colecoes.isEmpty()){
                                System.out.println("Também precisamos adicionar uma coleção para este livro: \n");
                                String nomeColecao = ler.nextLine();
                                ler.next();
                                Colecao colecao = new Colecao(nomeColecao);
                                colecoes.add(colecao);
                                
                                if(caixas.isEmpty()){
                                    System.out.println("Por favor digite o numero da caixa: \n");
                                    int numeroDaCaixa = ler.nextInt();
                                    System.out.println("Por favor digite a identificação de etiqueta: \n");
                                    String identificacaoEtiqueta = ler.nextLine();
                                    System.out.println("Digite a cor da caixa: \n");
                                    String cor = ler.nextLine();
                                    Caixa caixa = new Caixa(numeroDaCaixa, identificacaoEtiqueta, cor);
                                    caixas.add(caixa);
                                    Revista revista = new Revista(numeroEdicao, anoDoLivro, caixa, colecao );
                                    revistas.add(revista);
                                }else{ // escolhe a caixa com for
                                    System.out.println("Digite o numero da caixa\n");
                                    int numeroDaCaixa = ler.nextInt();
                                    
                                    for(Caixa caixinha : caixas) {
                                        if( numeroDaCaixa == caixinha.getNumero()) {
                                            Revista revista = new Revista(numeroEdicao, anoDoLivro, caixinha, colecao);
                                            revistas.add(revista);
                                        }else{
                                            System.out.println("Um numero digitado está incorreto, resete");
                                            System.exit(0);
                                        }
                                    }
                                }
                            }else{ // escolhe a coleção com for
                                System.out.println("Digite o nome da coleção: \n");
                                String nomeDaColecao = ler.nextLine();
                                ler.next();
                                
                                System.out.println("Digite o numero da caixa\n");
                                    int numeroDaCaixa = ler.nextInt();
                                    
                                    for(Caixa caixinha : caixas) {
                                        if( numeroDaCaixa == caixinha.getNumero()) {
                                            Caixa caixa = caixinha;
                                        }
                                    }
                                
                                for(Colecao colecaozinha : colecoes){
                                    if(nomeDaColecao.equals(colecaozinha.getNome())) {
                                        Revista revista = new Revista(numeroEdicao, anoDoLivro, caixa, colecaozinha);
                                    }
                                }
                                
                                
                            }
                            
                        }else{ // escolhe a revista com for
                            
                        }
                        
                        System.out.println("Digite o numero em dias a ser colocados: ");
                        int dias = ler.nextInt();
                        Date dataHoje = new Date();
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(dataHoje);
                        cal.add(Calendar.DATE, dias);
                        
                        Emprestimo emprestimo = new Emprestimo(dataHoje, cal.getTime(), padrao );
                        emprestimos.add(emprestimo);
                    }else{  // escolhe o amigo com for
                        
                    }
                    
                    
                    
                    break;
            }

        }while(ler.equals(6));
    }
    
}
