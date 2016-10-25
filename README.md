# Implementation of a Computer Algebra System (CAS).

Rather than evaluate expressions numerically as a non-CAS calculator would, a CAS 
interprets and evaluates expressions symbolically. This allows the software to 
solve algebraic equations, give exact forms, factor and expand expressions, and more.

To take input, this implementation uses a sort of makeshift "shell" that the user
types their expression into and presses `ENTER` to evaluate it.

To parse this user input, this CAS uses [ANTLR](http://www.antlr.org/).

I got this idea because I thought it would be cool to figure out how a CAS works
by making one. I own a calculator that has a CAS and was really interested in
how it works.

At this point, my implementation is just a glorified calculator. It can evaluate
expressions and equations, and store variables. I'd like to eventually learn
more about how computational algebra works so I can implement a better solution.

I'm currently reading [this](http://www.mathematik.uni-marburg.de/~eden/paper/AISC08LobachevLoogen.pdf)
paper from Philipps–Universität Marburg in Germany to help me understand more.
