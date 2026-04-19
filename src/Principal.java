import javax.swing.*;
import java.awt.*;

    public class Principal extends JFrame {
        private Biblioteca biblioteca;
        private Leitor leitor;

    public Principal(Biblioteca biblioteca, Leitor leitor) {
        super("Biblioteca Yoshikage Kira");

        this.biblioteca = biblioteca;
        this.leitor = leitor;

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(100, 150, 100, 150));

        JButton btnAlugar = new JButton("Alugar Livro");
        JButton btnDevolver = new JButton("Devolver Livro");
        JButton btnCatalogo = new JButton("Mostrar Catálogo");
        JButton btnRelatorios = new JButton("Relatórios");
        JButton btnCadastrar = new JButton("Cadastrar Livro");

        Dimension buttonSize = new Dimension(400, 40);

        btnAlugar.setMaximumSize(buttonSize);
        btnAlugar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnDevolver.setMaximumSize(buttonSize);
        btnDevolver.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnCatalogo.setMaximumSize(buttonSize);
        btnCatalogo.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnRelatorios.setMaximumSize(buttonSize);
        btnRelatorios.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnCadastrar.setMaximumSize(buttonSize);
        btnCadastrar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnAlugar.addActionListener(e -> {
            String titulo = JOptionPane.showInputDialog(this, "Título do livro:");
            if (titulo != null && !titulo.trim().isEmpty()) {
                Livro livro = biblioteca.pesquisarLivro(titulo);
                if (livro != null) {
                    leitor.emprestarLivro(livro);
                } else {
                    JOptionPane.showMessageDialog(this, "Livro não encontrado.");
                }
            }
        });

        btnDevolver.addActionListener(e -> {
            if (leitor.getLivrosAlugados().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Você não tem livros para devolver.");
                return;
            }

            String[] opcoes = leitor.getLivrosAlugados().stream()
                    .map(Livro::getTitulo)
                    .toArray(String[]::new);

            String livroEscolhido = (String) JOptionPane.showInputDialog(this,
                    "Qual livro deseja devolver?", "Devolver Livro",
                    JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            if (livroEscolhido != null) {
                boolean devolveu = leitor.devolverLivro(livroEscolhido);
                if (devolveu) {
                    JOptionPane.showMessageDialog(this, "Livro devolvido com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao devolver o livro.");
                }
            }
        });

        btnCatalogo.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Catálogo de Livros:\n");
            for (Livro l : biblioteca.getLivros()) {
                sb.append(l.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        });

        btnRelatorios.addActionListener(e -> {
            biblioteca.gerarRelatorioLivrosEmprestados();
            biblioteca.gerarRelatorioUsuariosAtivos();
        });

        btnCadastrar.addActionListener(e -> cadastrarLivro());

        panel.add(btnAlugar);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnDevolver);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnCatalogo);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnRelatorios);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnCadastrar);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
        biblioteca.salvarBiblioteca("biblioteca.dat");
        }
        });

        setVisible(true);
        }

    private void cadastrarLivro() {
        String titulo = JOptionPane.showInputDialog(this, "Digite o título do livro:");
        if (titulo == null || titulo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Título é obrigatório.");
            return;
        }

        String autor = JOptionPane.showInputDialog(this, "Digite o autor do livro:");
        if (autor == null || autor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Autor é obrigatório.");
            return;
        }

        String isbnStr = JOptionPane.showInputDialog(this, "Digite o ISBN (número) do livro:");
        long isbn;
        try {
            isbn = Long.parseLong(isbnStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ISBN deve ser um número válido.");
            return;
        }

        String qtdStr = JOptionPane.showInputDialog(this, "Digite a quantidade disponível:");
        int qtd;
        try {
            qtd = Integer.parseInt(qtdStr);
            if (qtd < 1) {
                JOptionPane.showMessageDialog(this, "Quantidade deve ser maior que zero.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade deve ser um número inteiro válido.");
            return;
        }

        Livro novoLivro = new Livro(titulo.trim(), autor.trim(), isbn, qtd);
        biblioteca.addLivro(novoLivro);
        JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!");
    }
}