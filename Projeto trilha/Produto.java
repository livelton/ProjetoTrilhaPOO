import java.util.Scanner;

public abstract class Produto {
    String nome;
    String nicho;
    double valor;
    int quantidade;
    Scanner input = new Scanner(System.in);

    public abstract void cadastrar();

    public void cadastrarNome() {
        System.out.print("\nInforme o nome do produto: ");
        String nomeProduto = input.nextLine();
        this.nome = nomeProduto;
    }

    public void cadastrarValor() {
        System.out.print("Informe o valor do produto: ");
        double valorProduto = input.nextDouble();
        if (valorProduto <= 0) {
            System.out.println(Mensagens.VERMELHO + "Erro, um produto não pode ter um valor negativo!" + Mensagens.PADRAO);
        } else {
            this.valor = valorProduto;
        }
    }

    public void cadastrarQuantidade() {
        input = new Scanner(System.in);
        System.out.print("Informe a quantidade desse produto: ");
        int quantidade = input.nextInt();

        if (quantidade <= 0) {
            System.out.println(Mensagens.VERMELHO + "Erro, a quantidade do produto não pode ter um valor negativo, tente novamente!" + Mensagens.PADRAO);
            cadastrarQuantidade();
        } else {
            this.quantidade = quantidade;

            System.out.println("O produto " + this.nome + " tem " + this.quantidade + " Unidades!");

            Mensagens.msgSucessoCadastro();
            System.out.print(
                    "Nome: " + this.nome + "\nValor: R$" + this.valor + "\nNicho: " + this.nicho + "\nQuantidade: "
                            + this.quantidade + "\n");
        }

    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    void descontar(double valor, int porcentagem) {
        final int DIVISOR = 100;
        this.valor = valor - (valor * porcentagem / DIVISOR);
    }
}
