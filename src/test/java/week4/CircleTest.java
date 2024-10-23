package week4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/radii.csv")
    public void testCalculateArea(@ConvertWith(CircleConverter.class) Circle circle, double expectedArea) {
        double calculatedArea = Math.round(circle.calculateArea() * 100.0) / 100.0;
        assertEquals(expectedArea, calculatedArea);
    }
}

