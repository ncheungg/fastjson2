package com.alibaba.fastjson2.support.csv;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;

public class CSVParserUTF16Test {

    private CSVParserUTF16 parser;

    @BeforeEach
    public void initEach() {
        CSVParser csvParser = CSVParser.of("");
        parser = (CSVParserUTF16) csvParser;
    }

    @AfterEach
    public void cleanUpEach() {
        parser = null;
    }

    @Test
    public void testIsEnd() {
        assertFalse(parser.isEnd());
    }

}
