package com.alibaba.fastjson2.support.csv;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.Assert.assertEquals;

public class CSVWriterUTF8Int32Test {

    private CSVWriter writerDefault;
    private CSVWriterUTF8 writer;

    @BeforeEach
    public void initEach() {
        writerDefault = CSVWriter.of();
        writer = (CSVWriterUTF8) writerDefault;
    }

    @AfterEach
    public void cleanUpEach() {
        writerDefault = null;
        writer = null;
    }

    @ParameterizedTest
    @MethodSource
    public void testWriteInt32AllSizesMethodSource(int inputNumber, String expectedCSV) {
        writer.writeInt32(inputNumber);
        String actualCSV = writer.toString();
        assertEquals(expectedCSV, actualCSV);
    }

    static Stream<Arguments> testWriteInt32AllSizesMethodSource() {
        return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(12, "12"),
                Arguments.of(123, "123"),
                Arguments.of(1234, "1234"),
                Arguments.of(12345, "12345"),
                Arguments.of(123456, "123456"),
                Arguments.of(1234567, "1234567"),
                Arguments.of(12345678, "12345678"),
                Arguments.of(123456789, "123456789"),
                Arguments.of(1234567890, "1234567890"));
    }
}
