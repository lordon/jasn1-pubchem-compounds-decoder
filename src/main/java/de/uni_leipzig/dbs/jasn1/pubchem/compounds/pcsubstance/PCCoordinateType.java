/**
 * This class file was automatically generated by jASN1 v1.8.0 (http://www.openmuc.org)
 */

package de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance;

import java.math.BigInteger;

import de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance.type.custom.PubChemTypedBerInteger;

public class PCCoordinateType extends PubChemTypedBerInteger {

  public final static int[] states = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 255 };

  public final static String[] stateStrings = { "twod : 2D Coordinates",
      "threed : 3D Coordinates (should also indicate units, below)",
      "submitted : Depositor Provided Coordinates",
      "experimental : Experimentally Determined Coordinates", "computed : Computed Coordinates",
      "standardized : Standardized Coordinates",
      "augmented : Hybrid Original with Computed Coordinates (e.g., explicit H)",
      "aligned : Template used to align drawing",
      "compact : Drawing uses shorthand forms (e.g., COOH, OCH3, Et, etc.)",
      "units-angstroms : (3D) Coordinate units are Angstroms",
      "units-nanometers : (3D) Coordinate units are nanometers",
      "units-pixel : (2D) Coordinate units are pixels",
      "units-points : (2D) Coordinate units are points",
      "units-stdbonds : (2D) Coordinate units are standard bond lengths (1.0)",
      "units-unknown : Coordinate units are unknown or unspecified" };

  private static final long serialVersionUID = 1L;

  public PCCoordinateType() {
  }

  public PCCoordinateType(final byte[] code) {
    super(code);
  }

  public PCCoordinateType(final BigInteger value) {
    super(value);
  }

  public PCCoordinateType(final long value) {
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
