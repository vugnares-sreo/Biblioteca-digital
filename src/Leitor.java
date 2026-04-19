public class Leitor{

    private String Usuario;
    private int ID;
    private Livro livroAlugas;

    public Leitor(String Usuario, int ID){
        this.Usuario = Usuario;
        this.ID = ID;
    }

    public void emprestarLivro(Livro livro){
        if(livro.isDisponivel()){            
            livro.emprestarLivro();
            this.livroAlugas = livro;
            
            System.out.println("O livro " + livro.getTitulo() + " foi alugado com sucesso! " + Usuario);
        }
    
        else {
            System.out.println("Este livro nao esta disponivel para emprestimo");
        }
}

    
    public void devolverLivro(){
        if(livroAlugas != null){
        
            livroAlugas.devolverLivro();

            System.out.println("O livro " + livroAlugas.getTitulo() + " foi devolvido com sucesso, " + Usuario + "! " );
            this.livroAlugas = null;
        }
    }

    //Sei la pra que precisa disso mas botei pq o mano do youtube disse que era bom ter
    //é pra manipular melhor man

        public String getUsuario() {
        return Usuario;
    }

    public int getID() {
        return ID;
    }

    public Livro getLivroAlugas() {
        return livroAlugas;
    }

    public void setUsuario(String usuario) {
        this.Usuario = usuario;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLivroAlugas(Livro livroAlugas) {
        this.livroAlugas = livroAlugas;
    }

    @Override
    public String toString() {
        return "Leitor: " + Usuario + " (ID: " + ID + ")";
    }
}