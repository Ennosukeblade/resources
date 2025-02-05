# 🐍 Python Fundamentals 1

## 🎯 Introduction
This document covers essential Python 🐍 fundamentals to help you get started with coding 💻. Whether you are a beginner 🆕 or need a refresher, these topics will provide a solid foundation 🏗️.

---

## 🏷️ Python Syntax
Python uses **indentation** ⬜ to define blocks of code. Here’s a simple example:

```python
if True:
    print("Hello, Python!")
```
**🖥️ Output:**
```
Hello, Python!
```

Python does **not** require semicolons (`;`) at the end of statements, making the syntax clean ✨ and readable 📖.

---

## 📌 Data Types
Python has several built-in **data types**:
- 🔢 **Integers (`int`)**: Whole numbers (e.g., `10`, `-3`)
- 🔢 **Floats (`float`)**: Decimal numbers (e.g., `3.14`, `-2.5`)
- 🔤 **Strings (`str`)**: Text data (e.g., `'Hello'`, `"Python"`)
- ✅ **Booleans (`bool`)**: `True` or `False`
- 📜 **Lists (`list`)**: Ordered, **mutable** collections (e.g., `[1, 2, 3]`)
- 🔗 **Tuples (`tuple`)**: Ordered, **immutable** collections (e.g., `(1, 2, 3)`) 

Check the **data type** using `type()`:

```python
print(type(10))
```
**🖥️ Output:**
```
<class 'int'>
```

---

## ➕➖ Numbers 🔢
Python supports basic **math operations**:

```python
x = 10
y = 3
print(x + y)  # ➕ Addition
print(x - y)  # ➖ Subtraction
print(x * y)  # ✖️ Multiplication
print(x / y)  # ➗ Division
print(x // y) # 🔽 Floor division
print(x % y)  # 🔢 Modulus
print(x ** y) # ⚡ Exponentiation
```
**🖥️ Output:**
```
13
7
30
3.3333333333333335
3
1
1000
```

---

## 🔤 Strings
Strings can be **modified** 🛠️ in various ways:

```python
s = "Hello, Python!"
print(s.upper())  # 🔠 Uppercase
print(s.lower())  # 🔡 Lowercase
print(s[0:5])    # ✂️ Slice
print(s.replace("Python", "World"))  # 🔄 Replace
```
**🖥️ Output:**
```
HELLO, PYTHON!
hello, python!
Hello
Hello, World!
```

---

## 📋 Lists Overview
Lists store **multiple values** in a single variable:

```python
fruits = ["🍎", "🍌", "🍒"]
print(fruits[0])  # First item
print(fruits[-1]) # Last item
```
**🖥️ Output:**
```
🍎
🍒
```

---

## 🔄 List Manipulation
Lists are **mutable** (changeable):

```python
fruits.append("🍊")
fruits.remove("🍌")
fruits[1] = "🍇"
print(fruits)
```
**🖥️ Output:**
```
['🍎', '🍇', '🍊']
```

---

## 🛠️ Built-in Functions for Lists
Python provides useful **list functions**:

```python
numbers = [5, 2, 9, 1]
print(len(numbers))  # 🔢 Length
print(max(numbers))  # ⬆️ Max value
print(min(numbers))  # ⬇️ Min value
print(sum(numbers))  # ➕ Sum
numbers.sort()       # 📊 Sort
print(numbers)
```
**🖥️ Output:**
```
4
9
1
17
[1, 2, 5, 9]
```

---

## 🔗 Tuples
Tuples are **immutable** lists:

```python
tuple_example = (1, 2, 3, 4)
print(tuple_example[0])
```
**🖥️ Output:**
```
1
```

---

## 🔀 Conditionals
Conditional statements allow **decision-making**:

```python
age = 18
if age >= 18:
    print("You are an adult.")
elif age > 13:
    print("You are a teenager.")
else:
    print("You are a child.")
```
**🖥️ Output:**
```
You are an adult.
```

---

## 🔁 Loops
Loops **iterate** over data:

### 🔄 For Loop
```python
for i in range(5):
    print(i)
```
**🖥️ Output:**
```
0
1
2
3
4
```

### 🔄 While Loop
```python
x = 0
while x < 5:
    print(x)
    x += 1
```
**🖥️ Output:**
```
0
1
2
3
4
```

---

## 🔄 Looping Over Lists & Strings

### 🔁 Looping Over a List
```python
fruits = ["🍎", "🍌", "🍒"]
for fruit in fruits:
    print(fruit)
```
**🖥️ Output:**
```
🍎
🍌
🍒
```

### 🔁 Looping Over a String
```python
for char in "Python":
    print(char)
```
**🖥️ Output:**
```
P
y
t
h
o
n
```

---

## 🎉 Conclusion
This document provides a **quick overview** 📜 of Python fundamentals. Keep practicing 💪 and exploring 🔍 Python to gain confidence in coding! 🚀🐍

For an interactive way to practice Python and improve your coding skills through a game-based approach, check out **CodeCombat**: [CodeCombat - Play & Learn Python](https://codecombat.com/play) 🎮🔥

