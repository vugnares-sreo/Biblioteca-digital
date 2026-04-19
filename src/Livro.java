public class Livro {

    private String titulo;
    private String autor;
    private long isbn;
    private int qtd;
    private int emprestado;

    public Livro(String titulo, String autor, long isbn, int qtd) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.qtd = qtd;
    }

    public boolean isDisponivel(){

        if(qtd >= 1){
            return true;
        }
        else{
            return false;
        }
    }

    public void emprestarLivro(){
        qtd--;
    }

    public void devolverLivro(){
        qtd++;
    }

    //getter e setters

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public long getIsbn() {
        return isbn;
    }

    public int getQtd() {
        return qtd;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getEmprestado(){
        return emprestado;
    }

    public void setEmprestado(int emprestado){
        this.emprestado = emprestado;
    }

    @Override
    public String toString() {
        return (" Hah " + qtd + " unidades do livro " + titulo + " do autor" + autor + " em estoque");
    }
}