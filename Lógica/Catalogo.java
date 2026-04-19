import javax.swing.*;
import java.awt.*;

public class Catalago extends JFrame {

    Biblioteca biblioteca;

    public Catalago(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Catálogo de Livros");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        Lista();

        setVisible(true);
    }

    public void Lista(){
        if (biblioteca.getLivros().isEmpty()) {
            add(new JLabel("Nenhum livro cadastrado"));
            return;
        }

        for (Livro livro : biblioteca.getLivros()) {
            add(new JLabel(livro.getTitulo() + " (" + livro.getQtd() + " disponíveis)"));
        }
    }
}
