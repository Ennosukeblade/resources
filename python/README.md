### **Python Basics: A Beginner's Guide**

#### **Introduction to Python**  
Python is a high-level, interpreted programming language built on top of the C programming language. Unlike compiled languages, Python executes code line by line using an interpreter, making debugging and experimentation easier. Its simplicity and readability make it ideal for both beginners and professionals.

---

#### **Variables in Python**  
In Python, variables are dynamically typed and act as references to objects in memory.  

- **Immutable objects**: Integers, floats, and strings. Changes create new objects.  
- **Mutable objects**: Lists and dictionaries. Changes update the existing object.  

Example:  
```python
# Immutable example
y = 3.14    # Float: Points to a memory location with the value 3.14.
z = "Hello" # String: Points to a memory location containing the string "Hello".
x = 10  # Integer: points to a memory location with the value 10.
x = 20  # Points to a new memory location with the value 20.

# Mutable list
my_list = [1, 2, 3]  # List in memory.
my_list.append(4)    # Updates the same object.
if len(my_list) > 3:
    print(my_list)       # Output: [1, 2, 3, 4]
else:
    print("The list has 3 or fewer items.")

# Mutable dictionary
my_dict = {"key1": "value1"}  # Dictionary in memory.
my_dict["key2"] = "value2"    # Updates the same object.
if "key2" in my_dict:
    print(my_dict)                # Output: {'key1': 'value1', 'key2': 'value2'}
else:
    print("key2 is not in the dictionary.")
```

---

#### **Working with Strings**  
Strings in Python can be written in multiple ways:  

1. **Single Quotes**: `'This is a string'`  
2. **Double Quotes**: `"This is also a string"`  
3. **Triple Quotes**: `'''For multi-line strings'''`  

Example:  
```python
message = "Hello, Python!"         # Double quotes
multi_line = '''This is
a multi-line string.'''            # Triple quotes
escaped = "New line: \nTab: \tEnd" # Escape characters

if "\n" in escaped:
    print("The string contains a newline.")  # Output: The string contains a newline.
else:
    print("The string does not contain a newline.")

print(message)     # Output: Hello, Python!
print(multi_line)  # Output: This is
                   #         a multi-line string.
print(escaped)     # Output: New line:
                   #         Tab:     End
```

---

#### **Naming Conventions**  
Follow these conventions for readability:  
- **Variables and functions**: Use `snake_case` (e.g., `my_variable`, `calculate_sum`).  
- **Constants**: Use `ALL_CAPS` (e.g., `PI = 3.14159`).  
- Avoid using Python's reserved keywords as names.  
[Refer to the official list of keywords](https://docs.python.org/3/reference/lexical_analysis.html#keywords).  

---

#### **Conditional Statements**  
Python evaluates the truthiness of expressions:  

- `0`, `None`, `False`, empty objects (`[]`, `{}`, `""`) are **falsy**.  
- Non-zero numbers and non-empty objects are **truthy**.  

Example:  
```python
x = 0
if x:
    print("True")
else:
    print("False")  # Output: False

y = [1, 2, 3]
if y:
    print("List is not empty")  # Output: List is not empty
else:
    print("List is empty")
```

---

#### **Logical Operators: `and` and `or`**  
- **`and`**: Returns `True` if both conditions are `True`.  
- **`or`**: Returns `True` if at least one condition is `True`.  

Example:  
```python
a = 10
b = 0

# `and` example
if a > 5 and b == 0:
    print("Both conditions are True")  # Output: Both conditions are True
else:
    print("At least one condition is False")

# `or` example
if a > 5 or b > 0:
    print("At least one condition is True")  # Output: At least one condition is True
else:
    print("Neither condition is True")

# Non-boolean values with `and` and `or`
result = a and b  # a is truthy; evaluates to b (0)
print(result)     # Output: 0

result = a or b   # a is truthy; evaluates to a (10)
print(result)     # Output: 10
```
