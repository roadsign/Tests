package test;

public class VectorCalculus {

	// considerando que o tamanho dos vetores sao iguais

	public static void main(String[] args) {
		double[] a = new double[] { 3, 4, 5 };
		double[] b = new double[] { 1, 2, 1 };

		double angleCos = cosineBetweenVectors(a, b);

		System.out.printf("Cosine between a and b: %.2f\n", angleCos);
		System.out.printf("Angle:  %.2f radians \n", Math.acos(angleCos));

	}

	public static double cosineBetweenVectors(double[] a, double[] b) {
		if (a.length != b.length)
			throw new ArithmeticException();
		if (a.length == 0)
			return 1;
		return dotProduct(a, b) / (length(a) * length(b));
	}
	
	public static double sineBetweenVectors(double[] a, double[] b) {
		double cosine = cosineBetweenVectors(a, b);
		return Math.sqrt(1 - cosine * cosine);
	}
	
	public static double length(double[] a) {
		double result = 0;

		for (double v : a)
			result += v * v;

		return Math.sqrt(result);
	}

	public static double dotProduct(double[] a, double[] b) {
		if (a.length != b.length)
			throw new ArithmeticException();
		
		double result = 0;

		for (int i = 0; i < a.length; i++)
			result += a[i] * b[i];

		return result;
	}

	public static double[] crossProduct(double[] a, double[] b) {
		if (a.length != 3 || b.length != 3)
			throw new ArithmeticException();

		double i, j, k;

		i = a[1] * b[2] - a[2] * b[1];
		j = a[2] * b[0] - a[0] * b[2];
		k = a[0] * b[1] - a[1] * b[0];

		return new double[] { i, j, k };
	}

	public static double[] normalize(double[] vector) {
		double[] normalizedVector = new double[vector.length];
		double paramLength = length(vector);

		if (paramLength == 0)
			throw new ArithmeticException();

		for (int i = 0; i < vector.length; i++)
			normalizedVector[i] = vector[i] / paramLength;

		return normalizedVector;
	}

	public static void printVector(double[] vector) {
		StringBuffer out = new StringBuffer();
		out.append("< ");
		for (int i = 0; i < vector.length; i++) {
			out.append(vector[i]);
			if (i < vector.length - 1)
				out.append(", ");
			else
				out.append(" >");
		}
		System.out.println(out.toString());
	}
	
}
