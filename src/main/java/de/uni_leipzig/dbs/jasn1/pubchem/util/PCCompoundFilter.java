package de.uni_leipzig.dbs.jasn1.pubchem.util;

import de.uni_leipzig.dbs.jasn1.pubchem.compounds.pcsubstance.PCCompound;

/**
 * PCCompoudFilter is used to decide at parse time, which parsed objects should be kept, and which
 * should be discarded.
 *
 * <pre>
 * PC-Compound ::= SEQUENCE {
    -- Tracking Information
    id             [0]  PC-CompoundType,                        -- Compound Qualifier (Type/ID)
    atoms          [1]  PC-Atoms                      OPTIONAL, -- AtomID/Type Information
    bonds          [2]  PC-Bonds                      OPTIONAL, -- BondID/Type/Atom Information
    stereo         [3]  SEQUENCE OF PC-StereoCenter   OPTIONAL, -- StereoCenter Descriptions
    coords         [4]  SEQUENCE OF PC-Coordinates    OPTIONAL, -- 2D/3D Coordinate Sets of Compound
    charge         [5]  INTEGER                       OPTIONAL, -- Provided Total Formal Charge  (Signed Integer)
    props          [6]  SEQUENCE OF PC-InfoData       OPTIONAL, -- Derived (computed) Properties
    stereogroups   [7]  SEQUENCE OF PC-StereoGroup    OPTIONAL, -- Relative stereochemistry groups
    count          [8]  PC-Count                      OPTIONAL, -- Counts of various properties
    vbalt          [9]  PC-Compounds                  OPTIONAL  -- Alternate Valence-Bond Forms
    }
 * </pre>
 *
 * This is the ASN.1 Definition for a {@link PCCompound} for each <i>OPTIONAL</i> marked field
 * (excluding <i>props)</i>, this class has a boolean flag, which decides if a field should be kept
 * or discarded during parsing.
 * <p>
 * <i>props</i> has its own Filter class, {@link PropsFilter}.
 * <p>
 * All objects will still be parsed, due to the indefinite length of objects in the pubchem ASN.1
 * files. So, the filter can only affect the amount of stored data, not runtime.
 *
 * @author jhuth
 */
public class PCCompoundFilter {

  private boolean parseAtoms = true;
  private boolean parseBonds = true;
  private boolean parseStereo = true;
  private boolean parseCoords = true;
  private PropsFilter propsFilter = null;
  private boolean parseStereogroups = true;
  private boolean parseCount = true;
  private boolean parseVbalt = true;

  /**
   * All fields of {@link PCCompound} will be kept, and given {@link PropsFilter} will be used for
   * properties.
   */
  public PCCompoundFilter(final PropsFilter filter) {
    this.propsFilter = filter;
  }

  /**
   * This filter will not affect the outcome of the parse in any way.
   *
   * @see PCCompoundFilter#getExampleFilter()
   */
  public PCCompoundFilter() {
    this.propsFilter = new PropsFilter();
  }

  /**
   * Returns an instance of an example filter, which will affect the parse in following way:
   *
   * <pre>
   * Filtered (discarded) Objects:
  
   * Stereo
   * Stereogroups
   * Vbalt
   *
   * Filtered Properties:
   * {@link PropsFilter#getExampleFilter()}
   * </pre>
   *
   * @return
   */
  public static PCCompoundFilter getExampleFilter() {
    PCCompoundFilter filter = new PCCompoundFilter(PropsFilter.getExampleFilter());
    filter.setParseStereo(false);
    filter.setParseStereogroups(false);
    filter.setParseVbalt(false);
    return filter;
  }

  /**
   * Sets, whether atoms should be kept after parsing.
   *
   * @see PCCompoundFilter
   */
  public void setParseAtoms(final boolean parseAtoms) {
    this.parseAtoms = parseAtoms;
  }

  /**
   * Sets, whether the bonds between the atoms should be kept after parsing.
   *
   * @see PCCompoundFilter
   */
  public void setParseBonds(final boolean parseBonds) {
    this.parseBonds = parseBonds;
  }

  /**
   * Sets, whether the geometry of the molecules should be kept after parsing. The geometry could
   * be, for example, stored in
   * <a href= "https://en.wikipedia.org/wiki/Tetrahedral_molecular_geometry">Tetrahedral molecular
   * geometry</a>
   * or<a href= "https://en.wikipedia.org/wiki/Trigonal_bipyramidal_molecular_geometry">Trigonal
   * bipyramidal molecular geometry</a>
   *
   * @see PCCompoundFilter
   */
  public void setParseStereo(final boolean parseStereo) {
    this.parseStereo = parseStereo;
  }

  /**
   * Sets, whether the coordinates of the atoms should be kept after parsing.
   *
   * @see PCCompoundFilter
   */
  public void setParseCoords(final boolean parseCoords) {
    this.parseCoords = parseCoords;
  }

  /**
   * @param propsFilter
   *          {@link PropsFilter}
   */
  public void setPropsFilter(final PropsFilter propsFilter) {
    this.propsFilter = propsFilter;
  }

  /**
   * Sets, whether the groups of
   * <a href="https://en.wikipedia.org/wiki/Stereochemistry">stereochemistry</a>, this compounds
   * belongs to, should be kept after parsing.
   *
   * @param parseStereogroups
   */
  public void setParseStereogroups(final boolean parseStereogroups) {
    this.parseStereogroups = parseStereogroups;
  }

  /**
   * Sets, whether some quantitative data about this compound should be kept after parsing.
   */
  public void setParseCount(final boolean parseCount) {
    this.parseCount = parseCount;
  }

  /**
   * Sets, whether Alternate Valence-Bond Forms should be kept after parsing.
   *
   * @param parseVbalt
   */
  public void setParseVbalt(final boolean parseVbalt) {
    this.parseVbalt = parseVbalt;
  }

  public boolean isParseAtoms() {
    return parseAtoms;
  }

  public boolean isParseBonds() {
    return parseBonds;
  }

  public boolean isParseStereo() {
    return parseStereo;
  }

  public boolean isParseCoords() {
    return parseCoords;
  }

  public PropsFilter getPropsFilter() {
    return propsFilter;
  }

  public boolean isParseStereogroups() {
    return parseStereogroups;
  }

  public boolean isParseCount() {
    return parseCount;
  }

  public boolean isParseVbalt() {
    return parseVbalt;
  }

}
