package com.i077CAS.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.i077CAS.lang.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


/**
 * Interactive shell for the user to interface with the CAS.
 * Handles user input and passes control to other parts of the CAS.
 */
public class Shell {
    private HashMap<String, BigDecimal> memStack;
    private List<BigDecimal> resultStack;
    private BufferedReader input;

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
            ANTLRInputStream inputStream = new ANTLRInputStream(input.readLine());
            CalcLexer lexer = new CalcLexer(inputStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CalcParser parser = new CalcParser(tokens);
            ParseTree tree = parser.input();
            CASCalcVisitor visitor = new CASCalcVisitor(memStack, resultStack);


            try {
                BigDecimal result = visitor.visit(tree);
                System.out.println(result);
                resultStack.add(result);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            System.out.println();
        }
    }
}
