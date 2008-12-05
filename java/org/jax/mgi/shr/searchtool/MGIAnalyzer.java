package org.jax.mgi.shr.searchtool;

import java.io.Reader;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.WhitespaceTokenizer;

/**
 * MGI Specific Analyzer
 * 
 * @author mhall
 * 
 * This analyzer tokenizes on whitespace, and strips off ending punctuation.
 */

public class MGIAnalyzer extends Analyzer {

    private Set stopWords;

    /**
     * Creates a new MGIAnalyzer, and constructs its stop words list.
     * 
     * This list is taken from the Lucene standard stop word list for the
     * English language.
     */

    public MGIAnalyzer() {
        stopWords = StopFilter.makeStopSet(StopAnalyzer.ENGLISH_STOP_WORDS);
    }

    /**
     * Worker for this Analyzer.
     * 
     * Specifically this analyzer chains together WhitespaceTokenizer ->
     * LowerCaseFilter -> StopFilter -> EndPunctFilter together to form
     * customized MGI Tokens
     */

    public TokenStream tokenStream(String fieldName, Reader reader) {
        return new EndPunctFilter(new StopFilter(new LowerCaseFilter(
                new WhitespaceTokenizer(reader)), stopWords));
    }

}
