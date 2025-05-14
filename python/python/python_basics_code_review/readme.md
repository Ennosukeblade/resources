# 💸 Personal Expense Tracker – Python Project

## 📘 Overview

This little project helps you **practice conditionals, functions, lists, and user input** in Python.

You'll build a **console-based app** that allows users to:

* Add new expenses
* View all recorded expenses
* Filter expenses by category
* Calculate the total amount spent

It also introduces the idea of **truthy and falsy values** (e.g. checking if a list is empty).

---

## 🎯 Learning Goals

By completing this exercise, you'll practice:

* Using `if`, `elif`, and `else`
* Creating and using functions
* Working with lists and dictionaries
* Handling user input
* Using loops (`while True`) and breaking out
* Checking for **truthy/falsy values** (`if not expenses:`)

---

## 🧠 Python Basics Extra

### 🧾 What is `input()`?

In Python, the `input()` function is used to **get input from the user**.

📌 **Syntax:**

```python
name = input("What is your name? ")
```

➡️ This will:

1. Show the message `"What is your name? "` in the terminal.
2. Wait for the user to type something and press Enter.
3. Store what they typed in the variable `name`.

🧠 **Note:** `input()` **always returns a string**, even if the user types a number.

To work with numbers (like expense amounts), you need to convert the input:

```python
amount = float(input("Enter the amount: "))
```

This converts the string input into a float (decimal number).

---

## 🚀 Features to Build

### 1. Add an Expense

Ask the user to input:

* Date
* Amount
* Category
* Description

Then, store it in the `expenses` list.

---

### 2. View All Expenses

Loop through the list and display each expense:

* Show date, amount, category, and description
* Show the **total amount spent**

---

### 3. Filter by Category (Bonus)

Ask the user for a category and display only the expenses in that category.
If none found, display a message using a **falsy check** (`if not filtered_expenses:`)

---

### 4. Calculate Total Spent

Calculate the sum of all `amount`s in the list.

---

### 5. Exit the Program

Allow the user to quit the program by choosing an option.

---

## 📂 Sample Output

```
Personal Expense Tracker
1. Add Expense
2. View Expenses
3. Filter Expenses by Category
4. Calculate Total Spent
5. Exit
Enter your choice (1-5): 2

Expenses:
Date: 2024-10-01, Amount: $50.00, Category: Groceries, Description: Weekly groceries shopping
...
Total Amount Spent: $725.49
```

---

## ✅ What You Should Use

* `if`, `elif`, `else`
* `while True` loops with `break`
* `append()` for adding to lists
* String formatting (`f"..."`)
* List filtering (`if expense['category'] == category`)
* Truthy/falsy checks like:

```python
if not expenses:
    print("No expenses recorded.")
```