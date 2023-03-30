package com.alibaba.fastjson2.support.csv;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.Assert.assertEquals;

public class CSVWriterUTF8Int64Test {
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
    public void testWriteInt64AllSizesMethodSource(long inputNumber, String expectedCSV) {
        writer.writeInt64(inputNumber);
        String actualCSV = writer.toString();
        assertEquals(expectedCSV, actualCSV);
    }

    static Stream<Arguments> testWriteInt64AllSizesMethodSource() {
        return Stream.of(
                Arguments.of(1L, "1"),
                Arguments.of(12L, "12"),
                Arguments.of(123L, "123"),
                Arguments.of(1234L, "1234"),
                Arguments.of(12345L, "12345"),
                Arguments.of(123456L, "123456"),
                Arguments.of(1234567L, "1234567"),
                Arguments.of(12345678L, "12345678"),
                Arguments.of(123456789L, "123456789"),
                Arguments.of(1234567890L, "1234567890"),
                Arguments.of(12345678901L, "12345678901"),
                Arguments.of(123456789012L, "123456789012"),
                Arguments.of(1234567890123L, "1234567890123"),
                Arguments.of(12345678901234L, "12345678901234"),
                Arguments.of(123456789012345L, "123456789012345"),
                Arguments.of(1234567890123456L, "1234567890123456"),
                Arguments.of(12345678901234567L, "12345678901234567"),
                Arguments.of(123456789012345678L, "123456789012345678"),
                Arguments.of(1234567890123456789L, "1234567890123456789"));
    }
}
