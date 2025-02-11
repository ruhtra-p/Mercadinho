package Model;

public class Venda {
	private String id;
	private String codeCliente;
	private String codeFuncionario;
	private String formaDePagamento;
	private String dataVenda;
	private String desconto;
	private String precoTotal;
	
	public Venda() {
		super();
	}
	public Venda(String id, String codeCliente, String codeFuncionario, String formaDePagamento, String dataVenda,
			String desconto, String precoTotal) {
		super();
		this.id = id;
		this.codeCliente = codeCliente;
		this.codeFuncionario = codeFuncionario;
		this.formaDePagamento = formaDePagamento;
		this.dataVenda = dataVenda;
		this.desconto = desconto;
		this.precoTotal = precoTotal;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodeCliente() {
		return codeCliente;
	}
	public void setCodeCliente(String codeCliente) {
		this.codeCliente = codeCliente;
	}
	public String getCodeFuncionario() {
		return codeFuncionario;
	}
	public void setCodeFuncionario(String codeFuncionario) {
		this.codeFuncionario = codeFuncionario;
	}
	public String getFormaDePagamento() {
		return formaDePagamento;
	}
	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	public String getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}
	public String getDesconto() {
		return desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}
	public String getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(String precoTotal) {
		this.precoTotal = precoTotal;
	}
}