# Assignment: OOP Garage System

## Overview
You are tasked with designing and implementing a simple garage system using object-oriented programming principles in Java. The system should model different types of vehicles and demonstrate the use of inheritance, abstraction, interfaces, and polymorphism.

## Requirements

### 1. Class Hierarchy
- Create an abstract class `Vehicle` with at least the following:
  - Private fields for `brand` and `speed`
  - Getters and setters as appropriate
  - An abstract method `honk()`
  - Concrete methods for `accelerate(int amount)` and `brake(int amount)`

- Implement the following subclasses:
  - `Car` (extends `Vehicle`)
  - `Motorbike` (extends `Vehicle`)
  - `ElectricCar` (extends `Car` and implements `EcoFriendly` interface)

- Create an interface `EcoFriendly` with at least:
  - `void chargeBattery()`
  - `boolean isBatteryFull()`

### 2. Functionality
- Each subclass must provide its own implementation of the `honk()` method.
- `ElectricCar` should only be able to accelerate if its battery is full.
- `Motorbike` should only be able to accelerate if a helmet is worn.
- Demonstrate encapsulation by keeping fields private and using getters/setters.

### 3. Main Program
- In the `Main` class, create instances of each vehicle type.
- Demonstrate the following:
  - Accelerating, braking, and honking for each vehicle.
  - Special behaviors (e.g., battery charging, helmet requirement).
  - Use a polymorphic array or collection to store vehicles and perform actions in a loop.

### 4. Extension (Bonus)
- Add a new vehicle type (e.g., `Truck`) with its own unique behavior.
- Add additional features to existing classes (e.g., more eco-friendly methods, safety features).
