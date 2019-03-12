# ENTER...SERVED
Java code for a problem

# Question- 
In this problem, there are types of events: ENTER (a student enters the queue) or SERVED.<br/>
A unique token is assigned to any student entering the queue. The queue serves the students 
based on the following criteria:<br/>
The student having the highest Cumulative Grade Point Average (CGPA) is served first.<br/>
Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.<br/>
Any students having the same CGPA and name will be served in ascending token order.<br/>
Given a sequence of  events, print the names of students who are yet to be served(based on above criteria). <br/>
If the queue is empty, print EMPTY.<br/>
## Input Format
The first line of input contains an integer, , denoting the total number of events. <br/>
Each of the subsequent lines will be of the following two forms:<br/>
ENTER name CGPA token - The student to be inserted into the priority queue.<br/>
SERVED - The highest priority student in the queue was served.<br/>
## Constraints
 where 
 where each token i is a unique integer.<br/>

## Output Format
Print the names (based on the criteria) of the students who are not served at all after executing all  events; if every student in the queue was served, then print EMPTY.<br/>
Sample Input<br/>
12<br/>
ENTER John 3.75 50<br/>
ENTER Mark 3.8 24<br/>
ENTER Shafaet 3.7 35<br/>
SERVED<br/>
SERVED<br/>
ENTER Samiha 3.85 36<br/>
SERVED<br/>
ENTER Ashley 3.9 42<br/>
ENTER Maria 3.6 46<br/>
ENTER Anik 3.95 49<br/>
ENTER Dan 3.95 50<br/>
SERVED<br/><br/>
Sample Output<br/>
Dan<br/>
Ashley<br/>
Shafaet<br/>
Maria<br/>
