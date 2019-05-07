package com.ivanp.globalcampo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tratamiento {
	//Atributos
		private int codTra;
		private Date fecTra;
		private String desTra;
		private String tipTra;
		private int codCul;
		private int codFer;
		private String nomCul;
		private String nomFer;

	
	//Métodos
		public Tratamiento(int codTra, Date fecTra, String desTra, String tipTra, int codCul, int codFer, String nomCul, String nomFer) {
			this.codTra = codTra;
			this.fecTra = fecTra;
			this.desTra = desTra;
			this.tipTra = tipTra;
			this.codCul = codCul;
			this.codFer = codFer;
			this.nomCul = nomCul;
			this.nomFer = nomFer;
		}


		/**
		 * @return the codTra
		 */
		public final int getCodTra() {
			return codTra;
		}


		/**
		 * @param codTra the codTra to set
		 */
		public final void setCodTra(int codTra) {
			this.codTra = codTra;
		}


		/**
		 * @return the desTra
		 */
		public final String getDesTra() {
			return desTra;
		}


		/**
		 * @param desTra the desTra to set
		 */
		public final void setDesTra(String desTra) {
			this.desTra = desTra;
		}


		/**
		 * @return the tipTra
		 */
		public final String getTipTra() {
			return tipTra;
		}


		/**
		 * @param tipTra the tipTra to set
		 */
		public final void setTipTra(String tipTra) {
			this.tipTra = tipTra;
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
		 * @return the codFer
		 */
		public final int getCodFer() {
			return codFer;
		}


		/**
		 * @param codFer the codFer to set
		 */
		public final void setCodFer(int codFer) {
			this.codFer = codFer;
		}
		
		

		public final String getFecTraString() {
			return (fecTra != null) ? new SimpleDateFormat("dd/MM/yyyy").format(fecTra) : "";
		}

		public final Date getFecTra() {
			return fecTra;
		}

		public final void setFecTra(Date fecTra) {
			this.fecTra = fecTra;
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

		
		
		
		
}
