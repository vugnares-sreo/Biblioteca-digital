import java.util.*;

public class Main{
    public static void main(String[] args) {

        int id = 2;
        Biblioteca biblioteca = new Biblioteca();
        Scanner S = new Scanner(System.in);

        biblioteca.addLivro(new Livro("Um conto de Natal", "Charles Dickens", 978042, 5));
        biblioteca.addLivro(new Livro("O Capital", "Karl Marx", 978332, 6));
        biblioteca.addLeitor(new Leitor("Endrel", 0));
        biblioteca.addLeitor(new Leitor("Antonio", 1));
        

        while(true){

            System.out.println("\nSelecione a opcao desejada:");
            System.out.println("1 - Alugar um Livro;");
            System.out.println("2 - Devolver um Livro;");
            System.out.println("3 - Exibir catalogo;");
            System.out.println("4 - Gerar Relatórios;\n");

            int a = S.nextInt();

            if (a == 1){
                S.nextLine(); // Consumir a quebra de linha pendente do nextInt()
                
                System.out.println("Escreva seu nome:");
                String leitorAblible = S.nextLine(); 
                
                Leitor leitor = biblioteca.pesquisarLeitor(leitorAblible);

                if (leitor != null){
                    
                    System.out.println("\nBem vindo " + leitorAblible + "! Escreva o título que deseja alugar:\n");
                    String livroAblible = S.nextLine();
                    Livro livro = biblioteca.pesquisarLivro(livroAblible);

                    if(livro != null){
                        leitor.emprestarLivro(livro);
                    }

                    else{
                        System.out.println("\nLivro não encontrado!");
                    }
                }

                else {
                    System.out.println("\nUsuário não encontrado. Cadastrando...\n");

                    leitor = new Leitor(leitorAblible, id); //Cria o ze
                    biblioteca.addLeitor(leitor);
                    id++;

                    System.out.println("Bem vindo " + leitorAblible + "! Escreva o título que deseja alugar:");
                    String livroAblible = S.nextLine();
                    Livro livro = biblioteca.pesquisarLivro(livroAblible);

                    if(livro != null){
                        leitor.emprestarLivro(livro);
                    }
                    else{
                        System.out.println("Livro não encontrado!");
                    }
                }
            }

            //Acaba o 1 aqui

            else if (a == 2){
                S.nextLine();
                System.out.println("\nEscreva seu nome:");
                String leitorAblible = S.nextLine(); //estou curingando JSKFNANDFUOASP
                Leitor leitor = biblioteca.pesquisarLeitor(leitorAblible);

                if (leitor != null) {
                    leitor.devolverLivro();
                    System.out.println("\nDevolução realizada com sucesso!");
                }
                else{
                    System.out.println("\nUsuario nao encontrado!");
                }
            }

            //O 2 é bem menor do que eu imaginava...

            else if(a == 3){
                System.out.println("Catálogo de Livros:");
                for (Livro livro : biblioteca.getLivros()) {
                    System.out.println(livro);
                }

                System.out.println("Lista de Leitores:");
                for (Leitor leitor : biblioteca.getLeitores()) {
                    System.out.println(leitor);  
                
                }
            }

            else if (a == 4) {
                biblioteca.gerarRelatorioLivrosEmprestados();
                biblioteca.gerarRelatorioUsuariosAtivos(); //Negocio chato do krai
            }

            else if(a == 69){
                break; //Condicao pra fechar o laco, botei pq se nao da erro
            }

            else{
                System.out.println("Comando invalido!");
            }
        }
        S.close();
    }
}
