# Pet Care System OOP Code Review Exercise

## Code Review Session: OOP Concepts in Python

Welcome! In this code review session, we will build a simple Pet Care System for an animal shelter using Object-Oriented Programming (OOP) concepts in Python. The goal is to demonstrate OOP principles such as classes, inheritance, encapsulation, class/static methods, and more.

---

## What We'll Cover

- **Defining Classes and Objects**
- **Inheritance and Method Overriding**
- **Class Methods and Static Methods**
- **Encapsulation and Attributes**
- **Practical OOP Design**

---

## Scenario

We want to help an animal shelter manage its pets and adoptions. We'll model pets, specific pet types (cats and dogs), and the shelter itself.

---

## Step-by-Step Plan

1. **Create a `Pet` base class**
   - Attributes: `name`, `age`, `species`, `is_available_for_adoption`, `shelter`
   - Methods: `display_info`, `make_sound`, `validate_pet_name` (static method)

2. **Create `Cat` and `Dog` subclasses**
   - Add specific attributes (`color` for cats, `breed` for dogs)
   - Override `make_sound`
   - Add class methods to create specific types:
     - `Cat.create_yellow_cat(name, age)`
     - `Dog.create_chihuahua(name, age)`

3. **Create a `Shelter` class**
   - Manage a list of pets
   - Methods: `add_pet`, `list_pets`, `find_pet_by_name`, `adopt_pet`, `return_pet`
   - Track total adoptions (class variable)
   - Show opening hours (static method)

4. **Demonstrate OOP in Action**
   - Instantiate objects
   - Use class and static methods
   - Show inheritance and method overriding
   - Interact with the shelter and pets

---

## Example Code Review Flow

```python
from shelter import Shelter
from cat import Cat
from dog import Dog

# Create a shelter instance
shelter = Shelter("Happy Tails")

# Create pets using class methods (with name validation)
cat1 = Cat.create_yellow_cat("Milo", 2)
dog1 = Dog.create_chihuahua("Bella", 3)

# Add pets to the shelter
if cat1:
    shelter.add_pet(cat1)
if dog1:
    shelter.add_pet(dog1)

# List all pets
shelter.list_pets()

# Adopt and return pets
shelter.adopt_pet("Milo")
shelter.return_pet("Milo")

# Show opening hours
Shelter.show_opening_hours("weekday")
```

---

## Discussion Points

- Why use inheritance for `Cat` and `Dog`?
- When to use class methods vs static methods?
- How does encapsulation help organize our code?
- How can we extend this system further?

---

**Bonus:**  
Try adding more pet types, or features like feeding schedules or medical records!

---
