package de.uni_leipzig.dbs.jasn1.pubchem.util;

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
   * Returns a new Filter for parsing. This filter will not affect the outcome of the parse in any
   * way.
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
   * Filtered Objects:

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

  public void setParseAtoms(final boolean parseAtoms) {
    this.parseAtoms = parseAtoms;
  }

  public void setParseBonds(final boolean parseBonds) {
    this.parseBonds = parseBonds;
  }

  public void setParseStereo(final boolean parseStereo) {
    this.parseStereo = parseStereo;
  }

  public void setParseCoords(final boolean parseCoords) {
    this.parseCoords = parseCoords;
  }

  public void setPropsFilter(final PropsFilter propsFilter) {
    this.propsFilter = propsFilter;
  }

  public void setParseStereogroups(final boolean parseStereogroups) {
    this.parseStereogroups = parseStereogroups;
  }

  public void setParseCount(final boolean parseCount) {
    this.parseCount = parseCount;
  }

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
