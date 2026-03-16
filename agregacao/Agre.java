
import java.util.ArrayList;

class Produto {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome='" + nome + '\'' + ", preco=" + preco + '}';
    }
}

class ItemVenda {
    private int id;
    private int quantidade;
    private double valorUnitario;

    public ItemVenda(int id, int quantidade, double valorUnitario) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "id=" + id + ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario + '}';
    }
}

class Carrinho {
    private ArrayList<Produto> produtos;
    private ArrayList<ItemVenda> itensVenda;

    public Carrinho() {
        produtos = new ArrayList<>();
        itensVenda = new ArrayList<>();
    }

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public void gerarItem(int id, int qtd, float valor) {
        ItemVenda item = new ItemVenda(id, qtd, valor);
        itensVenda.add(item);
    }

    public boolean removerItemPorId(int id) {
        for (ItemVenda item : itensVenda) {
            if (item.getId() == id) {
                itensVenda.remove(item);
                return true;
            }
        }
        return false;
    }

    public void exibirCarrinho() {
        System.out.println("=== Loja Online - Carrinho de Compras ===");
        System.out.println("Produtos no carrinho (Agregação):");
        for (Produto p : produtos) {
            System.out.println(p);
        }
        System.out.println("Itens de venda no carrinho (Composição):");
        for (ItemVenda item : itensVenda) {
            System.out.println(item);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrinho{");
        sb.append("produtos=").append(produtos);
        sb.append(", itensVenda=").append(itensVenda);
        sb.append('}');
        return sb.toString();
    }
}

public class TestaLoja {
    public static void main(String[] args) {
        Produto mouse = new Produto(1, "Mouse", 50.0);
        Produto teclado = new Produto(2, "Teclado", 120.0);
        Produto monitor = new Produto(3, "Monitor", 800.0);

        Carrinho carrinho = new Carrinho();

        carrinho.adicionarProduto(mouse);
        carrinho.adicionarProduto(teclado);
        carrinho.adicionarProduto(monitor);

        carrinho.gerarItem(101, 2, 50.0f);
        carrinho.gerarItem(102, 1, 120.0f);

        carrinho.exibirCarrinho();

        System.out.println("\nEstado final do carrinho usando toString():");
        System.out.println(carrinho);
    }
}
