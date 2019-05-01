package com.ivanp.globalcampo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Recolecta {
	//Atributos
	private int codRec;
	private Date fecRec;
	private int kilRec;
	private int traCul;
	private String dniPerRec;
	private String desRec;
	private int codCul;
	private String nomCul;
	
	
	
	
	//METODOS

	
	public Recolecta(int codRec, Date fecRec, int kilRec, int traCul, String dniPerRec, String desRec, int codCul, String nomCul) {
		this.codRec = codRec;
		this.fecRec = fecRec;
		this.kilRec = kilRec;
		this.traCul = traCul;
		this.dniPerRec = dniPerRec;
		this.desRec = desRec;
		this.codCul = codCul;
		this.nomCul= nomCul;
	}
	


	/**
	 * @return the codRec
	 */
	public final int getCodRec() {
		return codRec;
	}

	/**
	 * @param codRec the codRec to set
	 */
	public final void setCodRec(int codRec) {
		this.codRec = codRec;
	}

	
	


	/**
	 * @return the fecRec
	 */
	public final String getFecRecString() {
		return (fecRec != null) ? new SimpleDateFormat("dd/MM/yyyy").format(fecRec) : "";
	}

	/**
	 * @return the fecRec
	 */
	public final Date getFecRec() {
		return fecRec;
	}



	/**
	 * @param fecRec the fecRec to set
	 */
	public final void setFecRec(Date fecRec) {
		this.fecRec = fecRec;
	}



	public final int getKilRec() {
		return kilRec;
	}
	/**
	 * @param kilRec the kilRec to set
	 */
	public final void setKilRec(int kilRec) {
		this.kilRec = kilRec;
	}
	/**
	 * @return the traCul
	 */
	public final int getTraCul() {
		return traCul;
	}
	/**
	 * @param traCul the traCul to set
	 */
	public final void setTraCul(int traCul) {
		this.traCul = traCul;
	}
	/**
	 * @return the dniPerRec
	 */
	public final String getDniPerRec() {
		return dniPerRec;
	}
	/**
	 * @param dniPerRec the dniPerRec to set
	 */
	public final void setDniPerRec(String dniPerRec) {
		this.dniPerRec = dniPerRec;
	}
	/**
	 * @return the desRec
	 */
	public final String getDesRec() {
		return desRec;
	}
	/**
	 * @param desRec the desRec to set
	 */
	public final void setDesRec(String desRec) {
		this.desRec = desRec;
	}
	/**
	 * @return the codCul
	 */
	public final int getCodCul() {
		return codCul;
	}
	/**
	 * @param codCul the codCul to set
	 */
	public final void setCodCul(int codCul) {
		this.codCul = codCul;
	}



	/**
	 * @return the nomCul
	 */
	public final String getNomCul() {
		return nomCul;
	}



	/**
	 * @param nomCul the nomCul to set
	 */
	public final void setNomCul(String nomCul) {
		this.nomCul = nomCul;
	}
	
	
	
	
	

}
