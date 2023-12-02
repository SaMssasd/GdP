import java.math.BigInteger;

public class Looping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean x = false;
		boolean ueberlauf = false;
		int iterationen = 0;

		BigInteger N;

		BigInteger R = new BigInteger("0");

		BigInteger MAX_VALUE_LONG = BigInteger.valueOf(Long.MAX_VALUE);

		int counter = 0;

		if (args.length == 0) {
			System.out.println("Bitte geben Sie die Obergrenze als Parameter an.");
			System.exit(0);

		}

		String n = args[0];

		for (int j = 0; j <= n.length() - 1; j++) {

			if (n.charAt(j) == ('0') || n.charAt(j) == ('1') || n.charAt(j) == ('2') || n.charAt(j) == ('3')
					|| n.charAt(j) == ('4') || n.charAt(j) == ('5') || n.charAt(j) == ('6') || n.charAt(j) == ('7')
					|| n.charAt(j) == ('8') || n.charAt(j) == ('9')) {

			} else {

				System.out.println("Bitte geben Sie nur Zahlen an");
				System.exit(0);

			}
		}

		if (Integer.parseInt(n) > 100000) {

			System.out.println("Bitte nicht größenwahnsinnig werden");
			System.exit(0);

		}

		if (args.length == 2) {

			if (args[1].charAt(0) == 'x') {

				x = true;

			} else {

				System.out.println("Falsche zweite eingabe");

				System.exit(0);
			}
		}

		int max = Integer.parseInt(n);

		N = new BigInteger(Integer.toString(counter));

		R = new BigInteger(back((Long.toString(counter))));

		while (counter < max) {

			if ((R.add(N)).compareTo(MAX_VALUE_LONG) > 0) {

				if (!x) {

					System.out.println(counter);

				} else {

					ueberlauf = extra(N, iterationen, counter);

				}

				counter++;
				iterationen = 0;

				N = new BigInteger(Integer.toString(counter));

				R = new BigInteger(back((N.toString())));

			}

			// N = (R + N);
			N = R.add(N);

			// n = Long.toString(N);
			n = N.toString();

			if (palindrome(n) == true) {

				counter++;

				N = new BigInteger(Integer.toString(counter));

				R = new BigInteger(back((N.toString())));

			} else {

				R = new BigInteger(back((N.toString())));

			}

			iterationen++;

		}

		if (ueberlauf) {

			System.out.println("alle Zahlen werden auch durch Abbruch per Ueberlauf gefunden");

		}

	}

	public static String back(String n) {

		String r = "";

		char n1;

		for (int i = 1; i < n.length() + 1; i++) {

			n1 = n.charAt(n.length() - i);

			r = r + n1;

		}

		return r;

	}

	public static boolean palindrome(String n) {

		boolean pali = true;
		int i = 0;

		while (i < n.length() - 2) {

			if (n.charAt(i) == n.charAt((n.length() - 1) - i) && pali == true) {

				pali = true;

			} else {
				pali = false;
			}

			i++;

		}

		return pali;
	}

	public static boolean extra(BigInteger N, int iterationen, int counter) {
		int itterations = iterationen;
		
		String n = "";

		BigInteger Nplus = N;
		BigInteger Rplus = new BigInteger(back((Nplus.toString())));

		if (itterations > 100) {

		} else {

			while (itterations < 100) {

				Nplus = Rplus.add(Nplus);

				n = Nplus.toString();

				if (palindrome(n) == true) {

					System.out.println(counter + " braucht " + itterations + " Iterationen bis zum Palindrom " + n);
					System.exit(0);

				} else {

					Nplus = Rplus.add(Nplus);
					Rplus = new BigInteger(back((Nplus.toString())));

					itterations++;

				}

			}

		}

		return true;

	}

}
