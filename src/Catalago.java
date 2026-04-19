import javax.swing.*;

public class Catalago extends JFrame {

    Biblioteca biblioteca;

    public Catalago(Biblioteca biblioteca) {

        this.biblioteca = biblioteca;

        setTitle("Catálogo de Livros");
        setSize(200, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        Lista();

        setVisible(true);
    }

    public void Lista(){
        for (Livro livro : biblioteca.getLivros()) {
            add(new JLabel(livro.getTitulo()));
        }
    }
}
