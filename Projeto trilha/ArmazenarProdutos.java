import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ArmazenarProdutos {
    ArrayList<Alimento> listaAlimentos = new ArrayList<>();
    ArrayList<Vestimenta> listaVestimentas = new ArrayList<>();
    ArrayList<Eletronico> listaEletronicos = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    Menu menu;

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    void armazenar(Alimento alimento) {
        listaAlimentos.add(alimento);
    }

    void armazenar(Vestimenta vestimentas) {
        listaVestimentas.add(vestimentas);
    }

    void armazenar(Eletronico eletronicos) {
        listaEletronicos.add(eletronicos);
    }

    void menuGerencia() {
        Mensagens.msgGerencia();
        input = new Scanner(System.in);
        System.out.println(
                "\n1 - Exibir meus produtos" + "\n2 - Alterar quantidade/valor de um produto "
                        + "\n3 - Remover um produto\n" + "0 - Retornar ao Menu");
        Mensagens.digiteOpcao();
        int escolha = input.nextInt();

        switch (escolha) {
            case 1:
                exibirProdutos();
                break;
            case 2:
                alterarCaracteristicas();
                break;

            case 3:
                removerProduto();

            case 0:
                menu.menu();

            default:
                System.out.println("Opção não reconhecida, por favor, tente novamente!");

        }
    }

    void alterarCaracteristicas() {
        int i = 0;
        input = new Scanner(System.in);
        System.out.print("\nInforme o nome do produto que deseja alterar: ");
        String produtoEscolhido = input.nextLine();

        for (i = 0; i < listaAlimentos.size(); i++) {
            if (listaAlimentos.get(i).nome.equals(produtoEscolhido)) {
                input = new Scanner(System.in);
                System.out.println("1 - Alterar quantidade do produto" + "\n2 - Alterar valor do produto");
                Mensagens.digiteOpcao();
                int decisao = input.nextInt();

                switch (decisao) {
                    case 1:
                        alterarQuantidadeAlimento(i, this.listaAlimentos);
                        menuGerencia();
                        break;

                    case 2:
                        alterarValorAlimento(i, listaAlimentos);
                        menuGerencia();
                        break;

                }
                break;
            }
        }

        for (i = 0; i < listaVestimentas.size(); i++) {
            if (listaVestimentas.get(i).nome.equals(produtoEscolhido)) {
                input = new Scanner(System.in);
                System.out.println("1 - Alterar quantidade do produto" + "\n2 - Alterar valor do produto");
                Mensagens.digiteOpcao();
                int decisao = input.nextInt();

                switch (decisao) {
                    case 1:
                        alterarQuantidadeVestimenta(i, listaVestimentas);
                        menuGerencia();

                        break;

                    case 2:
                        alterarValorVestimenta(i, listaVestimentas);
                        menuGerencia();
                        break;
                }

            }
        }

        for (i = 0; i < listaEletronicos.size(); i++) {
            if (listaEletronicos.get(i).nome.equals(produtoEscolhido)) {
                input = new Scanner(System.in);
                System.out.println("1 - Alterar quantidade do produto" + "\n2 - Alterar valor do produto");
                Mensagens.digiteOpcao();
                int decisao = input.nextInt();

                switch (decisao) {
                    case 1:
                        alterarQuantidadeEletronico(i, listaEletronicos);
                        menuGerencia();
                        break;

                    case 2:
                        alterarValorEletronicos(i, listaEletronicos);
                        menuGerencia();
                        break;
                }
            }
        }
        System.out
                .println(Mensagens.VERMELHO + "Produto não encontrado, por favor, tente novamente!" + Mensagens.PADRAO);
        menuGerencia();
    }

    void removerProduto() {
        int i = 0;
        input = new Scanner(System.in);
        System.out.print("\nInforme o nome do produto que deseja remover: ");
        String produtoEscolhido = input.nextLine();

        for (i = 0; i < listaAlimentos.size(); i++) {
            if (listaAlimentos.get(i).nome.equals(produtoEscolhido)) {
                Mensagens.produtoRemovido(produtoEscolhido);
                listaAlimentos.remove(listaAlimentos.get(i));
                menuGerencia();
            }
        }

        for (i = 0; i < listaVestimentas.size(); i++) {
            if (listaVestimentas.get(i).nome.equals(produtoEscolhido)) {
                Mensagens.produtoRemovido(produtoEscolhido);
                listaVestimentas.remove(listaVestimentas.get(i));
                menuGerencia();
            }
        }

        for (i = 0; i < listaEletronicos.size(); i++) {
            if (listaEletronicos.get(i).nome.equals(produtoEscolhido)) {
                Mensagens.produtoRemovido(produtoEscolhido);
                listaEletronicos.remove(listaEletronicos.get(i));
                menuGerencia();
            }
        }

        System.out.println("Produto não encontrado, por favor, tente novamente!");
        alterarCaracteristicas();

        menu.menu();
    }

    void exibirProdutos() {
        int i = 0;

        if (listaAlimentos.isEmpty() && listaVestimentas.isEmpty() && listaEletronicos.isEmpty()) {
            System.out.println(
                    Mensagens.AMARELO
                            + "\n[AVISO]: Nenhum produto cadastrado, vá até a página de cadastro de produto para executar o cadastro!"
                            + Mensagens.PADRAO);
        }

        if (!listaAlimentos.isEmpty()) {
            System.out.println(Mensagens.AMARELO + "\n||ALIMENTOS||" + Mensagens.PADRAO);
            for (i = 0; i < listaAlimentos.size(); i++) {
                System.out.println(
                        "\nNome: " + listaAlimentos.get(i).nome + "\nTipo: " + listaAlimentos.get(i).tipoAlimento
                                + "\nPeso (KG): " + listaAlimentos.get(i).pesoKG + "\nData de validade: "
                                + listaAlimentos.get(i).dataValidade + "\nValor: "
                                + new DecimalFormat(".##").format(listaAlimentos.get(i).valor)
                                + "\nQuantidade: " + listaAlimentos.get(i).quantidade + " unidades");
            }
        }

        if (!listaVestimentas.isEmpty()) {
            System.out.println(Mensagens.AMARELO + "\n||VESTIMENTAS||" + Mensagens.PADRAO);
            for (i = 0; i < listaVestimentas.size(); i++) {
                System.out.println(
                        "\nNome: " + listaVestimentas.get(i).nome + "\nTipo: " + listaVestimentas.get(i).tipoVestimenta
                                + "\nTamanho: " + listaVestimentas.get(i).tamanho + "\nMaterial: "
                                + listaVestimentas.get(i).material + "\nValor: "
                                + new DecimalFormat(".##").format(listaVestimentas.get(i).valor)
                                + "\nQuantidade: " + listaVestimentas.get(i).quantidade + " unidades");
            }
        }

        if (!listaEletronicos.isEmpty()) {
            System.out.println(Mensagens.AMARELO + "\n||ELETRONICOS||" + Mensagens.PADRAO);
            for (i = 0; i < listaEletronicos.size(); i++) {
                System.out.println(
                        "\nNome: " + listaEletronicos.get(i).nome + "\nTipo: "
                                + listaEletronicos.get(i).tipoEletronico);
                if (listaEletronicos.get(i).garantia) {
                    System.out.println("Garantia: Sim");
                    System.out.println("Tempo de garantia: " + listaEletronicos.get(i).tempoGarantia);
                } else {
                    System.out.println("Garantia: Não");
                }
                System.out.println("Valor: " + new DecimalFormat(".##").format(listaEletronicos.get(i).valor)
                        + "\nQuantidade: " + listaEletronicos.get(i).quantidade + " unidades");
            }
        }

        menuGerencia();
    }

    void alterarQuantidadeAlimento(int i, ArrayList<Alimento> lista) {
        int antigaQuantidade = lista.get(i).quantidade;
        final int quantidadeAtual = antigaQuantidade;
        input = new Scanner(System.in);
        Mensagens.alterarQuantidade(antigaQuantidade);
        int alterar = input.nextInt();
        switch (alterar) {
            case 1:
                System.out.print("\nInforme quantas unidades deseja adicionar: ");
                input = new Scanner(System.in);
                int adicionarQuantidade = input.nextInt();
                if (adicionarQuantidade >= 0) {
                    lista.get(i).setQuantidade(antigaQuantidade += adicionarQuantidade);
                    Mensagens.quantidadeAlterada(quantidadeAtual, lista.get(i).quantidade);
                    break;
                } else {
                    System.out.println(
                            Mensagens.VERMELHO
                                    + "Por favor, não informe valores negativos para adicionar unidades, tente novamente!"
                                    + Mensagens.PADRAO);
                    alterarQuantidadeAlimento(i, lista);
                    break;
                }

            case 2:
                System.out.print("\nInforme quantas unidades deseja remover: ");
                input = new Scanner(System.in);
                int removerQuantidade = input.nextInt();
                if (removerQuantidade <= lista.get(i).quantidade) {
                    lista.get(i).setQuantidade(antigaQuantidade -= removerQuantidade);
                    Mensagens.quantidadeAlterada(quantidadeAtual, lista.get(i).quantidade);
                    break;
                } else {
                    System.out.println(
                            Mensagens.VERMELHO
                                    + "\nQuantidades a serem removidas são maiores que a quantidade que você tem, por favor, tente novamente!"
                                    + Mensagens.PADRAO);
                    alterarQuantidadeAlimento(i, lista);
                    break;
                }

            default:
                Mensagens.opcaoNaoReconhecida();
                break;
        }
    }

    void alterarValorAlimento(int i, ArrayList<Alimento> lista) {
        double antigoValor = lista.get(i).valor;
        final double exibirAntigoValor = antigoValor;
        input = new Scanner(System.in);
        Mensagens.alterarValor(antigoValor);
        int alterar = input.nextInt();

        switch (alterar) {
            case 1:
                input = new Scanner(System.in);
                System.out.print("Informe o novo valor para o produto: ");
                double novoValor = input.nextDouble();
                if (novoValor >= 0) {
                    lista.get(i).setValor(novoValor);
                    Mensagens.valorAlterado(exibirAntigoValor, novoValor);
                    break;
                } else {
                    System.out.println(Mensagens.VERMELHO + "Por favor, digite números positivos" + Mensagens.PADRAO);
                    alterarValorAlimento(i, lista);
                    break;
                }

            case 2:
                input = new Scanner(System.in);
                System.out.print("\nInforme o desconto oferecido para o produto em %: ");
                int desconto = input.nextInt();
                lista.get(i).descontar(antigoValor, desconto);
                Mensagens.descontoAplicado(desconto);
                break;

            default:
                Mensagens.opcaoNaoReconhecida();
                alterarValorAlimento(i, lista);
                break;
        }
    }

    void alterarQuantidadeVestimenta(int i, ArrayList<Vestimenta> lista) {
        int antigaQuantidade = lista.get(i).quantidade;
        final int quantidadeAtual = antigaQuantidade;
        input = new Scanner(System.in);
        Mensagens.alterarQuantidade(antigaQuantidade);
        int alterar = input.nextInt();
        switch (alterar) {
            case 1:
                System.out.print("\nInforme quantas unidades deseja adicionar: ");
                input = new Scanner(System.in);
                int adicionarQuantidade = input.nextInt();
                if (adicionarQuantidade >= 0) {
                    lista.get(i).setQuantidade(antigaQuantidade += adicionarQuantidade);
                    Mensagens.quantidadeAlterada(quantidadeAtual, lista.get(i).quantidade);
                    break;
                } else {
                    System.out.println(
                            Mensagens.VERMELHO
                                    + "Por favor, não informe valores negativos para adicionar unidades, tente novamente!"
                                    + Mensagens.PADRAO);
                    alterarQuantidadeVestimenta(i, lista);
                    break;
                }

            case 2:
                System.out.print("\nInforme quantas unidades deseja remover: ");
                input = new Scanner(System.in);
                int removerQuantidade = input.nextInt();
                if (removerQuantidade <= lista.get(i).quantidade) {
                    lista.get(i).setQuantidade(antigaQuantidade -= removerQuantidade);
                    Mensagens.quantidadeAlterada(quantidadeAtual, lista.get(i).quantidade);
                    break;
                } else {
                    System.out.println(
                            Mensagens.VERMELHO
                                    + "\nQuantidades a serem removidas são maiores que a quantidade que você tem, por favor, tente novamente!"
                                    + Mensagens.PADRAO);
                    alterarQuantidadeVestimenta(i, lista);
                    break;
                }

            default:
                Mensagens.opcaoNaoReconhecida();
                break;
        }
    }

    void alterarValorVestimenta(int i, ArrayList<Vestimenta> lista) {
        double antigoValor = lista.get(i).valor;
        final double exibirAntigoValor = antigoValor;
        input = new Scanner(System.in);
        Mensagens.alterarValor(antigoValor);
        int alterar = input.nextInt();

        switch (alterar) {
            case 1:
                input = new Scanner(System.in);
                System.out.print("\nInforme o novo valor para o produto: ");
                double novoValor = input.nextDouble();
                if (novoValor >= 0) {
                    lista.get(i).setValor(novoValor);
                    Mensagens.valorAlterado(exibirAntigoValor, novoValor);
                    break;
                } else {
                    System.out.println(Mensagens.VERMELHO + "Por favor, digite números positivos" + Mensagens.PADRAO);
                    alterarValorVestimenta(i, lista);
                    break;
                }

            case 2:
                input = new Scanner(System.in);
                System.out.print("Informe o desconto oferecido para o produto em %: ");
                int desconto = input.nextInt();
                lista.get(i).descontar(antigoValor, desconto);
                Mensagens.descontoAplicado(desconto);
                break;

            default:
                Mensagens.opcaoNaoReconhecida();
                alterarValorVestimenta(i, lista);
                break;
        }
    }

    void alterarQuantidadeEletronico(int i, ArrayList<Eletronico> lista) {
        int antigaQuantidade = lista.get(i).quantidade;
        final int quantidadeAtual = antigaQuantidade;
        input = new Scanner(System.in);
        Mensagens.alterarQuantidade(antigaQuantidade);
        int alterar = input.nextInt();
        switch (alterar) {
            case 1:
                System.out.print("\nInforme quantas unidades deseja adicionar: ");
                input = new Scanner(System.in);
                int adicionarQuantidade = input.nextInt();
                if (adicionarQuantidade >= 0) {
                    lista.get(i).setQuantidade(antigaQuantidade += adicionarQuantidade);
                    Mensagens.quantidadeAlterada(quantidadeAtual, lista.get(i).quantidade);
                    break;
                } else {
                    System.out.println(
                            Mensagens.VERMELHO
                                    + "Por favor, não informe valores negativos para adicionar unidades, tente novamente!"
                                    + Mensagens.PADRAO);
                    alterarQuantidadeEletronico(i, lista);
                    break;
                }

            case 2:
                System.out.print("\nInforme quantas unidades deseja remover: ");
                input = new Scanner(System.in);
                int removerQuantidade = input.nextInt();
                if (removerQuantidade <= lista.get(i).quantidade) {
                    lista.get(i).setQuantidade(antigaQuantidade -= removerQuantidade);
                    Mensagens.quantidadeAlterada(quantidadeAtual, lista.get(i).quantidade);
                    break;
                } else {
                    System.out.println(
                            Mensagens.VERMELHO
                                    + "\nQuantidades a serem removidas são maiores que a quantidade que você tem, por favor, tente novamente!"
                                    + Mensagens.PADRAO);
                    alterarQuantidadeEletronico(i, lista);
                    break;
                }

            default:
                Mensagens.opcaoNaoReconhecida();
                break;
        }
    }

    void alterarValorEletronicos(int i, ArrayList<Eletronico> lista) {
        double antigoValor = lista.get(i).valor;
        final double exibirAntigoValor = antigoValor;
        input = new Scanner(System.in);
        Mensagens.alterarValor(antigoValor);
        int alterar = input.nextInt();

        switch (alterar) {
            case 1:
                input = new Scanner(System.in);
                System.out.print("\nInforme o novo valor para o produto: ");
                double novoValor = input.nextDouble();
                if (novoValor >= 0) {
                    lista.get(i).setValor(novoValor);
                    Mensagens.valorAlterado(exibirAntigoValor, novoValor);
                    break;
                } else {
                    System.out.println(Mensagens.VERMELHO + "Por favor, digite números positivos" + Mensagens.PADRAO);
                    alterarValorEletronicos(i, lista);
                    break;
                }

            case 2:
                input = new Scanner(System.in);
                System.out.print("Informe o desconto oferecido para o produto em %: ");
                int desconto = input.nextInt();
                lista.get(i).descontar(antigoValor, desconto);
                Mensagens.descontoAplicado(desconto);
                break;

            default:
                Mensagens.opcaoNaoReconhecida();
                alterarValorEletronicos(i, lista);
                break;
        }
    }

}
