/**
 * This class file was automatically generated by jASN1 v1.8.0 (http://www.openmuc.org)
 */

package de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance;

import java.math.BigInteger;

import de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance.type.custom.PubChemTypedBerInteger;

/**
 * Element Information [which may contain "illegal" element values]
 */
public class PCElement extends PubChemTypedBerInteger {

  public final static int[] states = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
      18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
      41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63,
      64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86,
      87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107,
      108, 109, 110, 111, 252, 253, 254, 255 };

  public final static String[] stateStrings = { "h", "he", "li", "be", "b", "c", "n", "o", "f",
      "ne", "na", "mg", "al", "si", "p", "s", "cl", "ar", "k", "ca", "sc", "ti", "v", "cr", "mn",
      "fe", "co", "ni", "cu", "zn", "ga", "ge", "as", "se", "br", "kr", "rb", "sr", "y", "zr", "nb",
      "mo", "tc", "ru", "rh", "pd", "ag", "cd", "in", "sn", "sb", "te", "i", "xe", "cs", "ba", "la",
      "ce", "pr", "nd", "pm", "sm", "eu", "gd", "tb", "dy", "ho", "er", "tm", "yb", "lu", "hf",
      "ta", "w", "re", "os", "ir", "pt", "au", "hg", "tl", "pb", "bi", "po", "at", "rn", "fr", "ra",
      "ac", "th", "pa", "u", "np", "pu", "am", "cm", "bk", "cf", "es", "fm", "md", "no", "lr", "rf",
      "db", "sg", "bh", "hs", "mt", "ds", "rg", "lp : Lone Pair", "r : Rgroup Label",
      "d : Dummy Atom", "a : Unspecified Atom (Asterick)" };

  private static final long serialVersionUID = 1L;

  public PCElement() {
  }

  public PCElement(final byte[] code) {
    super(code);
  }

  public PCElement(final BigInteger value) {
    super(value);
  }

  public PCElement(final long value) {
    super(value);
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  @Override
  public int[] getStates() {
    return states;
  }

  @Override
  public String[] getStateStrings() {
    return stateStrings;
  }

}