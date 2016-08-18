# Implementation of a Computer Algebra System (CAS).

Rather than evaluate expressions numerically as a non-CAS calculator would, a CAS 
interprets and evaluates expressions symbolically. This allows the software to 
solve algebraic equations, give exact forms, factor and expand expressions, and more.

To take input, this implementation uses a sort of makeshift "shell" that the user
types their expression to evaluate into and presses `ENTER` to evaluate it.

To parse this user input, this CAS uses [ANTLR](http://www.antlr.org/).