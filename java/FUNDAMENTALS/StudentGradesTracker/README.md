# Student Grades Tracker

## Exercise Statement

You are tasked with building a simple Java console application to track student grades. The application should:

1. Prompt the user to enter grades for a predefined list of students.
2. Validate each grade to ensure it is a number between 0 and 100 (inclusive).
3. Handle invalid inputs gracefully:
   - If the input is not a number, mark the grade as "Invalid".
   - If the number is outside the valid range, mark the grade as "Invalid".
4. Store each student's grade (or "Invalid" if the input was not acceptable).
5. Display the final list of students and their corresponding grades at the end.

### Requirements

- Use a `HashMap` to store student names and their grades.
- Use a custom exception (`InvalidGradeException`) to handle grades outside the valid range (between 0 and 100).
- Use a loop to process each student.
- Use a `Scanner` to read user input from the console.

### Example

```
Enter grade for Alice:
95
Enter grade for Bob:
abc
Invalid input. Must be a number.
Enter grade for Charlie:
105
Grade must be between 0 and 100.

Final Grades:
Alice: 95
Bob: Invalid
Charlie: Invalid
```

### Bonus

- Refactor the code to allow dynamic entry of student names.
- Add functionality to calculate and display the class average (excluding "Invalid" grades).

---

## What Will Be Covered During This Code Review

During this live coding session, we will cover:

- How to use Java collections (`HashMap`, arrays) to store and manage data.
- Reading and validating user input from the console using `Scanner`.
- Implementing and using custom exceptions for input validation.
- Basic control flow: loops, conditionals, and exception handling.
- Printing formatted output to the console.
- Discussing possible improvements and bonus features, such as dynamic student entry and calculating class averages.

This exercise will help you practice exception handling, user input, collections, and basic Java control flow.
