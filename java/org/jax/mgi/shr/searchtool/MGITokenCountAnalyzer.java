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
 * Custom MGI Analayzer
 *
 * @author mhall
 *
 * This analyzer tokenizes on whitespace, lowercases the token,
 * strips off ending punctuation, and then removes and quo tation marks.
 *
 */

public class MGITokenCountAnalyzer extends Analyzer {

    private Set stopWords;

    public MGITokenCountAnalyzer() {
        stopWords = StopFilter.makeStopSet(StopAnalyzer.ENGLISH_STOP_WORDS);
    }

    /**
     * Worker for this Analyzer.
     *
     * <br>
     * <br>
     * Specifically this analyzer chains together WhitespaceTokenizer ->
     * LowerCaseFilter -> QouteFilter -> PrefixFilter -> StopFilter ->
     * EndPunctFilter together to form customized MGI Tokens
     */

    public TokenStream tokenStream(String fieldName, Reader reader) {
        return new QuoteFilter(new PrefixFilter(new EndPunctFilter(new StopFilter(new LowerCaseFilter(
                new WhitespaceTokenizer(reader)), stopWords))));
    }

}
