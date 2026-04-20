package htl.steyr.fraction;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) throws DenominatorException {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public Fraction multiply(Fraction other)  {
        try {
            return new Fraction(
                    getNumerator() * other.getNumerator(),
                    getDenominator() * other.getDenominator()
            );
        } catch (DenominatorException e) {
            return null;
        }
    }

    public Fraction divide(Fraction other) throws DenominatorException {
        return new Fraction(
                getNumerator() * other.getDenominator(),
                getDenominator() * other.getNumerator()
        );
    }

    public Fraction add(Fraction other)  {
        try {
            return new Fraction(
                    getNumerator() * other.getDenominator() + other.getNumerator() * getDenominator(),
                    getDenominator() * other.getDenominator()
            );
        } catch (DenominatorException e) {
            return null;
        }
    }

    public Fraction subtract(Fraction other)  {
        try {
            return add(new Fraction(-other.getNumerator(), other.getDenominator()));
        } catch (DenominatorException e) {
            return null;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) throws DenominatorException {
        if (denominator == 0) {
            throw new DenominatorException("Denominator cannot be zero");
        }

        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
