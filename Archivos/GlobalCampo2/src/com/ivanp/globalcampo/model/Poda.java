package com.ivanp.globalcampo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Poda {
	//Atributos
	private int codPod;
	private Date fecPod;
	private int oliPod;
	private String desPod;
	private int codCul;
	private String nomCul;

	
	//Métodos
	//Constructor
	public Poda(int codPod, Date fecPod, int oliPod, String desPod, int codCul, String nomCul) {
		this.codPod = codPod;
		this.fecPod = fecPod;
		this.oliPod = oliPod;
		this.desPod = desPod;
		this.codCul = codCul;
		this.nomCul = nomCul;
	}




	//Getters y Setters
	/**
	 * @return the codPod
	 */
	public final int getCodPod() {
		return codPod;
	}


	/**
	 * @param codPod the codPod to set
	 */
	public final void setCodPod(int codPod) {
		this.codPod = codPod;
	}



	/**
	 * @return the fecpOD
	 */
	public final String getFecPodString() {
		return (fecPod != null) ? new SimpleDateFormat("dd/MM/yyyy").format(fecPod) : "";
	}

	/**
	 * @return the fecPod
	 */
	public final Date getFecPod() {
		return fecPod;
	}



	/**
	 * @param fecRec the fecRec to set
	 */
	public final void setFecPod(Date fecPod) {
		this.fecPod = fecPod;
	}



	/**
	 * @return the oliPod
	 */
	public final int getOliPod() {
		return oliPod;
	}


	/**
	 * @param oliPod the oliPod to set
	 */
	public final void setOliPod(int oliPod) {
		this.oliPod = oliPod;
	}


	/**
	 * @return the desPod
	 */
	public final String getDesPod() {
		return desPod;
	}


	/**
	 * @param desPod the desPod to set
	 */
	public final void setDesPod(String desPod) {
		this.desPod = desPod;
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
