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

    @Test
    public void testWriteRowObject() {
        CSVWriter rowObjectWriter = CSVWriter.of();

        // Test case for null object
        Object nullObj = null;
        rowObjectWriter.writeRowObject(nullObj);
        assertEquals("writeRow() should be called when object is null", "\n", rowObjectWriter.toString());

        // Test case for object with single field
        SingleFieldObject singleFieldObj = new SingleFieldObject("test");
        rowObjectWriter.writeRowObject(singleFieldObj);
        assertEquals("writeRowObject() should write the value of the single field", "\ntest\n",
                rowObjectWriter.toString());

        // Test case for object with multiple fields
        MultiFieldObject multiFieldObj = new MultiFieldObject(1, "test");
        rowObjectWriter.writeRowObject(multiFieldObj);
        assertEquals("writeRowObject() should write the values of all fields", "\ntest\n1,test\n",
                rowObjectWriter.toString());
    }

    // Test classes for the test cases
    private static class SingleFieldObject {
        public String field;

        public SingleFieldObject(String field) {
            this.field = field;
        }
    }

    private static class MultiFieldObject {
        public int intField;
        public String stringField;

        public MultiFieldObject(int intField, String stringField) {
            this.intField = intField;
            this.stringField = stringField;
        }
    }
}
