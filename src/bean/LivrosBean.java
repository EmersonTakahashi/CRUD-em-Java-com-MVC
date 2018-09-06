
package bean;

public class LivrosBean {
    
    private int codLivros;
    private String titulo;
    private String autor;
    private String editora;
    private String dataLancamento;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public int getCodLivros() {
        return codLivros;
    }

    public void setCodLivros(int codLivros) {
        this.codLivros = codLivros;
    }     
    
    
}
