import java.io*;
import java.util.ArrayList;

    public class Biblioteca implements Serializable {
        private static final long serialVersionUID = 1L;
        private ArrayList<Livro> livros = new ArrayList<>();
        private ArrayList<Leitor> leitores = new ArrayList<>();

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public void addLeitor(Leitor leitor) {
        leitores.add(leitor);
    }

    public Livro pesquisarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public Leitor pesquisarLeitor(String nome) {
        for (Leitor leitor : leitores) {
            if (leitor.getUsuario().equalsIgnoreCase(nome)) {
                return leitor;
            }
        }
        return null;
    }

    public Leitor pesquisarLeitorPorID(int id) {
        for (Leitor leitor : leitores) {
            if (leitor.getID() == id) {
                return leitor;
            }
        }
        return null;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public ArrayList<Leitor> getLeitores() {
        return leitores;
    }

    public void gerarRelatorioLivrosEmprestados() {
        System.out.println("Livros emprestados:");
        for (Leitor leitor : leitores) {
            for (Livro livro : leitor.getLivrosAlugados()) {
                System.out.println(leitor.getUsuario() + " está com o livro: " + livro.getTitulo());
            }
        }
    }

    public void gerarRelatorioUsuariosAtivos() {
        System.out.println("Usuários com livros:");
        for (Leitor leitor : leitores) {
            if (!leitor.getLivrosAlugados().isEmpty()) {
                System.out.println(leitor);
            }
        }
    }

    public void salvarBiblioteca(String caminhoArquivo) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
        oos.writeObject(this);
        System.out.println("Biblioteca salva com sucesso!");
    } catch (IOException e) {
        System.err.println("Erro ao salvar biblioteca: " + e.getMessage());
    }
    }

    public static Biblioteca carregarBiblioteca(String caminhoArquivo) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
        return (Biblioteca) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Erro ao carregar biblioteca: " + e.getMessage());
        return new Biblioteca();
    }
    }
}
