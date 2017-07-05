package de.uni_leipzig.dbs.jasn1.pubchem.util;

/**
 * Created by elias on 05.07.17.
 */
public class PCAtomsFilter {

  private boolean parseAtoms;
  private boolean skipOptionalAtomData;

  public PCAtomsFilter() {
    this.parseAtoms = true;
    this.skipOptionalAtomData = true;
  }

  public PCAtomsFilter(boolean parseAtoms, boolean skipOptionalAtomData) {
    this.parseAtoms = parseAtoms;
    this.skipOptionalAtomData = skipOptionalAtomData;
  }

  public static PCAtomsFilter getExampleFilter() {
    return new PCAtomsFilter();
  }

  public void setSkipOptionalAtomData(boolean skipOptionalAtomData) {
    this.skipOptionalAtomData = skipOptionalAtomData;
  }

  public void setParseAtoms(boolean parseAtoms) {
    this.parseAtoms = parseAtoms;
  }

  public boolean isSkipOptionalAtomData() {
    return skipOptionalAtomData;
  }

  public boolean isParseAtoms() {
    return parseAtoms;
  }

}