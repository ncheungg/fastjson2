package com.alibaba.fastjson2.support.csv;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.alibaba.fastjson2.JSONException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class CSVWriterUTF8Test {

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

    @Test
    public void testWriteRowNullValueCollection() {
        Object[] values = { null, null };
        writer.writeRow(values);

        String csv = writer.toString();
        assertEquals(",\n", csv);
    }

    @Test
    public void testWriteRowOptionalValidValueCollection() {
        Object[] values = { Optional.of(3), Optional.of(4) };
        writer.writeRow(values);

        String csv = writer.toString();
        assertEquals("3,4\n", csv);
    }

    @Test
    public void testWriteRowOptionalEmptyValueCollection() {
        Object[] values = { Optional.empty(), Optional.empty() };
        writer.writeRow(values);

        String csv = writer.toString();
        assertEquals(",\n", csv);
    }

    @Test
    public void testWriteRawStringNull() {
        String s = null;
        writer.writeRaw(s);

        String csv = writer.toString();
        assertEquals("", csv);
    }

    @Test
    public void testWriteRowBooleanObjects() {
        Object[] values = { new Boolean(true), new Boolean(false) };
        writer.writeRow(values);

        String csv = writer.toString();
        assertEquals("true,false\n", csv);
    }

    @Test
    public void testWriteDirect() {
        byte[] bytes = "true,false\n".getBytes();
        writer.writeDirect(bytes, 0, bytes.length);

        String csv = writer.toString();
        assertEquals("true,false\n", csv);
    }

    @Test
    public void testWriteRawChar() {
        char a = 'a';
        char b = 'b';

        writer.writeRaw(a);
        writer.writeRaw(b);

        String csv = writer.toString();
        assertEquals("ab", csv);
    }

    @Test
    public void testWriteRawCharInvalidRange() {
        char a = (char) -1;
        assertThrows(JSONException.class, () -> {
            writer.writeRaw(a);
        });

        char b = (char) 128;
        assertThrows(JSONException.class, () -> {
            writer.writeRaw(b);
        });
    }

    @Test
    public void testWriteStringNull() {
        writer.writeString(null);

        String csv = writer.toString();
        assertEquals("", csv);
    }

    @Test
    public void testWriteStringEmpty() {
        writer.writeString("");

        String csv = writer.toString();
        assertEquals("", csv);
    }

    // @Test
    // public void testWriteStringQuoteCharacters() {
    // writer.writeString("hello world");

    // String csv = writer.toString();
    // assertEquals("hello world", csv);
    // }

    @Test
    public void testWriteFloat() {
        writer.writeFloat(3.14159f);

        String csv = writer.toString();
        assertEquals("3.14159", csv);
    }

    @Test
    public void testWriteFloat2() {
        float f = Float.MAX_VALUE;
        writer.writeFloat(f);

        String csv = writer.toString();
        assertEquals("3.4028235E38", csv);
    }

    @Test
    public void testWriteFloat3() {
        float f = -Float.MAX_VALUE;
        writer.writeFloat(f);

        String csv = writer.toString();
        assertEquals("-3.4028235E38", csv);
    }

    @Test
    public void testWriteFloatPositiveInfinite() {
        writer.writeFloat(Float.POSITIVE_INFINITY);

        String csv = writer.toString();
        assertEquals("", csv);
    }

    @Test
    public void testWriteFloatNegativeInfinite() {
        writer.writeFloat(Float.NEGATIVE_INFINITY);

        String csv = writer.toString();
        assertEquals("", csv);
    }

    @Test
    public void testWriteFloatNan() {
        writer.writeFloat(Float.NaN);

        String csv = writer.toString();
        assertEquals("", csv);
    }

    @Test
    public void testWriteBooleanTrue() {
        writer.writeBoolean(true);

        String csv = writer.toString();
        assertEquals("true", csv);
    }

    @Test
    public void testWriteBooleanFalse() {
        writer.writeBoolean(false);

        String csv = writer.toString();
        assertEquals("false", csv);
    }

    @Test
    public void testWriteDecimal() {
        writer.writeDecimal(new BigDecimal("3.14159"));

        String csv = writer.toString();
        assertEquals("3.14159", csv);
    }

    @Test
    public void testWriteDecimalNull() {
        writer.writeDecimal(null);

        String csv = writer.toString();
        assertEquals("", csv);
    }

}
