package Model;

public class Produto {
	private String id;
	private String codeFornecedor;
	private String nome;
	private String codBarra;
	private String lote;
	private String dataFab;
	private String dataVal;
	private String marca;
	private String categoria;
	private String unidadeDeMed;
	private String precoUn;
	private String estoque;
	
	public Produto(String id, String codeFornecedor, String nome, String codBarra, String lote, String dataFab,
			String dataVal, String marca, String categoria, String unidadeDeMed, String precoUn, String estoque) {
		super();
		this.id = id;
		this.codeFornecedor = codeFornecedor;
		this.nome = nome;
		this.codBarra = codBarra;
		this.lote = lote;
		this.dataFab = dataFab;
		this.dataVal = dataVal;
		this.marca = marca;
		this.categoria = categoria;
		this.unidadeDeMed = unidadeDeMed;
		this.precoUn = precoUn;
		this.estoque = estoque;
	}
	public Produto() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodeFornecedor() {
		return codeFornecedor;
	}
	public void setCodeFornecedor(String codeFornecedor) {
		this.codeFornecedor = codeFornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodBarra() {
		return codBarra;
	}
	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getDataFab() {
		return dataFab;
	}
	public void setDataFab(String dataFab) {
		this.dataFab = dataFab;
	}
	public String getDataVal() {
		return dataVal;
	}
	public void setDataVal(String dataVal) {
		this.dataVal = dataVal;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getUnidadeDeMed() {
		return unidadeDeMed;
	}
	public void setUnidadeDeMed(String unidadeDeMed) {
		this.unidadeDeMed = unidadeDeMed;
	}
	public String getPrecoUn() {
		return precoUn;
	}
	public void setPrecoUn(String precoUn) {
		this.precoUn = precoUn;
	}
	public String getEstoque() {
		return estoque;
	}
	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}
}