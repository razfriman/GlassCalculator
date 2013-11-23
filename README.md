GlassCalculator
===============

A calculator app for Glass

Author
------
Raz Friman


Technical Details
-------

This application is able to analyze a user's voice as input in order to solve simple arithmetic equations.

After listening for the user's input, the application processes and analyzes the input to determine the equation that was spoken.

After parsing the input from the user, the application calculates the arithmetic value of the equation and display the answer


Parser Implementation
------

Operator-precedence parsing is needed in order to correctly parse the equation from Infix notation. Parsing is implemented using the Shunting-yard algorithm, originally invented by Edsger Dijkstra.

The original paper describing Edsger Dijkstra's Shunting-yard algorithm can be view using the following link:

http://www.cs.utexas.edu/~EWD/MCReps/MR35.PDF
