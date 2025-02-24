# 📚 **Resources for Class Methods and Static Methods**

## 1. **Class Methods (`@classmethod`)**  
   - **What it is:** A method bound to the class (not the instance), often used for factory methods or class-level operations.  
   - **Resources:**  
     - [Programiz: Python Classmethod (Short)](https://www.programiz.com/python-programming/methods/built-in/classmethod)
     - [Real Python: Class Methods](https://realpython.com/instance-class-and-static-methods-demystified/)  
     - [GeeksforGeeks: Classmethod in Python](https://www.geeksforgeeks.org/classmethod-in-python/)

   **Example:**  
   ```python
   class Dog:
       @classmethod
       def from_birth_year(cls, name, birth_year):
           return cls(name, 2023 - birth_year)
   ```

---

## 2. **Static Methods (`@staticmethod`)**  
   - **What it is:** A method that doesn’t depend on the instance or class, used for utility functions.  
   - **Resources:**  
     - [Programiz: Python Staticmethod (Short)](https://www.programiz.com/python-programming/methods/built-in/staticmethod)
     - [Real Python: Static Methods](https://realpython.com/instance-class-and-static-methods-demystified/)
     - [GeeksforGeeks: Staticmethod in Python](https://www.geeksforgeeks.org/staticmethod-in-python/)  

   **Example:**  
   ```python
   class MathUtils:
       @staticmethod
       def add(x, y):
           return x + y
   ```

---

## 🎥 **Video Tutorials**  
- [Class Methods, Static Methods, & Instance Methods EXPLAINED in Python](https://www.youtube.com/watch?v=PIKiHq1O9HQ)  
- [Staticmethod Explained](https://www.youtube.com/watch?v=JQZmzrCSKSY)

---

Happy coding! 😊