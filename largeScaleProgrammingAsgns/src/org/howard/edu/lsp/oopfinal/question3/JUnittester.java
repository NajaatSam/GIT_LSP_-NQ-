package org.howard.edu.lsp.oopfinal.question3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JUnittester {

    @Test
    void testCreateCircle() {
        Shape circle = ShapeFactory.createShape("Circle");
        assertTrue(circle instanceof Circle);
    }

    @Test
    void testCreateRectangle() {
        Shape rectangle = ShapeFactory.createShape("Rectangle");
        assertTrue(rectangle instanceof Rectangle);
    }

    @Test
    void testInvalidShape() {
        Shape shape = ShapeFactory.createShape("Triangle");
        assertNull(shape, "Shape should be null for an invalid shape type");
    }
}
