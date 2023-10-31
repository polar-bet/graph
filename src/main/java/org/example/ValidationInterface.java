package org.example;

public interface ValidationInterface <T> {
    default boolean isInteger(T value) {
        try {
            Integer.parseInt(String.valueOf(value));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
