/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl;

import com.intellij.testFramework.ParsingTestCase;
import io.kusionstack.kcl.KCLParserDefinition;

/**
 * @author amyxia
 * @version KCLParsingTest: KCLParsingTest.java, v 0.1 2021年02月01日 12:00 下午 amyxia Exp $
 */
public class KCLParsingTest extends ParsingTestCase {

    public KCLParsingTest() {
        super("", "k", new KCLParserDefinition());
    }

    public void testParsingTestData() {
        doTest(true);
    }

    public void testParsingTestDataCall() {
        doTest(true);
    }

    public void testParsingTestDataName() {
        doTest(true);
    }

    public void testParsingTestDataProtocol() {
        doTest(true);
    }

    /**
     * @return path to test data file directory relative to working directory in the run configuration for this test.
     */
    @Override
    protected String getTestDataPath() {
        return "src/test/testData";
    }

    @Override
    protected boolean skipSpaces() {
        return false;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }

}