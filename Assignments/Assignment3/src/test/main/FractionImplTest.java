package test.main;

import static org.junit.jupiter.api.Assertions.*;

import main.Fraction;
import main.FractionImpl;
import org.junit.jupiter.api.Test;

class FractionImplTest {

    @Test
    void testConstructionPositive() {
        FractionImpl f = new FractionImpl(3, 4);
        assertEquals(3, f.getNumerator());
        assertEquals(4, f.getDenominator());
    }

    @Test
    void testConstructionNegative() {
        FractionImpl f = new FractionImpl(-3, 4);
        assertEquals(-3, f.getNumerator());
        assertEquals(4, f.getDenominator());
    }

    @Test
    void testNumeratorZero() {
        FractionImpl f = new FractionImpl(0, 4);
        assertEquals(0, f.getNumerator());
        assertEquals(4, f.getDenominator());
        assertEquals("0 / 1", f.toString());
    }

    @Test
    void testDenominatorZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new FractionImpl(3, 0));
    }

    @Test
    void testDenominatorNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new FractionImpl(3, -4));
    }

    @Test
    void testSetNumerator() {
        FractionImpl f = new FractionImpl(3, 4);
        f.setNumerator(5);
        assertEquals(5, f.getNumerator());
    }

    @Test
    void testSetDenominator() {
        FractionImpl f = new FractionImpl(3, 4);
        f.setDenominator(5);
        assertEquals(5, f.getDenominator());
    }

    @Test
    void testSetDenominatorInvalid() {
        FractionImpl f = new FractionImpl(3, 4);
        assertThrows(IllegalArgumentException.class, () -> f.setDenominator(0));
    }

    @Test
    void testToDoubleTypical() {
        FractionImpl f = new FractionImpl(3, 4);
        assertEquals(0.75, f.toDouble());
    }

    @Test
    void testToDoubleNegative() {
        FractionImpl f = new FractionImpl(-3, 4);
        assertEquals(-0.75, f.toDouble());
    }

    @Test
    void testToStringTypical() {
        FractionImpl f = new FractionImpl(4, 2);
        assertEquals("2 / 1", f.toString());
    }

    @Test
    void testToStringNegative() {
        FractionImpl f = new FractionImpl(-4, 2);
        assertEquals("-2 / 1", f.toString());
    }

    @Test
    void testToStringZero() {
        FractionImpl f = new FractionImpl(0, 2);
        assertEquals("0 / 1", f.toString());
    }

    @Test
    void testReciprocalTypical() {
        FractionImpl f = new FractionImpl(3, 4);
        Fraction r = f.reciprocal();
        assertEquals("4 / 3", r.toString());
    }

    @Test
    void testReciprocalNegative() {
        FractionImpl f = new FractionImpl(-3, 4);
        Fraction r = f.reciprocal();
        assertEquals("-4 / 3", r.toString());
    }

    @Test
    void testReciprocalZero() {
        FractionImpl f = new FractionImpl(0, 4);
        assertThrows(IllegalArgumentException.class,
                f::reciprocal);
    }

    @Test
    void testAddSameDenominator() {
        FractionImpl f1 = new FractionImpl(3, 4);
        FractionImpl f2 = new FractionImpl(2, 4);
        Fraction s = f1.add(f2);
        assertEquals("5 / 4", s.toString());
    }

    @Test
    void testAddDifferentDenominator() {
        FractionImpl f1 = new FractionImpl(3, 4);
        FractionImpl f2 = new FractionImpl(3, 2);
        Fraction s = f1.add(f2);
        assertEquals("9 / 4", s.toString());
    }

    @Test
    void testAddNegative() {
        FractionImpl f1 = new FractionImpl(3, 4);
        FractionImpl f2 = new FractionImpl(-3, 4);
        Fraction s = f1.add(f2);
        assertEquals("0 / 1", s.toString());
    }

    @Test
    void testAddZero() {
        FractionImpl f1 = new FractionImpl(3, 4);
        FractionImpl f2 = new FractionImpl(0, 4);
        Fraction s = f1.add(f2);
        assertEquals("3 / 4", s.toString());
    }

    @Test
    void testCompareToLarger() {
        FractionImpl f1 = new FractionImpl(3, 4);
        FractionImpl f2 = new FractionImpl(1, 4);
        assertTrue(f1.compareTo(f2) > 0);
    }

    @Test
    void testCompareToSmaller() {
        FractionImpl f1 = new FractionImpl(3, 4);
        FractionImpl f2 = new FractionImpl(5, 4);
        assertTrue(f1.compareTo(f2) < 0);
    }

    @Test
    void testCompareToEqual() {
        FractionImpl f1 = new FractionImpl(3, 4);
        FractionImpl f2 = new FractionImpl(3, 4);
        assertEquals(0, f1.compareTo(f2));
    }

    @Test
    void testCompareToDifferentSigns() {
        FractionImpl f1 = new FractionImpl(-3, 4);
        FractionImpl f2 = new FractionImpl(1, 4);
        assertTrue(f1.compareTo(f2) < 0);
    }
}