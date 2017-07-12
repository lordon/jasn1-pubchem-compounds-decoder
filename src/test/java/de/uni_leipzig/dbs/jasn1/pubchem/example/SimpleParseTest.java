package de.uni_leipzig.dbs.jasn1.pubchem.example;

import java.io.BufferedInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance.PCCompounds;
import de.uni_leipzig.dbs.jasn1.pubchem.util.PubchemGzipInputStream;
import de.uni_leipzig.dbs.jasn1.pubchem.util.PubchemResourceAnchor;

public class SimpleParseTest {

  /**
   * Tests whether the parse of two sample Compounds return any error.
   */
  @Test
  public void parseTwoFilesTest() throws Exception {
    PCCompounds compounds = new PCCompounds();
    PubchemGzipInputStream gzip = new PubchemGzipInputStream(
        PubchemResourceAnchor.getSomeGZippedCompounds());
    compounds.decode(gzip);
    gzip.close();
    compounds = new PCCompounds();
    BufferedInputStream is = new BufferedInputStream(PubchemResourceAnchor.getSomeCompounds());
    compounds.decode(is);
    is.close();
  }

  /**
   * Checks if the outcome of the parse is affected.
   */
  @Test
  public void parseAndCheckForDifferences() throws Exception {
    PCCompounds compounds = new PCCompounds();
    PubchemGzipInputStream gzip = new PubchemGzipInputStream(
        PubchemResourceAnchor.getSomeGZippedCompounds());
    compounds.decode(gzip);
    gzip.close();
    /**
     * read toString file
     */
    InputStream is = PubchemResourceAnchor.getSomeGZippedCompoundstoString();
    StringBuilder build = new StringBuilder();
    int bufLen = 1000;
    int readBytes;
    byte buf[] = new byte[bufLen];
    readBytes = is.read(buf);
    while (readBytes != -1) {
      build.append(new String(buf, 0, readBytes));
      readBytes = is.read(buf);
    }
    /**
     * check
     */
    String readToString = build.toString().replaceAll("\r|\n", "");
    String generatedToString = compounds.toString().replaceAll("\r|\n", "");
    if (!readToString.equals(generatedToString)) {
      Assert.fail("parse and reference differ");
    }

  }

}
