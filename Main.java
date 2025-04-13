//Aluno: Lucas Campos de Oliveira Basques

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilhaDinamica pilha = new PilhaDinamica();
        int opcao;

        do {
            System.out.println("\n--- MENU PILHA DINÂMICA ---");
            System.out.println("1 - Inserir elemento");
            System.out.println("2 - Inserir sequência");
            System.out.println("3 - Remover elemento");
            System.out.println("4 - Remover sequência");
            System.out.println("5 - Remover todas as ocorrências");
            System.out.println("6 - Buscar elemento");
            System.out.println("7 - Ordenar crescente");
            System.out.println("8 - Ordenar decrescente");
            System.out.println("9 - Editar elemento");
            System.out.println("10 - Exibir pilha");
            System.out.println("11 - Obter topo (primeiro elemento)");
            System.out.println("12 - Obter base (último elemento)");
            System.out.println("13 - Quantidade de elementos");
            System.out.println("14 - Limpar pilha");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento: ");
                    String elem = scanner.nextLine();
                    pilha.inserirElemento(elem);
                    break;

                case 2:
                    System.out.print("Quantos elementos deseja inserir? ");
                    int qtd = scanner.nextInt();
                    scanner.nextLine();
                    Object[] sequencia = new Object[qtd];
                    for (int i = 0; i < qtd; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        sequencia[i] = scanner.nextLine();
                    }
                    pilha.inserirSequencia(sequencia);
                    break;

                case 3:
                    System.out.print("Digite o elemento a remover: ");
                    String remover = scanner.nextLine();
                    pilha.removerElemento(remover);
                    break;

                case 4:
                    System.out.print("Quantos elementos deseja remover? ");
                    int qtdRemover = scanner.nextInt();
                    scanner.nextLine();
                    Object[] removerSeq = new Object[qtdRemover];
                    for (int i = 0; i < qtdRemover; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        removerSeq[i] = scanner.nextLine();
                    }
                    pilha.removerSequencia(removerSeq);
                    break;

                case 5:
                    System.out.print("Digite o elemento para remover todas as ocorrências: ");
                    String todas = scanner.nextLine();
                    pilha.removerTodasOcorrencias(todas);
                    break;

                case 6:
                    System.out.print("Digite o elemento a buscar: ");
                    String buscar = scanner.nextLine();
                    boolean achou = pilha.buscarElemento(buscar);
                    System.out.println("Elemento " + (achou ? "encontrado" : "não encontrado") + ".");
                    break;

                case 7:
                    pilha.ordenarCrescente();
                    System.out.println("Pilha ordenada em ordem crescente.");
                    break;

                case 8:
                    pilha.ordenarDecrescente();
                    System.out.println("Pilha ordenada em ordem decrescente.");
                    break;

                case 9:
                    System.out.print("Digite o elemento a ser editado: ");
                    String antigo = scanner.nextLine();
                    System.out.print("Digite o novo valor: ");
                    String novo = scanner.nextLine();
                    pilha.editarElemento(antigo, novo);
                    break;

                case 10:
                    pilha.exibir();
                    break;

                case 11:
                    No primeiro = pilha.obterPrimeiroElemento();
                    if (primeiro != null)
                        System.out.println("Topo da pilha: " + primeiro.getConteudo());
                    else
                        System.out.println("Pilha vazia.");
                    break;

                case 12:
                    No ultimo = pilha.obterUltimoElemento();
                    if (ultimo != null)
                        System.out.println("Base da pilha: " + ultimo.getConteudo());
                    else
                        System.out.println("Pilha vazia.");
                    break;

                case 13:
                    System.out.println("Quantidade de elementos: " + pilha.quantidadeElementos());
                    break;

                case 14:
                    pilha.limpar();
                    System.out.println("Pilha limpa.");
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
