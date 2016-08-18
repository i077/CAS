package com.i077CAS.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import com.i077CAS.lang.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apfloat.Apfloat;


/**
 * Interactive shell for the user to interface with the CAS.
 * Handles user input and passes control to other parts of the CAS.
 */
public class Shell {
    private HashMap<String, Apfloat>    memStack;
    private List<Apfloat>               resultStack;
    private BufferedReader              input;

    public Shell() {
        this.init();
    }

    /**
     * Initialize the shell interface.
     */
    private void init() {
        memStack = new HashMap<>();
        resultStack = new ArrayList<>();
        input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Entering interactive mode. Type an expression and press ENTER to evaluate.");
    }

    /**
     * Run the shell interface. This method takes user input, parses it,
     * and passes the resulting parse tree to a visitor.
     *
     * @throws IOException if ANTLR was unable to open the input stream.
     */
    public void run() throws IOException {
        //noinspection InfiniteLoopStatement
        while (true) {
            ANTLRInputStream    inputStream     = new ANTLRInputStream(input.readLine());
            CalcLexer           lexer           = new CalcLexer(inputStream);
            CommonTokenStream   tokens          = new CommonTokenStream(lexer);
            CalcParser          parser          = new CalcParser(tokens);
            ParseTree           tree            = parser.input();
            CASCalcVisitor      visitor         = new CASCalcVisitor(memStack);

            Apfloat result = visitor.visit(tree);
            System.out.println(ApfloatToText(result));
            resultStack.add(result);
            System.out.println();
        }
    }

    /**
     * Convert a given Apfloat into human-readable text.
     * If precision is more than 6 digits, uses scientific notation.
     *
     * @param apfloat   The Apfloat to convert
     */
    private String ApfloatToText(Apfloat apfloat) {
        if (Math.abs(apfloat.scale()) < 10) {
            apfloat.precision(10);
            return apfloat.toString(true);
        }
        return apfloat.toString();
    }

    /* NOTE: Everything past this line is old and only here temporarily. */

    /**
     * Exit the shell (and thus the runtime environment).
     * @param code Status code to exit with.
     */
    private void exit(int code) {
        Runtime.getRuntime().exit(code);
    }

    /**
     * Parse a given input, extracting necessary tokens and symbols
     * and passing control to functions as necessary.
     * @param input Input string to parse.
     */
    private void parse(String input) throws IllegalArgumentException {
        String[] tokens = input.split(" ");

        // Check if first token is a verb
        if (tokens[0].equals("let")) { // Define new symbol(s)
            let(input.substring(4));
        } else if (tokens[0].equals("clear")) { // Remove existing symbols
            clear(input.substring(6));
        } else if (isValidSymbolId(tokens[0])) { // Check if first token is valid symbol
            if (memStack.containsKey(tokens[0])) {
                if (tokens.length == 1) {
                    System.out.println(memStack.get(tokens[0]));
                }
            } else {
                throw new IllegalArgumentException(Messages.SymbolNotFound(tokens[0]));
            }
        } else if (isValidLiteral(tokens[0])) {
            System.out.println(memStack.get(tokens[0]));
        } else {
            throw new IllegalArgumentException(Messages.SyntaxError);
        }
    }

    /**
     * Check if a given string is valid as a symbol identifier.
     * @param token String to be checked.
     * @return  if s is not a number or reserved keyword
     */
    private static boolean isValidSymbolId(String token) {
        return (Character.isLetter(token.toCharArray()[0])) // An identifier's first character must be a letter.
                && token.matches("[a-zA-Z0-9]+")            // An identifier may only have letters and numbers.
                && !(token.equals("let") ||
                     token.equals("clear"));                  // Check for reserved keywords
    }

    private static boolean isValidLiteral(String token) {
        return (new BigDecimal(token).unscaledValue() != null);
    }

    /**
     * Add symbols to stack. To be called by parse().
     * @param input Input to be parsed.
     */
    private void let(String input) {
        try (Scanner s = new Scanner(input).useDelimiter(", ")) {
            while (s.hasNext()) { // Parse new symbol(s)
                String statement = s.next();
                String[] tokensInStatement = statement.split(" ");
                if (isValidSymbolId(tokensInStatement[0])) {
                    memStack.put(tokensInStatement[0], new Apfloat(tokensInStatement[2]));
                    System.out.println(tokensInStatement[0] + " = " + memStack.get(tokensInStatement[0]));
                } else {
                    throw new IllegalArgumentException(Messages.InvalidSymbolName(tokensInStatement[0]));
                }
            }
        } catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException s) {
            throw new IllegalArgumentException(Messages.SyntaxError);
        }
    }

    /**
     * Remove symbols from stack. To be called by parse().
     * @param input Input to be parsed.
     */
    private void clear(String input) {
        try (Scanner s = new Scanner(input).useDelimiter(", ")) {
            while (s.hasNext()) {
                String token = s.next();
                if (isValidSymbolId(token)) {
                    if (memStack.containsKey(token)) {
                        memStack.remove(token);
                    } else {
                        throw new IllegalArgumentException(Messages.SymbolNotFound(token));
                    }
                } else {
                    throw new IllegalArgumentException(Messages.InvalidSymbolName(token));
                }
            }
        } catch (StringIndexOutOfBoundsException s) {
            throw new IllegalArgumentException(Messages.SyntaxError);
        }
    }
}
