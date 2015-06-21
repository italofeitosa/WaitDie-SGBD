package br.ufc.sgbd;

public class Transacao {
	
	private String transacao;
	private int timeout;
	
	public Transacao(String transacao, int timeout) {
		this.setTransacao(transacao);
		this.setTimeout(timeout);
	}

	/**
	 * @return the transacao
	 */
	public String getTransacao() {
		return transacao;
	}

	/**
	 * @param transacao the transacao to set
	 */
	public void setTransacao(String transacao) {
		this.transacao = transacao;
	}

	/**
	 * @return the timeout
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
