package library;

public class HexaConverter {

    //Classe tirée d'internet

	public static String intToHex(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Le nombre doit être positif");
		}
		return Integer.toHexString(number).toUpperCase();
	}

	public static int hexToInt(String hex) {
		if (hex == null || hex.isEmpty()) {
			throw new IllegalArgumentException("Entrée hexadécimale invalide");
		}
		try {
			return Integer.parseInt(hex, 16);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Entrée hexadécimale invalide", e);
		}
	}

}
