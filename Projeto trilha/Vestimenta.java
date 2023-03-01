import java.util.Scanner;
public class Vestimenta extends Produto implements Garantia {
    String tipoVestimenta;
    String tamanho;
    String material;
    boolean garantia;
    int tempoGarantia;
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

    public void cadastrar(){
        super.cadastrarNome();
        this.nicho = "Vestimentas";

        input = new Scanner(System.in);
        System.out.print("Informe o tipo de vestimenta (vestido, calça, etc): ");
        String tipoVestimenta = input.nextLine();
        this.tipoVestimenta = tipoVestimenta;

        input = new Scanner(System.in);
        System.out.print("Informe o tamanho da vestimenta (P, G, M): ");
        String tamanhoVestimenta = input.nextLine();
        this.tamanho = tamanhoVestimenta;

        input = new Scanner(System.in);
        System.out.print("Informe o material que compõe a vestimenta: ");
        String materialVestimenta = input.nextLine();
        this.material = materialVestimenta;

        this.tamanho = "G";

        super.cadastrarValor();
        super.cadastrarQuantidade();
    }
}
