package com.ivanp.globalcampo.model;

public class Cultivo {

    //Atributos
    private int codCul;
    private String nomCul;
    private String desCul;
    private String regCul;
    private String copeCul;

    //Métodos
    //Constructor vacio

    public Cultivo(int CodCul, String NomCul, String DesCul, String RegCul, String CopeCul) {
        this.codCul = CodCul;
        this.nomCul = NomCul;
        this.desCul = DesCul;
        this.regCul = RegCul;
        this.copeCul = CopeCul;
    }

    
    //Getters Y Setters

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


	/**
	 * @return the desCul
	 */
	public final String getDesCul() {
		return desCul;
	}


	/**
	 * @param desCul the desCul to set
	 */
	public final void setDesCul(String desCul) {
		this.desCul = desCul;
	}


	/**
	 * @return the regCul
	 */
	public final String getRegCul() {
		return regCul;
	}


	/**
	 * @param regCul the regCul to set
	 */
	public final void setRegCul(String regCul) {
		this.regCul = regCul;
	}


	/**
	 * @return the copeCul
	 */
	public final String getCopeCul() {
		return copeCul;
	}


	/**
	 * @param copeCul the copeCul to set
	 */
	public final void setCopeCul(String copeCul) {
		this.copeCul = copeCul;
	}


	@Override
    public String toString() {
        return "Cultivo{" + "CodCul=" + codCul + ", NomCul=" + nomCul + ", DesCul=" + desCul + ", RegCul=" + regCul + ", CopeCul=" + copeCul + '}';
    }
    
    

}

