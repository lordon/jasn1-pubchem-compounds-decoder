package de.uni_leipzig.dbs.jasn1.pubchem.util;

import java.util.HashSet;
import java.util.Set;

import org.openmuc.jasn1.ber.types.string.BerVisibleString;

public class PropsFilter {
  /**
   * <pre>
   *  If set to <b>true</b>:
   *    Skips all property attributes, except for <i>label</i> and <i>name</i>.
   *  Default is <b>false</b>.
   *
   * Example PCInfo object:
   *
   *
   * {
       urn: {
         label: Weight,
         name: MonoIsotopic,
         <b>datatype: 7,</b>
         <b>version: 2.1,</b>
         <b>software: PubChem,</b>
         <b>source: ncbi.nlm.nih.gov,</b>
         <b>release: 2016.09.28</b>
       },
       value: fval: 753.15
     }
   * </pre>
   */
  private boolean skipMetadata = false;
  /**
   * Only properties with given (concatenated) labels and names will be parsed
   */
  private Set<String> whitelistLabelName = new HashSet<>();

  public PropsFilter() {
  }

  public PropsFilter(final boolean skipMetadata, final Set<String> whitelistlabelName) {
    this.skipMetadata = skipMetadata;
    this.whitelistLabelName = whitelistlabelName;
  }

  public boolean isSkipMetadata() {
    return skipMetadata;
  }

  public void setSkipMetadata(final boolean skipMetadata) {
    this.skipMetadata = skipMetadata;
  }

  public Set<String> getWhitelistLabelName() {
    return whitelistLabelName;
  }

  /**
   * Define properties that will be parsed and stored. Name can be omitted.
   *
   * @param label
   *          the label of the property
   * @param name
   *          the name, if existing.
   */
  public void addPropertyToWhitelist(final String label, final String name) {
    if (name == null) {
      addPropertyToWhitelist(label);
    } else {
      this.whitelistLabelName.add(label.trim() + name.trim());
    }

  }

  /**
   * Here defined properties will be parsed and stored.
   *
   * @param label
   *          the label of the property
   */
  public void addPropertyToWhitelist(final String label) {
    this.whitelistLabelName.add(label.trim());
  }

  /**
   * Called by the parser to determine whether a property should be skipped or not. if no whitelist
   * pattern is declared, no properties will be skipped.
   *
   * @param label
   * @param name
   * @return
   */
  public boolean skipProperty(final BerVisibleString label, final BerVisibleString name) {
    if (label == null || whitelistLabelName.isEmpty()) {
      return false;
    }

    if (name == null) {
      return !whitelistLabelName.contains(label.toString().trim());
    }
    return !whitelistLabelName.contains(label.toString().trim() + name.toString().trim());
  }

  /**
   * Returns a PropsFilter which will affect the parse in following way:
   *
   * <pre>
   * SkipMetadata is set: {@link PropsFilter#skipMetadata}
   *
   * Only following Properties are returned:
   * IUPAC Name : Allowed
   * Mass : Exact
   * Moleculat Formula
   * Molecular Weight
   * Compound Complexity
   * Count : HydrogenBond Acceptor
   * Count : HydrogenBond Donor
   * Count : Rotatable Bond
   * </pre>
   *
   * @return described Filter
   */
  public static PropsFilter getExampleFilter() {
    PropsFilter filter = new PropsFilter();
    filter.setSkipMetadata(true);
    filter.addPropertyToWhitelist("IUPAC Name", "Allowed");
    filter.addPropertyToWhitelist("Mass", "Exact");
    filter.addPropertyToWhitelist("Molecular Formula");
    filter.addPropertyToWhitelist("Molecular Weight");
    filter.addPropertyToWhitelist("Compound Complexity");
    filter.addPropertyToWhitelist("Count", "HydrogenBond Acceptor");
    filter.addPropertyToWhitelist("Count", "HydrogenBond Donor");
    filter.addPropertyToWhitelist("Count", "Rotatable Bond");

    return filter;
  }

}
