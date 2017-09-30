package wagner_e_nivaldo.listadecompras;

/**
 * Created by Wagner on 30/09/2017.
 */

public class Itens {

    private String nome;
    private String categoria;
    private int quantidade;
    private boolean perecivel;

    public Itens(String nome, int quantidade, String categoria, boolean perecivel) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.perecivel = perecivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isPerecivel() {
        return perecivel;
    }

    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }
}
