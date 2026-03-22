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
}

class Cliente {
    private int id;
    private String nome;

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

class ItemVenda {
    private int id;
    private int quantidade;
    private Produto produto;

    public ItemVenda(int id, int quantidade, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getSubtotal() {
        return quantidade * produto.getPreco();
    }
}

class Venda {
    private Cliente cliente;
    private ArrayList<ItemVenda> itens;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(int id, int quantidade, Produto produto) {
        ItemVenda novoItem = new ItemVenda(id, quantidade, produto);
        this.itens.add(novoItem);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto(1, "Arroz 5kg", 25.90);
        Produto produto2 = new Produto(2, "Feijao 1kg", 8.50);
        
        Cliente cliente = new Cliente(1, "Maria Silva");
        
        Venda venda = new Venda(cliente);
        
        venda.adicionarItem(1, 2, produto1);
        venda.adicionarItem(2, 3, produto2);
        
        System.out.println("Cliente: " + venda.getCliente().getNome());
        for (ItemVenda item : venda.getItens()) {
            System.out.println(item.getQuantidade() + "x " + item.getProduto().getNome() + " - Subtotal: R$" + item.getSubtotal());
        }
        System.out.println("Total da Venda: R$" + venda.calcularTotal());
    }
}
