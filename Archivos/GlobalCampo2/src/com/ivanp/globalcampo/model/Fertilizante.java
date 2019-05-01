package com.ivanp.globalcampo.model;

public class Fertilizante {
	//Atributos
	private int codFer;
	private String nomFer;
	private String desFer;
	private String tipCulFer;
	private String uniFer;
	
	//Metodos
	
	public Fertilizante(int codFer, String nomFer, String desFer, String tipCulFer, String uniFer) {
		this.codFer = codFer;
		this.nomFer = nomFer;
		this.desFer = desFer;
		this.tipCulFer = tipCulFer;
		this.uniFer = uniFer;
	}


	public final int getCodFer() {
		return codFer;
	}


	public final void setCodFer(int codFer) {
		this.codFer = codFer;
	}

	/**
	 * @return the nomFer
	 */
	public final String getNomFer() {
		return nomFer;
	}

	/**
	 * @param nomFer the nomFer to set
	 */
	public final void setNomFer(String nomFer) {
		this.nomFer = nomFer;
	}

	/**
	 * @return the desFer
	 */
	public final String getDesFer() {
		return desFer;
	}

	/**
	 * @param desFer the desFer to set
	 */
	public final void setDesFer(String desFer) {
		this.desFer = desFer;
	}

	/**
	 * @return the tipCulFer
	 */
	public final String getTipCulFer() {
		return tipCulFer;
	}

	/**
	 * @param tipCulFer the tipCulFer to set
	 */
	public final void setTipCulFer(String tipCulFer) {
		this.tipCulFer = tipCulFer;
	}

	/**
	 * @return the uniFer
	 */
	public final String getUniFer() {
		return uniFer;
	}

	/**
	 * @param uniFer the uniFer to set
	 */
	public final void setUniFer(String uniFer) {
		this.uniFer = uniFer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fertilizante [codCul=" + codFer + ", nomFer=" + nomFer + ", desFer=" + desFer + ", tipCulFer="
				+ tipCulFer + ", uniFer=" + uniFer + "]";
	}
	
	
	
	
	
}
