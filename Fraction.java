package com.e.f;

/**
 * Represents a mathematical proper fraction.
 */
public class Fraction {

    private final Integer numerator;
    private final Integer denominator;

    private Fraction(Integer numerator, Integer denominator) {
        if (numerator > denominator) {
            throw new IllegalArgumentException("Invalid fraction, numerator cannot be greater than denominator");
        }

        if (denominator <= 0 || numerator <= 0) {
            throw new IllegalArgumentException("Numerator and Denominator must be positive integers");
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction getFraction(Integer numerator, Integer denominator) {
        return new Fraction(numerator, denominator);
    }

    public boolean isEgyptian() {
        return (numerator == 1) || (denominator % numerator) == 0;
    }

    public Fraction getSimplifiedFraction() {
        int numerator = 1;
        int denominator = this.denominator / this.numerator;
        return Fraction.getFraction(numerator, denominator);
    }

    /**
     *
     * @return
     */
    public Fraction calcluateClosestEgyptionFraction() {
        int remainder = this.denominator % this.numerator;
        int nextDenominator = this.denominator + (this.numerator - remainder);
        return Fraction.getFraction(this.numerator, nextDenominator).getSimplifiedFraction();
    }

    public Fraction subtract(Fraction fraction) {
        int nextNumerator = this.numerator * fraction.getDenominator() - fraction.getNumerator() * this.denominator;
        int nextDenominator = this.denominator * fraction.getDenominator();
        return Fraction.getFraction(nextNumerator, nextDenominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public Integer getNumerator() {
        return numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }


}
