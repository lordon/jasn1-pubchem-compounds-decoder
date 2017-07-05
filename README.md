# jasn1-pubchem-compounds-decoder
Java decoder for pubchem ASN compound files

This is a parser for the binary encoded ASN.1 files of  PubChem, specifically the 2DCompound files from PubChem's ftp Server:
ftp://ftp.ncbi.nlm.nih.gov/pubchem/Compound/CURRENT-Full/ASN/

This project is based on the jASN1 parser : https://www.openmuc.org/asn1/, which was used to generate the pojos, using the asn definition file from PubChem. However, the classes were heavily refactored due to following problems:
 
  * PubChem uses indefinite length encoding, which is not fully supported by jASN1. 
  * PubChem uses a different encoding for REAL values than defined in the asn standard.
  * jASN1 expects, due to a minor bug whichn will be fixed, that InputSreams act greedy, which isn't always the case.
  * PubChem uses integers to encode state of certain objects (e.g. 1=SingleBond, 2=DoubleBond). Functionality was added to decode those integers to the corresponding textual representation.
  * A filter system was added, which allows drop uninteresting information during parse.
  
  
## Usage
Just run de.uni_leipzig.dbs.jasn1.pubchem.example.ExampleParse to see the parser in action.

