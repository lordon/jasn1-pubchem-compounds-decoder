package de.uni_leipzig.dbs.jasn1.pubchem.util;

import java.io.InputStream;

/**
 * Resolves resources, makes it more comfortable to load them.
 *
 * @author jhuth
 */
public class PubchemResourceAnchor {
  /**
   * @return InputStream to a compound file.
   */
  public static InputStream getSomeCompounds() {
    return ClassLoader.getSystemResourceAsStream("Compound_044675001_044700000.asn");
  }

  /**
   * @return InputStream to a gzipped compound file.
   */
  public static InputStream getSomeGZippedCompounds() {
    return ClassLoader.getSystemResourceAsStream("Compound_099350001_099375000.asn.gz");
  }

  /**
   * @return InputStream to the toString of the gzipped compound file. For testing.
   */
  public static InputStream getSomeGZippedCompoundstoString() {
    return ClassLoader.getSystemResourceAsStream("Compound_099350001_099375000.asn.gz.txt");
  }
}
