# Carson's Sudoku Solver

This project was intended as a refresher on content taught in my DSA class. Namely, I wanted to reaffirm my grasp of Java and OOP fundamentals. I chose a Sudoku solver as my project of choose for due to a remark in the class [FAQ](https://www.cs.cornell.edu/courses/cs4414/2024fa/FAQ.htm) for CS4414 (Systems Programming) claiming to be able to design such as a solver is a good benchmark for having the OOP chops for said class. 

The methodology employed here is quite simple. The core method, `solveBoard,` uses a depth-first search brute force approach. I chose this because 1. a probabilistic approach would be more complex to implement, and 2. the brute force approach is not intensive enough to make sacrificing a deterministic solution worthwhile, in my opinion. 

