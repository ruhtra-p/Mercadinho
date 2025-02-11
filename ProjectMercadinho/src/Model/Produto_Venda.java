package Model;

public class Produto_Venda {
	
	private String id;
	private String codeProduto;
	private String codeVenda;
	private String quantidade;
	
	public Produto_Venda() {
		super();
	}

	public Produto_Venda(String id, String codeProduto, String codeVenda, String quantidade) {
		super();
		this.id = id;
		this.codeProduto = codeProduto;
		this.codeVenda = codeVenda;
		this.quantidade = quantidade;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodeProduto() {
		return codeProduto;
	}
	public void setCodeProduto(String codeProduto) {
		this.codeProduto = codeProduto;
	}
	public String getCodeVenda() {
		return codeVenda;
	}
	public void setCodeVenda(String codeVenda) {
		this.codeVenda = codeVenda;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
}