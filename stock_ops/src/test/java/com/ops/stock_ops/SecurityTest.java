package com.ops.stock_ops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityTest {
    @Test
    void hasher() {
        String text = "motdepasse";
        String result = Security.hasher(text);
        assertNotEquals(text, result);
    }
}