import java.util.Scanner;

public class Eletronico extends Produto implements Garantia {
    String tipoEletronico;
    boolean garantia;
    String tempoGarantia;
    Scanner input = new Scanner(System.in);

    public void checkGarantia() {
        System.out.print("O produto tem garantia? (s/n): ");
        String temGarantia = input.next();

        switch (temGarantia) {
            case "s":
            case "S":
                this.garantia = true;
                break;

            case "n":
            case "N":
                this.garantia = false;
                break;

            default:
                System.out.println("Resposta inválida, por favor, tente novamente!");
                checkGarantia();
                break;
        }
    }

    public boolean getGarantia() {
        return this.garantia;
    }

    public void cadastrar() {
        super.cadastrarNome();
        this.nicho = "Eletronicos";

        input = new Scanner(System.in);
        System.out.print("Informe o tipo do eletronico (computador, eletrodomesticos, etc): ");
        String tipoEletronico = input.nextLine();
        this.tipoEletronico = tipoEletronico;

        checkGarantia();

        if (getGarantia()) {
            System.out.println("Informe em quantidade e a medida de tempo de garantia do seu produto, ex: 1 ano");
            input = new Scanner(System.in);
            System.out.print("Quanto tempo de garantia seu produto tem?: ");
            String tempoGarantia = input.nextLine();
            this.tempoGarantia = tempoGarantia;
        }

        super.cadastrarValor();
        super.cadastrarQuantidade();
    }
}
