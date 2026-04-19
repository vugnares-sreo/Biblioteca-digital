import javax.swing.*;

public class Catalago extends JFrame {

    Biblioteca biblioteca = new Biblioteca();
    JLabel livros = new JLabel("Livros:");
    

    public Catalago() {
        
        setTitle("Catálogo de Livros");
        setVisible(true);
        setSize(200, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        biblioteca.addLivro();
        Lista();
    }

    public void Lista(){
        
        for (Livro livro : biblioteca.getLivros()) {
            new JLabel("bruh");
        }

    }
}