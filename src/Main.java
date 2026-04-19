import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    Biblioteca biblioteca = new Biblioteca();

    JPanel panelRaiz = new JPanel();
    JPanel panelBotoes = new JPanel();

    JLabel mensagem = new JLabel("Bem-vindo à Biblioteca!");
    JButton alugarLivro = new JButton("Alugar um livro");
    JButton catalagoLivro = new JButton("Mostrar catálogo");
    JButton btnDevolverLivro = new JButton("Devolver livro");
    JButton btnCadastrarLivro = new JButton("Cadastrar livro");

    public Main() { // ← CORRIGIDO (era Principal)

        biblioteca.addLivro(new Livro("Java Básico", "Autor 1", 123, 3));
        biblioteca.addLivro(new Livro("POO na Prática", "Autor 2", 456, 2));

        defBotao();
        addListeners();
        defPainel();
        defTela();
    }

    public void defTela() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 200);
        setResizable(false);
        setTitle("Ler é legal");
        add(panelRaiz);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void defBotao() {
        Dimension tam = new Dimension(140, 30);
        alugarLivro.setPreferredSize(tam);
        catalagoLivro.setPreferredSize(tam);
        btnDevolverLivro.setPreferredSize(tam);
        btnCadastrarLivro.setPreferredSize(tam);
    }

    public void defPainel() {
        panelRaiz.setLayout(new BoxLayout(panelRaiz, BoxLayout.Y_AXIS));

        panelBotoes.setLayout(new BoxLayout(panelBotoes, BoxLayout.X_AXIS));
        panelBotoes.setOpaque(false);

        panelBotoes.add(alugarLivro);
        panelBotoes.add(Box.createRigidArea(new Dimension(10, 0)));
        panelBotoes.add(catalagoLivro);
        panelBotoes.add(Box.createRigidArea(new Dimension(10, 0)));
        panelBotoes.add(btnDevolverLivro);
        panelBotoes.add(Box.createRigidArea(new Dimension(10, 0)));
        panelBotoes.add(btnCadastrarLivro);

        panelBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        mensagem.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelRaiz.add(Box.createVerticalStrut(30));
        panelRaiz.add(mensagem);
        panelRaiz.add(Box.createVerticalStrut(30));
        panelRaiz.add(panelBotoes);
        panelRaiz.add(Box.createVerticalGlue());
    }

    public void addListeners() {

        alugarLivro.addActionListener(e -> {
            System.out.println("Botão 'Alugar um livro' clicado!");
        });

        catalagoLivro.addActionListener(e -> {
            new Catalago(biblioteca); // ← CORRIGIDO
        });

        btnDevolverLivro.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Funcionalidade de devolução ainda não implementada.");
        });

        btnCadastrarLivro.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Funcionalidade de cadastro ainda não implementada.");
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
