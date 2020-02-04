package br.com.teste.itau.entities;

public class ServicoCorreiosEntity {

	private String codigoServico;
	
	private String servico;
	
	public ServicoCorreiosEntity() {
		
	}

	public ServicoCorreiosEntity(String codigoServico, String servico) {
		
		this.codigoServico = codigoServico;
		this.servico = servico;
	}

	public String getCodigoServico() {
		return codigoServico;
	}

	public String getServico() {
		return servico;
	}

	public void setCodigoServico(String codigoServico) {
		this.codigoServico = codigoServico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	@Override
	public String toString() {
		return " - " + servico;
	}
}
