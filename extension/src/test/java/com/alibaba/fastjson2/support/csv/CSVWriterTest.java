package com.alibaba.fastjson2.support.csv;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;

public class CSVWriterTest {

    private CSVWriter writer;

    @BeforeEach
    public void initEach() {
        writer = CSVWriter.of();
    }

    @AfterEach
    public void cleanUpEach() {
        writer = null;
    }

    @Test
    public void testWriteRowObjectNull() {
        writer.writeRowObject(null);
        String csv = writer.toString();
        assertEquals("\n", csv);
    }

    @Test
    public void testWriteDateDateNull() {
        Date date = null;

        writer.writeDate(date);
        String csv = writer.toString();
        assertEquals("", csv);
    }

    @Test
    public void testWriteDateLocalDateNull() {
        LocalDate date = null;

        writer.writeDate(date);
        String csv = writer.toString();
        assertEquals("", csv);
    }

    @Test
    public void testWriteInstantNull() {
        writer.writeInstant(null);
        String csv = writer.toString();
        assertEquals("", csv);
    }

    @Test
    public void testWriteDateTimeNull() {
        writer.writeDateTime(null);
        String csv = writer.toString();
        assertEquals("", csv);
    }

    @Test
    public void testWriterOfUTF16BE() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        writer = CSVWriter.of(out, StandardCharsets.UTF_16BE);
        assertInstanceOf(CSVWriterUTF16.class, writer);
    }

    @Test
    public void testWriterOfUTF16LE() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        writer = CSVWriter.of(out, StandardCharsets.UTF_16LE);
        assertInstanceOf(CSVWriterUTF16.class, writer);
    }
}
