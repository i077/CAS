package com.i077CAS.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;
import com.i077CAS.lang.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


/**
 * Interactive shell for the user to interface with the CAS.
 * Handles user input and passes control to other parts of the CAS.
 */
public class Shell {
    private HashMap<String, Number> symbolStack;
    private BufferedReader input;

    private ANTLRInputStream inputStream;
    private CalcLexer lexer;
    private CommonTokenStream tokens;
    private CalcParser parser;

    private ParseTree tree;
    private CASCalcVisitor visitor;

    public Shell() {
        this.init();
    }

    /**
     * Initialize the shell interface.
     */
    private void init() {
        symbolStack = new HashMap<>();
        input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Entering interactive mode. Type an expression and press ENTER to parse.");
        
    }

    /**
     * Run the shell interface. This method takes user input, parses it,
     * and passes that to parse().
     *
     * @throws IOException if ANTLR was unable to open the input stream.
     */
    public void run() throws IOException {
        //noinspection InfiniteLoopStatement
        while (true) {
            inputStream = new ANTLRInputStream(input.readLine());
            lexer = new CalcLexer(inputStream);
            tokens = new CommonTokenStream(lexer);
            parser = new CalcParser(tokens);
            tree = parser.input();
            visitor = new CASCalcVisitor();
            visitor.visit(tree);
        }
    }


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
            if (symbolStack.containsKey(tokens[0])) {
                if (tokens.length == 1) {
                    System.out.println(symbolStack.get(tokens[0]));
                }
            } else {
                throw new IllegalArgumentException(Messages.SymbolNotFound(tokens[0]));
            }
        } else if (isValidLiteral(tokens[0])) {

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
                    symbolStack.put(tokensInStatement[0], new BigDecimal(tokensInStatement[2]));
                    System.out.println(tokensInStatement[0] + " = " + symbolStack.get(tokensInStatement[0]));
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
                    if (symbolStack.containsKey(token)) {
                        symbolStack.remove(token);
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
