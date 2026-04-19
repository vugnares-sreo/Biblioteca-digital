import java.util.*;

public class Biblioteca{
    private ArrayList<Leitor> leitores;
    private ArrayList<Livro> livros;
    static int ativos;


    public Biblioteca(){
        livros = new ArrayList<Livro>();
        leitores = new ArrayList<Leitor>();
        
    }

    public void addLivro(Livro livro){
        livros.add(livro);
    }

    public void addLeitor(Leitor leitor){
        leitores.add(leitor);
    }

    public Livro pesquisarLivro(String titulo){
        for (Livro livro : livros){
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public Leitor pesquisarLeitor(String usuario){
        for (Leitor leitor : leitores){
            if (leitor.getUsuario().equals(usuario)) {
                return leitor;
            }
        }
        return null;
    }

    public void gerarRelatorioLivrosEmprestados() {
    int totalEmprestados = 0;
    System.out.println("=== Livros Emprestados ===");

    for (Livro livro : livros) {
            int emprestados = livro.getEmprestado();
            if (emprestados > 0) {
                System.out.println(livro.getTitulo() + ": " + emprestados + " emprestado(s)");
                totalEmprestados += emprestados;
            }
        }

        System.out.println("Total de livros emprestados: " + totalEmprestados);
    }

    public void gerarRelatorioUsuariosAtivos() {
        ativos = 0;
        System.out.println("=== Usuários Ativos ===");

        for (Leitor leitor : leitores) {
            if (leitor.getLivroAlugas() != null) {
                System.out.println(leitor.getUsuario() + " está com: " + leitor.getLivroAlugas().getTitulo());
                ativos++;
            }
        }

        System.out.println("Total de usuários ativos: " + ativos);
    }   

    public void setLeitores(ArrayList<Leitor> leitores){
        this.leitores = leitores;
    }

    public void setLivros(ArrayList<Livro> livros){
        this.livros = livros;
    }

    public ArrayList<Livro> getLivros(){
        return livros;       
    }

    public ArrayList<Leitor> getLeitores(){
        return leitores;       
    }
}
