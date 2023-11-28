
public class Looping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long N = 0;
		long R = 0;
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

		int max = Integer.parseInt(n);

		N = counter;
		R = back(Integer.toString(counter));

		while (counter < max) {

			if ((R + N) < 0) {

				System.out.println(counter);

				counter++;

				N = counter;
				R = back(Long.toString(N));

			}

			N = (R + N);
			n = Long.toString(N);

			if (palindrome(n) == true) {

				counter++;

				N = counter;
				R = back(Long.toString(N));

			} else {

				R = back(Long.toString(N));

			}

		}

	}

	public static long back(String n) {

		String r = "";

		double R = 0;				//das muss ein double sein, da wenn es ein long ist, kommt es nicht wie in der aufgabenstellung beim addieren von N und R zum überlauf, sondern beim umdrehen von N
		char n1;

		for (int i = 1; i < n.length() + 1; i++) {

			n1 = n.charAt(n.length() - i);

			r = r + n1;

		}

		R = Double.parseDouble(r);	
		return (long) R;

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

}
