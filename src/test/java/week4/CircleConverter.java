package week4;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class CircleConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source == null) {
            throw new ArgumentConversionException("Source cannot be null.");
        }
        if (targetType != Circle.class) {
            throw new ArgumentConversionException("Conversion target type must be Circle.");
        }
        try {
            double radius = Double.parseDouble(source.toString());
            return new Circle(radius);
        } catch (NumberFormatException e) {
            throw new ArgumentConversionException("Failed to convert radius to Circle: " + e.getMessage(), e);
        }
    }
}
