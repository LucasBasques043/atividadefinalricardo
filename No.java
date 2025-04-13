//Aluno: Lucas Campos de Oliveira Basques

public class No implements INo {
    private Object conteudo;
    private No prox;
    private No anterior;

    public No(Object conteudo) {
        this.conteudo = conteudo;
        this.prox = null;
        this.anterior = null;
    }

    @Override
    public No getProx() {
        return prox;
    }

    @Override
    public void setProx(No prox) {
        this.prox = prox;
    }

    @Override
    public Object getConteudo() {
        return conteudo;
    }

    @Override
    public void setConteudo(Object conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public No getAnterior() {
        return anterior;
    }

    @Override
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}
