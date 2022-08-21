package com.e.f;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a fractional number, prints the sequence of egyptian fractions for it
 */
public class PrintEgyptianFraction {

    public static void main(String[] args) {

        Fraction fraction = Fraction.getFraction(7, 51);
        List<Fraction> egyptianFractions = new ArrayList<>();

        if (fraction.isEgyptian()) { // Base case in case the given fraction is already an egyptian fraction
            fraction = fraction.getSimplifiedFraction();
            int egyptianMultiplier = fraction.getDenominator();
            for (int i = 0; i < egyptianMultiplier; i++) {
                egyptianFractions.add(fraction);
            }
        } else {

            // Loop till you find the final egyptian fraction
            while (!fraction.isEgyptian()) {
                Fraction nextEgyptianFraction = fraction.calcluateClosestEgyptionFraction();
                egyptianFractions.add(nextEgyptianFraction);
                fraction = fraction.subtract(nextEgyptianFraction);
            }
            egyptianFractions.add(fraction.getSimplifiedFraction()); // Add the final fraction
        }

        System.out.println("Printing Egyptian Fractions");
        egyptianFractions.forEach(System.out::println);
    }
}
