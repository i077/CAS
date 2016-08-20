package com.i077CAS.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        System.out.println("Entering interactive mode. Type an expression or equation and press ENTER to evaluate.");
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
            CASCalcVisitor      visitor         = new CASCalcVisitor(memStack, resultStack);


            try {
                Apfloat result = visitor.visit(tree);
                System.out.println(ApfloatToText(result));
                resultStack.add(result);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
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
}
