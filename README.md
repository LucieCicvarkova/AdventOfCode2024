# AdventOfCode2024


## Day 1

Input: two columns of numbers

**Part 1:** Sort each column by number size. Find difference between corresponding numbers in column 1 and column 2. Sum up these differences.

**Part 2:** For each number in column 1 (x) find its occurence (y) in column 2. Multiply this number by its occurence, x * y. Sum up these results.


## Day 2

Input: rows of numbers

**Part 1:** Check valid rows. Parameters for validity: numbers in the whole row are gradually increasing or gradually decreasing. Distance between two neighbouring numbers is 1 - 3.  

**Part 2:** Check the valid row according to the rules form PArt 1. Add the check if the row becomes valid after removing one mumber from it. 


## Day 3

Input: string of chars

**Part 1:** Find all sequences in the format of "mul(number1,number2)". Mulitply number1 * number2 and sum up the results.

**Part 2:** Find also the sequences "do()" and "don´t". Apply the algorithm from part 1 to the "mul(number1, number2)" with this condition: do() sequence enables the  "mul(..)" sequenceto be processed. All "mul(...)" are processed until "don´t" sequence occurs.
Now all the following "mul(..)" sequences are excluded from the processing until another do() sequence occurs. 


## Day 4

Input: rows of letters

**Part 1:** Find all the occurencies of the sequence XMAS in all the directions: rows, columns, diagonals, both forward and reverse.

**Part 2:** Find all occurencies of the desired pattern, MAS in "X" shape.
