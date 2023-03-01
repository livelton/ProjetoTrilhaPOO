import java.text.DecimalFormat;

public class Mensagens {
    // cores para o terminal
    public static final String AMARELO = "\u001B[38;2;255;255;0m";
    public static final String FUNDO_BRANCO = "\u001B[48;2;255;255;255m";
    public static final String PADRAO = "\u001B[0m";
    public static final String VERDE = "\u001B[38;2;50;205;50m";
    public static final String VERMELHO = "\u001B[38;2;255;0;0m";
    public static final String PRETO = "\u001B[38;2;0;0;0m";

    static void msgMenu() {
        System.out.println(AMARELO + "\n==============================" + PADRAO);
        System.out.println("SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println(AMARELO + "==============================\n" + PADRAO);
        System.out.println("ESCOLHA UMA OPÇÃO\n");
        System.out.println(
                "1 - Cadastrar Produto\n2 - Gerenciar Produtos\n0 - Sair do programa");
        digiteOpcao();
    }

    static void digiteOpcao() {
        System.out.print("\n" + FUNDO_BRANCO + PRETO + "Digite sua opção:" + PADRAO + " ");
    }

    static void msgCadastro() {
        System.out.println(AMARELO + "\n====================" + PADRAO);
        System.out.println("CADASTRE SEU PRODUTO");
        System.out.println(AMARELO + "====================\n" + PADRAO);
    }

    static void msgGerencia() {
        System.out.println(AMARELO + "\n======================" + PADRAO);
        System.out.println("GERENCIE SEUS PRODUTOS");
        System.out.println(AMARELO + "======================" + PADRAO);
    }

    static void msgNicho() {
        System.out.println("INFORME O NICHO DO SEU PRODUTO\n");
        System.out.print("1 - Alimentos\n" +
                "2 - Vestimentas\n" +
                "3 - Eletrônicos\n" + "0 - Retornar ao Menu principal\n");
                digiteOpcao();
    }

    static void msgSucessoCadastro() {
        System.out.println(VERDE + "\n" + "PRODUTO CADASTRADO COM SUCESSO!" + PADRAO);
    }

    static void msgObrigado() {
        System.out.println(VERDE + "Obrigado por escolher nosso sistema!" + PADRAO);
    }

    static void alterarQuantidade(int antigaQuantidade) {
        System.out.println("\nVocê tem " + AMARELO + antigaQuantidade + PADRAO + " unidades deste produto\n");
        System.out.println("1 - Adicionar unidades | 2 - Remover unidades");
        Mensagens.digiteOpcao();
    }

    static void quantidadeAlterada(int antigaQuantidade, int novaQuantidade) {
        System.out.println(VERDE + "\nQuantidade alterada com sucesso!\n"+ PADRAO +"|" + antigaQuantidade + "|"
                + " -> " + "|" + novaQuantidade + "|");
    }

    static void alterarValor(double antigoValor) {
        System.out.println("\nEste produto custa " + AMARELO + "R$" + new DecimalFormat(".##").format(antigoValor) + PADRAO);
        System.out.println("1 - Mudar valor | 2 - Oferecer desconto");
        Mensagens.digiteOpcao();
    }

    static void valorAlterado(double antigoValor, double novoValor) {
        System.out.println(VERDE + "\nValor alterado com sucesso!\n" + PADRAO + "|R$" + new DecimalFormat(".##").format(antigoValor) + "|" + " -> "
                + "|R$" + new DecimalFormat(".##").format(novoValor) + "|");
    }

    static void descontoAplicado(int desconto) {
        System.out.println(VERDE + "Desconto de " + desconto + "% aplicado com sucesso!" + PADRAO);
    }

    static void produtoRemovido(String nome) {
        System.out.println("\n" + AMARELO +  nome + VERDE + " Removido com sucesso!");
    }

    static void opcaoNaoReconhecida(){
        System.out.println(Mensagens.VERMELHO + "Opção não conhecida, por favor, tente novamente!" + Mensagens.PADRAO);
    }
}
