package org.foobarspam.model;

public class Tarifa {
	
	// Attributes

		private static double costeMilla = 1.35;
		private static double costeMinuto = 0.35;
		private static double costeMinimo = 5.00;

		// Sets & Gets

		public static double getCosteMilla() {
			return costeMilla;
		}

		public static double getCosteMinuto() {
			return costeMinuto;
		}

		public static double getCosteMinimo() {
			return costeMinimo;
		}

		// Price calculators

		public static double getCosteDistancia(double distancia) {
			return getCosteMilla() * distancia;

		}

		public static double getCosteTiempo(double tiempo) {
			return getCosteMinuto() * tiempo;
		}

		public static double getCosteTotalEsperado(double tiempo, double distancia) {
			double precioCalculado = getCosteTiempo(tiempo) + getCosteDistancia(distancia);

			if (precioCalculado >= getCosteMinimo()) {
				return precioCalculado;
			} else {
				return getCosteMinimo();
			}
		}
}
