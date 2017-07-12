package de.uni_leipzig.dbs.jasn1.pubchem.util;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class PubchemGzipInputSteamTest {

  /**
   * Tests, if the stream acts greedy. This is necessary for the used version of jASN
   */
  @Test
  public void testGreedyCapabillity() throws IOException {
    /**
     * Buffer size of IS is set to 1, which means if this were a normal GzipInputStream, invoking
     * read would only return one byte
     */
    PubchemGzipInputStream is = new PubchemGzipInputStream(
        PubchemResourceAnchor.getSomeGZippedCompounds(), 1);
    byte[] buf = new byte[8];
    int requestBytes = 8;
    if (is.read(buf, 0, requestBytes) != requestBytes) {
      is.close();
      Assert.fail("Invoking read returns less bytes than requested.");
    }
    is.close();
  }

}
