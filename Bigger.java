
public class Bigger {

	// addiert die Ziffernfelder a und b
	public static int[] add(int[] a, int[] b) {

		int A = a.length;
		int B = b.length;

		int temp = 0;

		if (A < B) {
			temp = B;
		} else {
			temp = A;
		}

		int[] result = new int[temp + 1];

		int carry = 0;
		for (int i = 0; i < temp || carry != 0; i++) {
			int sum = carry + (i < A ? a[i] : 0) + (i < B ? b[i] : 0);
			result[i] = sum % 10;
			carry = sum / 10;
		}

		return NoNull(result);

	}

	// gibt das Ziffernfeld n in lesbarer dezimaler Form aus
	static void print(int[] n) {

		for (int j = n.length - 1; j >= 0; j--) {
			System.out.print(n[j]);
		}

	}

	// konstruiert ein einstelliges Ziffernfeld aus d
	static int[] digit(int d) {

		int[] b = new int[1];
		b[0] = d;

		return b;

	}

	// konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
	static int[] Null() {

		int[] b = new int[1009999999]; // max array lenght

		for (int j = 0; j < b.length - 1; j++) {

			b[j] = 0;

		}

		return b;

	}

	// konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
	static int[] One() {

		int[] b = new int[1];
		b[0] = 1;

		return b;
	}

	// Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
	static int mod10(int[] n) {

		int r = 0;

		if (n[0] != 0) {
			r = n[0];
		}

		return r;

	}

	// ganzzahliger Quotient bei Division durch 10
	static int[] div10(int[] n) {

		for (int j = 0; j < n.length - 1; j++) {

			n[j] = n[j + 1];

		}

		return NoNull(n);

	}

	// Umwandlung einer int-Zahl in ein Ziffernfeld
	static int[] fromInt(int n) {

		String k = Integer.toString(n);

		int[] N = new int[k.length()];

		for (int j = 0; j < k.length(); j++) {

			N[j] = Character.getNumericValue(k.charAt(j));

		}

		return NoNull(N);

	}

	// kopiert den Wert von a
	static int[] copy(int[] n) {

		int[] N = new int[n.length];

		for (int j = 0; j < n.length; j++) {

			N[j] = n[j];

		}

		return NoNull(N);

	}

	// multipliziert das Ziffernfeld a mit einer int-Zahl
	static int[] times(int[] n, int d) {

		if (d == 0) {
			int[] N = { 0 };
			return N;
		}

		int nG = n.length + (int) (Math.log10(d));
		int[] N = new int[nG];
		int ueberlauf = 0;

		for (int i = 0; i < n.length - 1 || ueberlauf != 0; i++) {
			int temp = (i < n.length) ? n[i] : 0;
			int merke = temp * d + ueberlauf;

			N[i] = merke % 10;
			ueberlauf = merke / 10;
		}

		return NoNull(N);
	}

	// multipliziert das Ziffernfeld n mit 10
	static int[] times10(int[] n) {

		return times(n, 10);

	}

	// multipliziert zwei Ziffernfelder
	static int[] times(int[] a, int[] b) {

		int[] N = Null();

		for (int j = 0; j < a.length; j++) {

			N = add(N, times(a, b[j]));

		}

		return NoNull(N);

		/* TODO */ }

	// Quadratzahl eines Ziffernfeldes
	static int[] square(int[] a) {

		return times(a, a);

	}

	// Kubikzahl eines Ziffernfeldes
	static int[] cubic(int[] a) {

		return times(square(a), a);

		/* TODO */ }

	// ist dieses Ziffernfeld ein Palindrom? Bemühen Sie sich um eine
	// Implementation,
	// die ohne ein weiteres Zahlenfeld auskommt !
	static boolean palindrom(int[] a) {

		boolean pali = true;

		for (int j = 0; j <= a.length; j++) {

			if (a[j] == a[(a.length - 1) - j] && pali == true) {

				pali = true;

			} else {
				pali = false;
			}

		}

		return pali;

	}

	// Test auf kleiner-Relation zweier Ziffernfelder: a < b ?
	static boolean less(int[] a, int[] b) {

		if (a.length < b.length) {
			return true;
		} else {

			for (int j = 0; j <= a.length; j++) {

				if (a[(a.length - 1) - j] < b[(a.length - 1) - j]) {

					return true;

				}

			}

		}

		return false;

	}

	// Test auf Gleichheit zweier Ziffernfelder
	static boolean equal(int[] a, int[] b) {

		boolean gleich = true;

		for (int j = 0; j <= a.length; j++) {

			if (a[j] == b[j] && gleich) {

				gleich = true;

			} else {
				gleich = false;
			}

		}

		return gleich;

	}

	// Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt
	// mindenstens eine Ziffer, alle Positionen liegen zwischen 0 und 9
	// keine fuehrenden Nullen (ausser bei Null selbst)
	static boolean ok(int[] n) {

		boolean ko;

		if (n[n.length - 1] == 0 && n.length > 0) {
			ko = false;
		} else {
			ko = true;

		}

		for (int j = 0; j <= n.length; j++) {

			if (n[j] >= 10) {

				ko = false;

			}
		}

		return ko;

	}

	// gibt die (kleinste) Ziffer mit der groessten Haeufigkeit in n aus
	static void maxDigit(int[] n) {

	}

	static int[] NoNull(int[] a) {

		int Zeros = 0;

		for (int j = a.length - 1; j >= 0 && a[j] == 0; j--) {

			Zeros++;

		}

		int[] NoZeroes = new int[a.length - Zeros];

		for (int j = 0; j < NoZeroes.length; j++) {

			NoZeroes[j] = a[j];

		}

		return NoZeroes;
	}

	public static void main(String[] s) {
		int[] a = One();

		for (int i = 0; i < 33222; ++i) {
			a = times(a, 2);
		}

		System.out.println("2^33222 hat " + a.length + " Stellen");
		print(a);
		System.out.println();

		int[] b = fromInt(13);
		int[] c = copy(b);

		for (int i = 1; i < 8978; ++i) {
			c = times(c, b);
		}

		System.out.println("13^8978 hat " + c.length + " Stellen");
		print(c);
		System.out.println();

		System.out.println(less(a, c)); // beantwortet die Frage aus der Aufgabenueberschrift
		maxDigit(a);
		maxDigit(c);
	}
}
