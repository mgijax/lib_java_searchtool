package QS_Commons;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.Analyzer;
import java.io.StringReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Utility class used for test harnesses to test out various analyzers.
 * 
 * @author - Lucene in Action - Source taken from the Lucene in action book
 * 
 */

public class AnalyzerUtils {
    
    /**
     * Return an arrary of tokens gotten from the analyzer.
     * 
     * @param analyzer
     * @param text
     * @return
     * @throws IOException
     */
    
    public static Token[] tokensFromAnalysis(Analyzer analyzer, String text) throws IOException {
        TokenStream stream = analyzer.tokenStream("contents", new StringReader(text));
        ArrayList<Token> tokenList = new ArrayList<Token>();
        while (true) {
            Token token = stream.next();
            if (token == null)
                break;

            tokenList.add(token);
        }

        return (Token[]) tokenList.toArray(new Token[0]);
    }

    /**
     * Get an ArrayList of tokens gotten from the analyzer.
     * 
     * @param analyzer
     * @param text
     * @return
     * @throws IOException
     */
    
    public static ArrayList<String> getTokenList(Analyzer analyzer, String text) throws IOException {
        TokenStream stream = analyzer.tokenStream("contents", new StringReader(text));
        ArrayList<String> tokenList = new ArrayList<String>();
        while (true) {
            Token token = stream.next();
            if (token == null)
                break;

            tokenList.add(token.termText());
        }
        return tokenList;
    }

    public static void displayTokens(Analyzer analyzer, String text) throws IOException {
        Token[] tokens = tokensFromAnalysis(analyzer, text);

        for (int i = 0; i < tokens.length; i++) {
            Token token = tokens[i];

            System.out.print("[" + token.termText() + "] ");
        }
    }

    /**
     * Display (print) the list of tokens from the analyzer, with some formatting
     * to show the tokens borders.
     * 
     * @param analyzer
     * @param text
     * @throws IOException
     */
    
    public static void displayTokensWithPositions(Analyzer analyzer, String text) throws IOException {
        Token[] tokens = tokensFromAnalysis(analyzer, text);

        int position = 0;

        for (int i = 0; i < tokens.length; i++) {
            Token token = tokens[i];

            int increment = token.getPositionIncrement();

            if (increment > 0) {
                position = position + increment;
                System.out.println();
                System.out.print(position + ": ");
            }

        }
    }

}