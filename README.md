# Java Cron Parser

This Cron Parser is coded in Java and JUnit (Maven) is used for Unit Testing.

## How to Run the Code

1. First, we need to build the program. It is under `cron-parser/main.cpp`. Go to this directory.
2. Build it with this command in terminal: `javac Main.java`.
3. This will create the `.class` executable file: `ClassName.Class` in our project.
4. Then we will run it using this command: `java Main "2-5,7/3 1 * * 0-4 /usr/bin/find"`.

## Output
<div id="output" style="position: relative;">
  <pre>
minute              2 3 4 5 7 10 13 16 19 22 25 28 31 34 37 40 43 46 49 52 55 58 
hours               1 
day of month        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 
month               1 2 3 4 5 6 7 8 9 10 11 12 
day of week         0 1 2 3 4 
command             /usr/bin/find
</div>

## How to Run the Test File

1. Build the test file with this command in terminal: `javac CronExpressionTest.java`.
2. Install Maven on your device and run `mvn clean install` and `mvn clean test`.
3. This will create the `.class` executable file: `ClassName.class` in our project.
4. Then we will run it using this command: `java CronExpresssionTest`.
