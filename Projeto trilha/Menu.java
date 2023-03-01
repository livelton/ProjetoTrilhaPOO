import java.util.Scanner;

public class Menu {
    CadastroProduto cadProduto;
    Scanner input = new Scanner(System.in);

    public void setCadastro(CadastroProduto cadProduto) {
        this.cadProduto = cadProduto;
    }

    public CadastroProduto getCadastro() {
        return this.cadProduto;
    }

    void menu() {
        Mensagens.msgMenu();
        input = new Scanner(System.in);
        int escolha = input.nextInt();

        switch (escolha) {
            case 0:
                Mensagens.msgObrigado();
                System.exit(0);
                break;

            case 1:
                cadProduto.cadastrarProduto();
                break;

            case 2:
                cadProduto.getArmazenamento().menuGerencia();
                break;

            default:
                System.out.println("\nOpção não reconhecida, por favor, tente novamente");
                break;
        }

        menu();

    }
}
