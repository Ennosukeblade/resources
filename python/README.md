### **Python Basics**

#### **Introduction to Python**  
Python is a high-level, interpreted programming language built on top of the C programming language. Unlike compiled languages, Python code is executed line by line by the Python interpreter, making it easier to debug and experiment with. Its simplicity and readability make it an excellent choice for beginners and professionals alike.

---

#### **Variables in Python**  
In Python, variables are dynamically typed, meaning you don’t need to declare their type explicitly. Internally, Python variables act as references to objects stored in memory. Here are some key points about variables and memory:

- **Integer and Float**: Stored as immutable(cannot be changed) objects. Any change creates a new object in memory.
- **Strings**: Also immutable. Modifications create new string objects.
- **Lists and Dictionaries**: Mutable(can be changed) objects, meaning they can be changed without creating a new object.

Example:
```python
# Immutable example
x = 10  # Integer points to 10 in memory.
x = 20  # Now points to a new memory location with 20.

# Mutable list
my_list = [1, 2, 3]  # List in memory.
my_list.append(4)    # Updates the same object.
print(my_list)       # Output: [1, 2, 3, 4]

# Mutable dictionary
my_dict = {"key1": "value1"}  # Dictionary in memory.
my_dict["key2"] = "value2"    # Updates the same object.
print(my_dict)                # Output: {'key1': 'value1', 'key2': 'value2'}
```

---

#### **Working with Strings**  
Python provides multiple ways to define and work with strings:

1. **Single Quotes**: `'This is a string'`
2. **Double Quotes**: `"This is also a string"`
3. **Triple Quotes**: `'''For multi-line strings'''` or `"""Another way for multi-line"""`

Strings can include escape characters like `\n` for a new line and `\t` for a tab.  

Example:
```python
message = "Hello, World!"  # Double quotes
multi_line = '''This is
a multi-line
string.'''  # Triple quotes
```

---

#### **Naming Conventions**  
Python follows specific naming conventions for readability and consistency:

- **Variables**: Use snake_case (e.g., `my_variable`)
- **Functions**: Also snake_case (e.g., `calculate_sum()`)
- **Constants**: Use ALL_CAPS (e.g., `PI = 3.14159`)
- Avoid using reserved keywords as names (e.g., `def`, `if`, `while`).

---

#### **Conditional Statements**  
In Python, conditions evaluate the truthiness of an expression. For example:

```python
x = 0
if x:
    print("True")
else:
    print("False")  # Output: False
```

Explanation:  
- `0`, `None`, `False`, empty collections (`[]`, `{}`, `''`), and `0.0` are treated as `False`. 
- Non-zero numbers and non-empty objects are treated as `True`.

---

#### **Logical Operators: `and` and `or`**  
- **`and`**: Evaluates to `True` if both conditions are `True`.
- **`or`**: Evaluates to `True` if at least one condition is `True`.

Example:
```python
a = 10
b = 0

if a > 5 and b == 0:
    print("Both conditions are True")  # Output: Both conditions are True

if a > 5 or b > 0:
    print("At least one condition is True")  # Output: At least one condition is True
```

---

This document serves as a quick reference for understanding Python's core concepts.