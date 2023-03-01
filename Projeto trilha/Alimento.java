import java.util.Scanner;

public class Alimento extends Produto {
    double pesoKG;
    String tipoAlimento; 
    String dataValidade;
    Scanner input = new Scanner(System.in);

    public void cadastrar(){
        super.cadastrarNome();
        this.nicho = "Alimentos";

        input = new Scanner(System.in);
        System.out.print("Informe o tipo de alimento (fruta, vegetal, etc): ");
        String tipoAlimento = input.nextLine();
        this.tipoAlimento = tipoAlimento;
        
        input = new Scanner(System.in);
        System.out.print("Informe o peso do alimento em KG: ");
        double peso = input.nextDouble();
        this.pesoKG = peso;

        input = new Scanner(System.in);
        System.out.print("Informe a data de validade do alimento (DD/MM/AAAA): ");
        String dataValidade = input.nextLine();
        this.dataValidade = dataValidade;

        super.cadastrarValor();
        super.cadastrarQuantidade();
    }
}
