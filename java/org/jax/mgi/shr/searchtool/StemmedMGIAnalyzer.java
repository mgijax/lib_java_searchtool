package org.jax.mgi.shr.searchtool;

import java.io.Reader;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.WhitespaceTokenizer;
import org.apache.lucene.analysis.snowball.SnowballFilter;

/**
 * MGI Specific Stemming Analyzer.
 * 
 * This analyzer splits on whitespace, converts everything to lower case,
 * removes stop words, removes ending English punctuation and finally stem
 * resulting tokens
 * 
 * @author mhall
 * 
 */

public class StemmedMGIAnalyzer extends Analyzer {

    private Set stopWords;

    /**
     * Creates a new MGIAnalyzer, and constructs its stop word list.
     * 
     * This list is taken from the lucene standard stop word list for the
     * English language.
     */

    public StemmedMGIAnalyzer() {
        stopWords = StopFilter.makeStopSet(MGIStopWords.MGI_STOP_WORDS);
    }

    /**
     * This method implements the specifics of this analyzer.
     * 
     * Chains WhitespaceTokenizer -> LowerCaseFilter -> StopFilter ->
     * EndPunctFilter -> SnowballFilter (English) to provide mgi custom tokens
     */

    public TokenStream tokenStream(String fieldName, Reader reader) {
        return new SnowballFilter(new EndPunctFilter(
                new StopFilter(new LowerCaseFilter(new WhitespaceTokenizer(
                        reader)), stopWords)), "English");
    }

}
