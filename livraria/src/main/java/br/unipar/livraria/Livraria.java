package br.unipar.livraria;

import br.unipar.livraria.model.Cliente;
import br.unipar.livraria.model.Endereco;
import br.unipar.livraria.model.Livro;
import java.util.Locale;
import javax.swing.JOptionPane;

public class Livraria {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Livro[] livros = addLivros();
        Cliente cliente = attCadastroCliente();

        if (cliente != null) {
            JOptionPane.
                    showMessageDialog(null, cliente.toString());
            addVenda(cliente, livros);
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada.");
        }
    }

    private static Livro[] addLivros() {
        Livro[] livros = new Livro[3];
        for (int i = 0; i < livros.length; i++) {
            livros[i] = addLivro();
        }
        return livros;
    }

    private static Livro addLivro() {
        Livro lvr = new Livro();
        lvr.setNomeLivro(JOptionPane.
                showInputDialog("Informe o nome do livro: "));
        lvr.setAnoLancamento(Integer.parseInt(JOptionPane.
                showInputDialog("Ano de lançamento: ")));
        lvr.setAutores(JOptionPane.
                showInputDialog("Nome dos autores "));
        lvr.setEditora(JOptionPane.
                showInputDialog("Informe o nome da editora: "));
        lvr.setGenero(JOptionPane.
                showInputDialog("Informe o gênero: "));
        lvr.setNumeroPag(Integer.parseInt(JOptionPane.
                showInputDialog("Número de Páginas: ")));
        lvr.setQtdEstoque(Integer.parseInt(JOptionPane.
                showInputDialog("Quantidade em estoque: ")));
        lvr.setPrecoVenda(Double.parseDouble(JOptionPane.
                showInputDialog("Preço de venda: ")));

        JOptionPane.showMessageDialog(null, lvr.toString());
        return lvr;
    }

    private static Cliente attCadastroCliente() {
        Cliente cliente = verificarCliente();
        while (true) {
            int opcao = JOptionPane.showOptionDialog(
                    null, "Escolha uma opção:", "Cadastro/Atualização de Cliente",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    new String[]{"Cadastrar Novo Cliente", "Atualizar Cliente", "Cancelar"}, null);
            if (opcao == 0) {
                cliente = addCliente();
                break;
            } else if (opcao == 1) {
                if (cliente != null) {
                    cliente = attCliente(cliente);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado, cadastre um novo cliente.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                return null;
            }
        }
        return cliente;
    }

    private static Cliente addCliente() {
        Cliente cliente = new Cliente();
        cliente.setNomeCompleto(JOptionPane.
                showInputDialog("Informe o nome completo do cliente: "));
        cliente.setTelefone(JOptionPane.
                showInputDialog("Informe o telefone do cliente: "));
        cliente.setCpf(JOptionPane.
                showInputDialog("Informe o CPF do cliente: "));
        Endereco endereco = addEndereco();
        cliente.setEndereco(endereco);

        return cliente;
    }

    private static Cliente attCliente(Cliente cliente) {
        Endereco endereco = addEndereco();
        cliente.setEndereco(endereco);
        return cliente;
    }

    private static Endereco addEndereco() {
        Endereco endereco = new Endereco();
        endereco.setCidade(JOptionPane.
                showInputDialog("Informe a cidade: "));
        endereco.setRua(JOptionPane.
                showInputDialog("Informe o nome da rua: "));
        endereco.setNum(Integer.parseInt(JOptionPane.
                showInputDialog("Número da casa: ")));
        endereco.setBairro(JOptionPane.
                showInputDialog("Bairro: "));
        endereco.setEstado(JOptionPane.
                showInputDialog("Estado: "));
        endereco.setPais(JOptionPane.
                showInputDialog("País: "));
        return endereco;
    }

    private static Cliente verificarCliente() {
        return null;
    }

    private static void addVenda(Cliente cliente, Livro[] livros) {
        double valorTot = 0.0;
        String itensVenda = "";

        for (Livro livro : livros) {
            int qtdVendaItem = Integer.parseInt(JOptionPane.
                    showInputDialog("Informe a quantidade de " + livro.getNomeLivro() + " a ser comprada: "));

            if (qtdVendaItem > livro.getQtdEstoque()) {
                JOptionPane.showMessageDialog(null, "Quantidade em estoque insuficiente para o livro " + livro.getNomeLivro());
                continue;
            }
            livro.setQtdEstoque(livro.getQtdEstoque() - qtdVendaItem);

            double vlUnitario = livro.getPrecoVenda();
            double vlDesconto = 0.0;
            double valorTotItem = (vlUnitario - vlDesconto) * qtdVendaItem;
            valorTot += valorTotItem;

            itensVenda += qtdVendaItem + " x " + livro.getNomeLivro() + ": $" + valorTotItem + "\n";
        }
        String formaPagto = FormaPgto();
        if (formaPagto.equalsIgnoreCase("PIX")
                || formaPagto.equalsIgnoreCase("Dinheiro")) {
            valorTot -= calcularDesc(valorTot);
        }
        JOptionPane.showMessageDialog(null, "Itens da Venda:\n" + itensVenda
                + "\nValor Total da Venda: $" + valorTot);
        String estoqueAtual = "Quantidade em estoque:\n";
        for (Livro livro : livros) {
            estoqueAtual += livro.getNomeLivro() + ": " + livro.getQtdEstoque() + " unidades\n";
        }
        JOptionPane.showMessageDialog(null, estoqueAtual);
    }

    private static String FormaPgto() {
        String[] opcoesPagamento = {"Crédito", "Débito", "PIX", "Dinheiro"};
        int escolha = JOptionPane.
                showOptionDialog(null, "Escolha a forma de pagamento:", "Forma de Pagamento",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.
                        QUESTION_MESSAGE, null, opcoesPagamento, opcoesPagamento[0]);

        return opcoesPagamento[escolha];
    }

    private static double calcularDesc(double valorTotalVenda) {
        double porcentagemDesconto = 0.1;
        return valorTotalVenda * porcentagemDesconto;
    }
}
