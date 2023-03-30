package com.alibaba.fastjson2.support.csv;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.lang.reflect.Type;

public class CSVParserUTF8Test {

    private CSVParserUTF8 parser;

    @BeforeEach
    public void initEach() {
        // CSVParser csvParser = CSVParser.of(new byte[0], Character.class);
        // parser = (CSVParserUTF8) csvParser;
        parser = new CSVParserUTF8(new byte[0], 0, 0, new Type[0]);
    }

    @AfterEach
    public void cleanUpEach() {
        parser = null;
    }

    @Test
    public void testReadValueFloatLength0() {
        Object value = parser.readValue(new byte[0], 0, 0, Float.class);

        assertEquals(null, value);
        assertFalse(parser.isEnd());
    }

    @Test
    public void testReadValueDoubleLength0() {
        Object value = parser.readValue(new byte[0], 0, 0, Double.class);

        assertEquals(null, value);
        assertFalse(parser.isEnd());
    }

}
