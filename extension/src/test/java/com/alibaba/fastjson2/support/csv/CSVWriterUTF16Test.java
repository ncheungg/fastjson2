package com.alibaba.fastjson2.support.csv;

import com.alibaba.fastjson2.JSONException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

public class CSVWriterUTF16Test {

    private CSVWriterUTF16 writer;

    @BeforeEach
    public void initEach() {
        writer = new CSVWriterUTF16(new StringWriter());
    }

    @AfterEach
    public void cleanUpEach() {
        writer = null;
    }

    @Test
    public void testWriteRawStringThrowsNotImplemented() {
        assertThrows(JSONException.class, () -> {
            writer.writeRaw("");
        });
    }

    @Test
    public void testWriteRowThrowsNotImplemented() {
        assertThrows(JSONException.class, () -> {
            writer.writeRow(new Object());
        });
    }

    @Test
    public void testWriteStringStringThrowsNotImplemented() {
        assertThrows(JSONException.class, () -> {
            writer.writeString("asdf");
        });
    }

    @Test
    public void testWriteStringCharArrThrowsNotImplemented() {
        assertThrows(JSONException.class, () -> {
            writer.writeString(new char[0]);
        });
    }

    @Test
    public void testWriteRawCharThrowsNotImplemented() {
        assertThrows(JSONException.class, () -> {
            writer.writeRaw('a');
        });
    }

    @Test
    public void testCloseThrowsNotImplemented() {
        assertThrows(JSONException.class, () -> {
            writer.close();
        });
    }

    @Test
    public void testFlushThrowsNotImplemented() {
        assertThrows(JSONException.class, () -> {
            writer.flush();
        });
    }

    @Test
    public void testWriteStringNull() {
        String s = null;
        writer.writeString(s);

        String csv = writer.toString();
        assertTrue(csv.startsWith("com.alibaba.fastjson2.support.csv.CSVWriterUTF16@"));
    }
}
