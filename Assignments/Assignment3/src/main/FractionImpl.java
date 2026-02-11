package main;

public class FractionImpl implements Fraction {
    private int numerator;
    private int denominator;

    public FractionImpl(int numerator, int denominator) {
        validateDenominator(denominator);
        this.denominator = denominator;
        this.numerator = numerator;
    }

    private void validateDenominator(int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("Denominator should be positive.");
        }
    }

    @Override
    public int getDenominator() {
        return denominator;
    }

    @Override
    public int getNumerator() {
        return numerator;
    }

    @Override
    public void setNumerator(int n) {
        this.numerator = n;
    }

    @Override
    public void setDenominator(int d) {
        validateDenominator(d);
        this.denominator = d;
    }

    @Override
    public double toDouble() {
        return (double) numerator / denominator;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return Math.abs(a);
        return gcd(b, a % b);
    }

    public String toString() {
        if (numerator == 0) {
            return "0 / 1";
        }

        int divisor = gcd(numerator, denominator);
        int simplifiedNumerator = numerator / divisor;
        int simplifiedDenominator = denominator / divisor;

        return simplifiedNumerator + " / " + simplifiedDenominator;
    }

    @Override
    public Fraction reciprocal() {
        if (numerator == 0) {
            throw new IllegalArgumentException("Can not take reciprocal of zero.");
        }

        int newNumerator = denominator;
        int newDenominator = numerator;

        if (newDenominator < 0) {
            newNumerator = -newNumerator;
            newDenominator = -newDenominator;
        }

        return new FractionImpl(newNumerator, newDenominator);
    }

    @Override
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.getDenominator()
                + this.denominator * other.getNumerator();
        int newDenominator = this.denominator * other.getDenominator();

        return new FractionImpl(newNumerator, newDenominator);
    }

    @Override
    public int compareTo(Fraction other) {
        int left = other.getDenominator() * this.numerator;
        int right = this.denominator * other.getNumerator();

        return Integer.compare(left, right);
    }
}
