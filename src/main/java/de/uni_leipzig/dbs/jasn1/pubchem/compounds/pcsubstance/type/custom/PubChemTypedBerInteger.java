package de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance.type.custom;

import java.math.BigInteger;
import java.util.Arrays;

import org.openmuc.jasn1.ber.types.BerInteger;

public abstract class PubChemTypedBerInteger extends BerInteger {

  public static String NOT_DEFINED_STATE = "Not allowed not defined state: ";

  public PubChemTypedBerInteger() {
    super();
  }

  public PubChemTypedBerInteger(final byte[] code) {
    super(code);
  }

  public PubChemTypedBerInteger(final BigInteger value) {
    super(value);
  }

  public PubChemTypedBerInteger(final long value) {
    super(value);
  }

  public PubChemTypedBerInteger(final BerInteger berInteger) {
    this.code = berInteger.code;
    this.value = berInteger.value;
  }

  public abstract int[] getStates();

  public abstract String[] getStateStrings();

  @Override
  public String toString() {
    int index = Arrays.binarySearch(getStates(), this.intValue());
    if (index < 0) {
      return PubChemTypedBerInteger.NOT_DEFINED_STATE + this.intValue();
    }
    return getStateStrings()[index];
  }

}
