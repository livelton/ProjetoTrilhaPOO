public class EstoqueApp {
  public static void main(String[] args) {
    Menu pagMenu = new Menu();
    CadastroProduto cadastro = new CadastroProduto();
    ArmazenarProdutos armazenamento = new ArmazenarProdutos();

    pagMenu.setCadastro(cadastro);
    cadastro.setMenu(pagMenu);
    cadastro.setArmazenamento(armazenamento);
    armazenamento.setMenu(pagMenu);
    pagMenu.menu();

  }
}