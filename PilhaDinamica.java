//Aluno: Lucas Campos de Oliveira Basques

public class PilhaDinamica implements IEstruturaDinamica {

    private No topo;
    private int tamanho;

    public PilhaDinamica() {
        this.topo = null;
        this.tamanho = 0;
    }

    @Override
    public void inserirElemento(Object elemento) {
        No novo = new No(elemento);
        if (topo != null) {
            novo.setAnterior(topo);
        }
        topo = novo;
        tamanho++;
    }

    @Override
    public void inserirSequencia(Object elementos) {
        if (elementos instanceof Object[]) {
            Object[] lista = (Object[]) elementos;
            for (Object elem : lista) {
                inserirElemento(elem);
            }
        }
    }

    @Override
    public boolean removerElemento(Object elemento) {
        if (estaVazia()) return false;

        No atual = topo;
        while (atual != null) {
            if (atual.getConteudo().equals(elemento)) {
                No anterior = atual.getAnterior();
                if (atual == topo) {
                    topo = anterior;
                } else {
                    No aux = topo;
                    while (aux != null && aux.getAnterior() != atual) {
                        aux = aux.getAnterior();
                    }
                    if (aux != null) {
                        aux.setAnterior(atual.getAnterior());
                    }
                }
                tamanho--;
                return true;
            }
            atual = atual.getAnterior();
        }
        return false;
    }

    @Override
    public void removerSequencia(Object elementos) {
        if (elementos instanceof Object[]) {
            Object[] lista = (Object[]) elementos;
            for (Object elem : lista) {
                removerElemento(elem);
            }
        }
    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {
        while (removerElemento(elemento)) {

        }
    }

    @Override
    public boolean estaCheia() {
        return false;
    }

    @Override
    public boolean estaVazia() {
        return topo == null;
    }

    @Override
    public boolean buscarElemento(Object elemento) {
        No atual = topo;
        while (atual != null) {
            if (atual.getConteudo().equals(elemento)) {
                return true;
            }
            atual = atual.getAnterior();
        }
        return false;
    }

    @Override
    public void ordenarCrescente() {
        if (tamanho < 2) return;

        Object[] array = new Object[tamanho];
        No atual = topo;
        int i = tamanho - 1;
        while (atual != null) {
            array[i--] = atual.getConteudo();
            atual = atual.getAnterior();
        }


        for (int x = 0; x < array.length - 1; x++) {
            for (int y = 0; y < array.length - x - 1; y++) {
                Comparable c1 = (Comparable) array[y];
                Comparable c2 = (Comparable) array[y + 1];
                if (c1.compareTo(c2) > 0) {
                    Object temp = array[y];
                    array[y] = array[y + 1];
                    array[y + 1] = temp;
                }
            }
        }

        limpar();
        for (Object obj : array) {
            inserirElemento(obj);
        }
    }

    @Override
    public void ordenarDecrescente() {
        ordenarCrescente();
        Object[] array = new Object[tamanho];
        No atual = topo;
        int i = tamanho - 1;
        while (atual != null) {
            array[i--] = atual.getConteudo();
            atual = atual.getAnterior();
        }

        limpar();
        for (int j = array.length - 1; j >= 0; j--) {
            inserirElemento(array[j]);
        }
    }

    @Override
    public int quantidadeElementos() {
        return tamanho;
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        No atual = topo;
        while (atual != null) {
            if (atual.getConteudo().equals(elementoAntigo)) {
                atual.setConteudo(elementoNovo);
                break;
            }
            atual = atual.getAnterior();
        }
    }

    @Override
    public void limpar() {
        topo = null;
        tamanho = 0;
    }

    @Override
    public void exibir() {
        if (estaVazia()) {
            System.out.println("Pilha vazia!");
            return;
        }

        System.out.println("Elementos da pilha (do topo para base):");
        No atual = topo;
        while (atual != null) {
            System.out.println(atual.getConteudo());
            atual = atual.getAnterior();
        }
    }

    @Override
    public No obterPrimeiroElemento() {
        return topo;
    }

    @Override
    public No obterUltimoElemento() {
        No atual = topo;
        if (atual == null) return null;

        while (atual.getAnterior() != null) {
            atual = atual.getAnterior();
        }
        return atual;
    }
}
