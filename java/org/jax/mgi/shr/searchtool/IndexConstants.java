package org.jax.mgi.shr.searchtool;

/**
* IndexConstants gives names to the keys for common index entries such as
* column headings and expected values
*
* This will hopefully make the code more readable, maintainable, and
* receptive to index change
*/
public class IndexConstants {

    // object_type values
    public static final String MARKER_TYPE_NAME     = "MARKER";
    public static final String ALLELE_TYPE_NAME     = "ALLELE";
    public static final String MP_TYPE_NAME         = "MP";
    public static final String GO_TYPE_NAME         = "GO";
    public static final String OMIM_TYPE_NAME       = "OMIM";
    public static final String OMIM_ORTH_TYPE_NAME  = "OMIM/ORTH";
    public static final String AD_TYPE_NAME         = "AD";
    public static final String PIRSF_TYPE_NAME      = "PS";
    public static final String INTERPRO_TYPE_NAME   = "IP";

    // Database type values
    public static final String MP_DATABASE_TYPE	    = "Mammalian Phenotype";
    public static final String PIRSF_DATABASE_TYPE  = "PIR Superfamily";
    public static final String INTERPRO_DATABASE_TYPE = "InterPro Domains";

    // data_type values
    public static final String ACCESSION_ID         = "ACC_ID";
    public static final String VOC_ACCESSION_ID     = "VOC_ACC_ID";
    public static final String ALLELE_ACCESSION_ID  = "ALL_ACC_ID";
    public static final String ORTH_ACCESSION_ID    = "ORTH_ACC_ID";
    public static final String ES_ACCESSION_ID      = "ES_CELL_LINE_ACC_ID";
    public static final String VOCAB_TERM           = "VT";
    public static final String VOCAB_SYNONYM        = "VY";
    public static final String VOCAB_NOTE           = "VN";
    public static final String MARKER_NAME          = "MN";
    public static final String OLD_MARKER_NAME      = "MNO";
    public static final String MARKER_SYMBOL        = "MS";
    public static final String OLD_MARKER_SYMBOL    = "MSO";
    public static final String MARKER_SYNOYNM       = "MY";
    public static final String ALLELE_NAME          = "AN";
    public static final String ALLELE_SYMBOL        = "AS";
    public static final String ALLELE_SYNONYM       = "AY";
    public static final String ORTHOLOG_NAME        = "ON";
    public static final String ORTHOLOG_SYMBOL      = "OS";
    public static final String ORTHOLOG_SYMBOL_HUMAN= "OSH";
    public static final String ORTHOLOG_SYMBOL_RAT  = "OSR";
    public static final String ORTHOLOG_SYNONYM     = "OY";

    // Other Bucket data type values
    public static final String OTHER_PROBE          = "PROBE";
    public static final String OTHER_REFERENCE      = "REFERENCE";
    public static final String OTHER_SEQUENCE       = "SEQUENCE";
    public static final String OTHER_ALLELE         = "ALLELE";
    public static final String OTHER_ANTIBODY       = "ANTIBODY";
    public static final String OTHER_ANTIGEN        = "ANTIGEN";
    public static final String OTHER_EXPERIMENT     = "EXPERIMENT";
    public static final String OTHER_IMAGE          = "IMAGE";
    public static final String OTHER_ASSAY          = "ASSAY";
    public static final String OTHER_SNP            = "SNP";
    public static final String OTHER_SUBSNP         = "SUBSNP";
    public static final String OTHER_ORTHOLOG       = "ORTHOLOG";
    public static final String OTHER_HOMOLOGY       = "HOMOLOGY";
    public static final String OTHER_AMA            = "AMA";
    public static final String OTHER_ESCELL         = "ESCELL";

    // lucene column headings for searches
    public static final String COL_DB_KEY           = "db_key";
    public static final String COL_DATA             = "data";    // field searched against
    public static final String COL_RAW_DATA         = "raw_data";// Data as it appears in the database
    public static final String COL_SDATA            = "sdata";   // stemmed field searched
    public static final String COL_DATA_TYPE        = "data_type";
    public static final String COL_OBJ_TYPE         = "object_type";
    public static final String COL_IS_CURRENT       = "is_current";
    public static final String COL_ORGANISM         = "org_type";
    public static final String COL_VOCABULARY       = "vocabulary";
    public static final String COL_ACC_KEY          = "acc_key";
    public static final String COL_PREFERRED        = "preferred";
    public static final String COL_QUALIFIER1       = "qualifier1";
    public static final String COL_QUALIFIER2       = "qualifier2";
    public static final String COL_LOGICAL_DB       = "logical_db";
    public static final String COL_TYPE_DISPLAY     = "type_display";
    public static final String COL_PROVIDER         = "provider";
    public static final String COL_UNIQUE_KEY       = "unique_key";

    // lucene column headings for caches (cache indexes may use columns from searches)
    public static final String COL_FEATURE_SYMBOL   = "symbol";
    public static final String COL_CHROMOSOME       = "chr";
    public static final String COL_FEATURE_NAME     = "name";
    public static final String COL_OFFSET           = "offset";
    public static final String COL_START_POS        = "start_pos";
    public static final String COL_STOP_POS         = "stop_pos";
    public static final String COL_STRAND           = "strand";
    public static final String COL_LOC_DISPLAY      = "location_display";
    public static final String COL_OBJECT_TYPE      = "object_type";
    public static final String COL_FEATURE_TYPE     = "feature_type";
    public static final String COL_ACC_ID           = "acc_id";
    public static final String COL_MGI_ID           = "mgi_id";
    public static final String COL_ANNOT_COUNT      = "annotation_count";
    public static final String COL_ANNOT_OBJECT_TYPE= "annotation_object_type";
    public static final String COL_ANNOT_OBJECTS    = "annotation_objects";
    public static final String COL_ANNOT_DISPLAY    = "annotation_display";
    public static final String COL_CHILD_IDS        = "child_ids";
    public static final String COL_CONTENTS         = "contents";
    public static final String COL_GENE_IDS         = "gene_ids";
    public static final String COL_FEATURE_IDS      = "feature_ids";
    public static final String COL_MARKER_COUNT     = "marker_count";
    public static final String COL_OTHER_NAME       = "name";
    public static final String COL_BATCH_FORWARD_VALUE = "batch_forward_value";

}
