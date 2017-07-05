package de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance.type.custom;

import java.math.BigInteger;
import java.util.Arrays;

import org.openmuc.jasn1.ber.types.BerInteger;

import de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance.PCBondType;

/**
 * Some integers within the PubChem ASN file represent object states. To reference these object
 * states to their string representation, this wrapper is used.
 * <p>
 * For example, the definition of bond types (class {@link PCBondType} looks like this:
 *
 * <pre>
 * -- Bond Type Information
 *   PC-BondType ::= INTEGER {
 *   single         (1),                          -- Single Bond
 *   double         (2),                          -- Double Bond
 *   triple         (3),                          -- Triple Bond
 *   quadruple      (4),                          -- Quadruple Bond
 *   dative         (5),                          -- Dative Bond
 *   complex        (6),                          -- Complex Bond
 *   ionic          (7),                          -- Ionic Bond
 *   unknown      (255)                           -- Unknown/Unspecified Connectivity
 *    }
 * </pre>
 *
 * The generated classes from jASN.1 parser just stored the plain integer value. This class
 * overwrites the toString, and forces to implement getters for a field, which should hold all
 * possible states, and a field for their string representations.
 * <p>
 * Goal is to have a toString that returns (for, example state 3 of a PCBond)
 *
 * <pre>
 * triple : Triple Bond
 * </pre>
 *
 * instead of just the integer value.
 *
 * @author jhuth
 */
public abstract class PubChemTypedBerInteger extends BerInteger {

  private static final long serialVersionUID = 1L;

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

  /**
   * @return All possible values this integer can attain. This array MUST be sorted in an ascending
   *         order.
   *         <p>
   *         Forms a map with the array of {@link #getStateStrings()}
   */
  public abstract int[] getStates();

  /**
   * @return All the string representations of the states this integer can attain.
   *         <p>
   *         It must be ordered in such a way that a state in the array behind {@link #getStates()}
   *         has the same index as its string representation in {@link #getStateStrings()}
   *         <p>
   *         In other words, {@link #getStates()} and {@link #getStateStrings()} forms a map.
   */
  public abstract String[] getStateStrings();

  /**
   * @return Returns the string representation of the state of this integer. This uses binary search
   *         on array returned by {@link #getStates()}, so this needs to be sorted.
   * @see PubChemTypedBerInteger
   */
  @Override
  public String toString() {
    int index = Arrays.binarySearch(getStates(), this.intValue());
    if (index < 0) {
      return PubChemTypedBerInteger.NOT_DEFINED_STATE + this.intValue();
    }
    return getStateStrings()[index];
  }

}
