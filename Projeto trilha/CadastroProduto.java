import java.util.Scanner;

public class CadastroProduto {
    ArmazenarProdutos arm;
    Scanner input = new Scanner(System.in);

    Menu menu;
    Produto produtoCad;

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void setProdutoCad(Produto produto) {
        this.produtoCad = produto;
    }

    public void setArmazenamento(ArmazenarProdutos arm) {
        this.arm = arm;
    }

    public ArmazenarProdutos getArmazenamento() {
        return this.arm;
    }

    void cadastrarProduto() {
        Mensagens.msgCadastro();
        int escolhaNicho;

        Mensagens.msgNicho();
        escolhaNicho = input.nextInt();

        switch (escolhaNicho) {
            case 1:
                Alimento alimento = new Alimento();
                alimento.cadastrar();
                arm.armazenar(alimento);
                break;

            case 2:
                Vestimenta vestimenta = new Vestimenta();
                vestimenta.cadastrar();
                arm.armazenar(vestimenta);
                break;

            case 3:
                Eletronico eletronico = new Eletronico();
                eletronico.cadastrar();
                arm.armazenar(eletronico);
                break;

            case 0:
                menu.menu();
                break;

            default:
                System.out.println("ERRO! nicho não cadastrado, tente novamente!");
                cadastrarProduto();
                break;
        }

        cadastrarProduto();

    }
}
