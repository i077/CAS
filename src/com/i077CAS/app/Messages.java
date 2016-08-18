package com.i077CAS.app;


class Messages {

    static final String ConsoleIOError = "There seems to be a problem with the console. Exiting abnormally.";
    static final String Exiting = "Exiting...";

    static final String SyntaxError = "Syntax error.";

    static String SymbolNotFound(String token) {
        return (token +  " does not exist. Use 'let' to define it.");
    }

    static String InvalidSymbolName(String token) {
        return (token + " is not a valid symbol name. Symbols may only start with a letter and may not be reserved keywords.");
    }
}
