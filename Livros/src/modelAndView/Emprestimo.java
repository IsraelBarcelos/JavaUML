package modelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Emprestimo {
    public Emprestimo(Date dataEmprestimo, Date dataDevolucao, Amigo amigo, Revista revista) {
        super();
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.amigo = amigo;
        this.revista = revista;
    }
    
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Amigo amigo;
    private Revista revista;
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
    
    public Revista getRevista() {
        return this.revista;
    }
    // Fim dos Getters and Setters    

    

    
    
    private Amigo getAmigo(ArrayList<Amigo> amigos, String nome) {
        for(Amigo amigo: amigos) {
            if(amigo.getNome().equals(nome)) {
                return amigo;
            }
        }
        System.out.println("Dado não encontrado!");
        return null;
    }
    
    public static void main(String[] args) {
        // Adicionando arraylists para iniciar o projeto
        ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
        ArrayList<Colecao> colecoes = new ArrayList<Colecao>();
        ArrayList<Amigo> amigos = new ArrayList<Amigo>(); 
        ArrayList<Revista> revistas = new ArrayList<Revista>();
        ArrayList<Caixa> caixas = new ArrayList<Caixa>();

        Scanner ler = new Scanner(System.in);        

        //starter de dados
        
        //add amigo
        System.out.println("Digite o nome do amigo ");
        String nomeDoAmigo = ler.nextLine();
      
        System.out.println("Digite o telefone do amigo ");
        String telefoneDoAmigo = ler.nextLine();
    
        System.out.println("Digite o local do amigo");
        String localAmigo = ler.nextLine();
     
        Amigo amigo = new Amigo(nomeDoAmigo, telefoneDoAmigo, localAmigo);
        amigos.add(amigo);
        
        //add revista
        System.out.println("Parece que não temos revistas disponíveis, vamos adicionar uma: ");
        System.out.println("Digite o numero da edição do livro: ");
        int numeroEdicao = Integer.parseInt(ler.nextLine());
        
        System.out.println("Digite o ano do livro: ");
        int anoDoLivro = Integer.parseInt(ler.nextLine());
        
        
        //add caixa para add revista
        System.out.println("Digite o formato da caixa a ser colocado o livro: ");
        System.out.println("Por favor digite o numero da caixa: ");
        int numeroDaCaixa = Integer.parseInt(ler.nextLine());
        
        System.out.println("Por favor digite a identificação de etiqueta:");
        String identificacaoEtiqueta = ler.nextLine();
       
        System.out.println("Digite a cor da caixa: ");
        String cor = ler.nextLine();
       
        Caixa caixa = new Caixa(numeroDaCaixa, identificacaoEtiqueta, cor);
        caixas.add(caixa);
        
        //add colecao para revista
        System.out.println("Digite o nome da coleção para este livro: ");
        String nomeColecao = ler.nextLine();
       
        Colecao colecao = new Colecao(nomeColecao);
        colecoes.add(colecao);
             
        Revista revista2 = new Revista(numeroEdicao, anoDoLivro, caixa, colecao );
        revistas.add(revista2);
        int escolha1 = 0;
        do{
            
            try {
                System.out.println("Olá novamente senhor João Messias, o que deseja fazer?\n\n"
                    + "(0) - Mostrar empréstimos ativos\n"
                    + "(1) - Adicionar novo empréstimo\n"
                    + "(2) - Recolher emprestimo\n"
                    + "(3) - Adicionar Revista\n"
                    + "(4) - Adicionar Caixa\n"
                    + "(5) - Adicionar Coleção\n"
                    + "(6) - Adicionar novo amigo\n"
                    + "(7) - SAIR");
                escolha1 = Integer.parseInt(ler.nextLine());
                
                switch(escolha1) {
                
                
                case 0:
                    if(emprestimos.isEmpty()){
                        System.out.println("Não há emprestimos no momento! \nDigite algo para continuar: ");
                        ler.next();
                    }else{
                         for(Emprestimo emprestimosDisponiveis: emprestimos) {

                            System.out.println("O senhor " + emprestimosDisponiveis.getAmigo().getNome() +
                                    " esta com a revista "+emprestimosDisponiveis.getRevista().getColecao().getNome()+ 
                                    " desde "+emprestimosDisponiveis.getDataEmprestimo()+
                                    " até "+emprestimosDisponiveis.getDataDevolucao()+ "");
                        }
                        System.out.println("Digite algo para continuar ");
                        ler.next();
                    }
                    break;
                case 1:          
                    
                    System.out.println("Qual o numero da revista você deseja emprestar?");
                    for(Revista revistaProcura : revistas) {
                        System.out.print(revistaProcura.getNumeroEdicao()+" - "+ revistaProcura.getColecao().nome+ " - ");
                        System.out.println(revistaProcura.getEstaEmprestada() ? "Emprestada " : "Liberada ");
                    }
                    
                    int opcao2 = Integer.parseInt(ler.nextLine());
                    
                    for(Revista revistaProcura : revistas) { // encontra a revista
                        if(opcao2 == revistaProcura.getNumeroEdicao() && revistaProcura.getEstaEmprestada() == false){
                            Revista revistaSelecionada = revistaProcura;
                            System.out.println("Selecione o nome do amigo: ");
                            for(Amigo amigoProcura : amigos ) {
                                System.out.print(amigoProcura.getNome() + " - " );
                                System.out.println((amigoProcura.getEmprestado()) ? "Já emprestado" : "Liberado");
                            }
                             // importante, pois o buffer buga
                            String opcaoNome = ler.nextLine();
                            
                            for(Amigo amigoProcura : amigos ) { //procura o amigo selecionado nos amigos
                                
                                if(amigoProcura.getNome().equals(opcaoNome) && amigoProcura.getEmprestado() == false) { // se achar o amigo
                                    
                                Amigo amigoSelecionado = amigoProcura;
                                
                                System.out.println("Digite o numero em dias a ser emprestados: ");
                                int dias = Integer.parseInt(ler.nextLine());
                                
                                Date dataHoje = new Date();
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(dataHoje);
                                cal.add(Calendar.DATE, dias);
                                
                                //impede que seja alugado o mesmo livro para mais de uma pessoa e também que a mesma pessoa alugue mais de 1 livro
                                revistaSelecionada.setEstaEmprestada(true);
                                amigoSelecionado.setEmprestado(true);
                                
                                Emprestimo emprestimo = new Emprestimo(dataHoje, cal.getTime(), amigoSelecionado, revistaSelecionada );
                                emprestimos.add(emprestimo);
                                
                                break;
                                
                                }
                            }
                        }   
                    }
                break;
                
                case 2:
                    
                    System.out.println("Selecione o amigo que deseja devolver o livro: ");
                    for(Emprestimo procuraEmprestimo : emprestimos) {
                        System.out.println(procuraEmprestimo.getAmigo().getNome()+ " - " + procuraEmprestimo.getRevista().getColecao().getNome());
                    }
                    String opcaoAmigo = ler.nextLine();
                    
                    //working with Iterator
                    
                    Iterator<Emprestimo> iterator = emprestimos.iterator();
                    
                    while(iterator.hasNext()) {
                        Emprestimo emprestimoDeletado = iterator.next();
                        if(emprestimoDeletado.getAmigo().getNome().equals(opcaoAmigo)) {
                            emprestimoDeletado.getAmigo().setEmprestado(false);
                            emprestimoDeletado.getRevista().setEstaEmprestada(false);
                            System.out.println("Emprestimo devolvido");
                            iterator.remove();
                        }
                        
                    }
                    /* LEGADO -> Tem problemas para usar em runtime
                    
                    for(Emprestimo emprestimoSelecionado : emprestimos) {
                        if(emprestimoSelecionado.getAmigo().getNome().equals(opcaoAmigo)) {
                            System.out.println("entrei");
                            emprestimoSelecionado.getAmigo().setEmprestado(false);
                            emprestimoSelecionado.getRevista().setEstaEmprestada(false);
                            System.out.println("Emprestimo devolvido");
                            
                            
                        }
                    }
                    */
                    break;
                    
                case 3:
                    System.out.println("Vamos iniciar o processo de adicionar uma revista:  Digite o numero da edição da revista adicionada");
                    numeroEdicao = Integer.parseInt(ler.nextLine());
                    
                    System.out.println("Digite o ano da revista: ");
                    anoDoLivro = Integer.parseInt(ler.nextLine());
                    
                    
                    System.out.println("Se você deseja adicionar uma nova coleção digite 0, senão digite o nome da colecao a que a revista pertence: ");
                    for(Colecao colecaoProcura: colecoes){
                        System.out.println(colecaoProcura.getNome() + "");
                    }
                    String opcaoColecao = ler.nextLine();
                    if(opcaoColecao.equals("0")){
                        
                        System.out.println("Agora adicione um nome para a coleção: ");
                        nomeColecao = ler.nextLine();
                        colecao = new Colecao(nomeColecao);
                        
                    }else { // caso tenha escrito o noem da colecao
                        int i =0;
                        for(Colecao colecaoSelecionada : colecoes ) {
                            if( colecaoSelecionada.getNome().equals(nomeColecao)) {
                                colecao = colecaoSelecionada;
                                i=1;
                            }
                        }
                        if(i==0){
                            System.out.println("Colecao não encontrada, reiniciar.");
                            break;
                        }
                                           
                    }
                    System.out.println("Digite o numero da caixa que deseja inserir o livro, caso queira adicionar uma nova digite 0");
                    for(Caixa caixaSelecionada : caixas) {
                            System.out.println(caixaSelecionada.getNumero() + " - " + caixaSelecionada.getIdentificacaoEtiqueta());
                        }
                    
                    int opcaoCaixa = Integer.parseInt(ler.nextLine());
                    
                    if(opcaoCaixa == 0){
                        System.out.println("Por favor digite o numero da caixa: ");
                        numeroDaCaixa = Integer.parseInt(ler.nextLine());
                        
                        System.out.println("Por favor digite a identificação de etiqueta: ");
                        identificacaoEtiqueta = ler.nextLine();
                        
                        System.out.println("Digite a cor da caixa: ");
                        cor = ler.nextLine();

                        caixa = new Caixa(numeroDaCaixa, identificacaoEtiqueta, cor);
                        caixas.add(caixa);
                        
                        
                        
                        Revista revista = new Revista(numeroEdicao, anoDoLivro, caixa, colecao );
                        revistas.add(revista);
                    }else{ // nao vai criar novo
                        for(Caixa caixaSelecionada : caixas) {
                            if(caixaSelecionada.getNumero() == opcaoCaixa ) {
                                Revista revista = new Revista(numeroEdicao, anoDoLivro, caixaSelecionada, colecao );
                                revistas.add(revista);
                            }
                        }
                    }
   
                    break;
                case 4:
                    
                    System.out.println("Por favor digite o numero da caixa: ");
                       numeroDaCaixa = Integer.parseInt(ler.nextLine());
                     
                       System.out.println("Por favor digite a identificação de etiqueta: ");
                       identificacaoEtiqueta = ler.nextLine();

                       System.out.println("Digite a cor da caixa: ");
                       cor = ler.nextLine();

                       caixa = new Caixa(numeroDaCaixa, identificacaoEtiqueta, cor);
                       caixas.add(caixa);
                    
                    break;
                
                case 5:
                    System.out.println("Agora adicione um nome para a coleção: ");
                    nomeColecao = ler.nextLine();
                    colecao = new Colecao(nomeColecao);
                    break;
                    
                case 6:
                    System.out.println("Digite o nome do amigo ");
                    nomeDoAmigo = ler.nextLine();

                    System.out.println("Digite o telefone do amigo ");
                    telefoneDoAmigo = ler.nextLine();

                    System.out.println("Digite o local do amigo");
                    localAmigo = ler.nextLine();

                    Amigo amigo2 = new Amigo(nomeDoAmigo, telefoneDoAmigo, localAmigo);
                    
                    amigos.add(amigo2);
                    break;
                
                case 7:
                    break;
                default:
                    System.out.println("Não há está opção, tente novamente: ");
                
            }
            }catch(NumberFormatException e) {
                e.printStackTrace();
            }
            
        }while(escolha1 != 7);
    }
    
}
