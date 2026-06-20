# 🏨 Smart Hospitality Management System (SHMS)

### Software Design & Architecture Lab — Final Project Solution

![Java](https://img.shields.io/badge/Language-Java-blue.svg)
![Architecture](https://img.shields.io/badge/Focus-Software%20Architecture-red.svg)
![Patterns](https://img.shields.io/badge/Design%20Patterns-7%20Patterns-purple.svg)
![Project](https://img.shields.io/badge/System-SHMS-green.svg)

---

## 📌 Project Overview

The **Smart Hospitality Management System (SHMS)** is the final project for the **Software Design & Architecture Lab**.

The project simulates a modern hotel management environment and demonstrates how multiple software design patterns can be integrated into a single cohesive system. The implementation focuses on building a flexible, maintainable, and extensible architecture while applying object-oriented design principles and clean software engineering practices.

The system supports room management, booking construction, workflow execution, event-driven notifications, billing strategies, payment processing, and centralized configuration management.

Unlike individual pattern exercises, this project requires the collaboration of multiple design patterns within one complete software architecture.

---

## 📖 Repository Purpose

This repository contains a reference implementation of the Smart Hospitality Management System (SHMS).

The project serves as:

* A reference solution for the final project
* An educational resource for studying software design patterns
* A practical example of modular software architecture
* A demonstration of clean object-oriented design principles
* A showcase of pattern collaboration in a real-world business scenario

The implementation emphasizes extensibility, maintainability, loose coupling, and separation of concerns.

---

## 🧠 Problem Context

Modern hospitality systems must support diverse business operations while remaining adaptable to changing requirements.

Different system components exhibit different behaviors:

* Room creation varies according to room type
* Bookings may contain optional services and guest preferences
* Billing rules change according to pricing policies
* Notifications must be delivered to multiple stakeholders
* Hotel operations follow structured workflows
* Legacy systems often require integration with modern applications

A well-designed architecture should accommodate these requirements without introducing excessive complexity or tight coupling.

---

## 🎯 Core System Requirements

### 1. Room & Booking Management

The system supports:

* Multiple room types such as Standard, Deluxe, and Suite
* Room-specific information including pricing, capacity, and features
* Construction of complex booking objects
* Optional guest services and preferences

---

### 2. Hotel Workflow Execution

The system supports:

* Guest check-in workflows
* Guest check-out workflows
* Fixed workflow execution sequences
* Workflow-specific customization while preserving structure

---

### 3. Notification System

The system provides notifications for:

* Guests
* Staff members
* Hotel managers

Supported events include:

* Booking confirmation
* Check-in completion
* Payment processing
* Check-out completion

Notification logic remains completely decoupled from business operations.

---

### 4. Billing System

The system supports multiple pricing strategies:

* Regular pricing
* Member discounts
* Seasonal pricing

Billing behavior can be selected dynamically at runtime without modifying existing code.

---

### 5. Legacy Payment Integration

The system integrates a legacy payment processor whose interface differs from the modern architecture.

The existing legacy implementation is reused without modification.

---

### 6. System Configuration

The system maintains a centralized configuration manager responsible for:

* Hotel settings
* Application-wide configurations
* Shared system information

---

## 🧩 Design Patterns Used

The following design patterns form the architectural foundation of the system:

| Pattern         | Architectural Role                                                              |
| --------------- | ------------------------------------------------------------------------------- |
| Factory Method  | Encapsulates room creation and removes direct object instantiation dependencies |
| Builder         | Constructs complex booking objects incrementally                                |
| Observer        | Provides event-driven notification delivery                                     |
| Strategy        | Enables runtime selection of billing algorithms                                 |
| Template Method | Defines standardized hotel workflow execution                                   |
| Singleton       | Provides centralized configuration management                                   |
| Adapter         | Integrates legacy payment systems without modification                          |

Each pattern is applied to solve a specific architectural problem rather than being included solely for demonstration purposes.

---

## 🔗 Pattern Collaboration

The project demonstrates how design patterns cooperate within a complete software system:

1. Factory Method creates hotel room objects.
2. Builder constructs booking objects with optional services and preferences.
3. Observer broadcasts booking, payment, and workflow events.
4. Template Method controls check-in and check-out processes.
5. Strategy determines billing behavior dynamically.
6. Adapter connects the modern system to the legacy payment processor.
7. Singleton provides global access to configuration settings.

Together, these patterns create a flexible architecture that supports future extensions while minimizing modifications to existing code.

---

## ⚙️ Design Goals

The architecture emphasizes:

* Separation of concerns
* Loose coupling
* High cohesion
* Extensibility
* Reusability
* Maintainability
* Runtime flexibility
* Clean module interaction

The system is designed according to object-oriented design principles and follows the Open/Closed Principle whenever possible.

---

## 🚫 Design Constraints

The following practices are intentionally avoided:

* `if/switch` based behavior selection
* Duplicated business logic
* Tightly coupled modules
* Hardcoded workflow variations
* Direct dependency on legacy implementations
* Monolithic class structures

---

## 🔄 Expected System Flow

A typical execution scenario follows the sequence below:

1. System configuration is initialized
2. Room objects are created
3. Guest booking is constructed
4. Booking confirmation notifications are triggered
5. Check-in workflow begins
6. Billing strategy is selected dynamically
7. Payment is processed through the adapted legacy system
8. Optional services or upgrades are applied
9. Check-out workflow executes
10. Final notifications are delivered

---

## 📦 Repository Structure

```text
src/
├── adapter/
├── builder/
├── factory/
├── observer/
├── singleton/
├── strategy/
├── template/
├── model/
├── service/
└── main/

uml/
└── system-diagram.png

README.md
```

---

## ▶️ Running the Project

### Requirements

* Java 17 or later
* IntelliJ IDEA, Eclipse, or VS Code

### Steps

1. Clone the repository

```bash
git clone https://github.com/Maryam-Skaik/design-patterns-lab-final-project.git
```

2. Open the project in your preferred IDE.

3. Compile and run:

```text
Main.java
```

4. Observe the complete SHMS execution flow, including:

* Room creation
* Booking construction
* Notification delivery
* Workflow execution
* Billing calculation
* Payment processing
* Check-out operations

---

## 📊 UML Diagram

The repository includes an integrated UML class diagram illustrating:

* Class relationships
* Design pattern implementations
* Module interactions
* System architecture

The UML diagram provides a high-level architectural view of the complete system.

---

## 🎯 Learning Outcomes

After studying this project, students should be able to:

* Integrate multiple design patterns within a single application
* Design modular and extensible software systems
* Apply creational, structural, and behavioral patterns appropriately
* Model real-world business scenarios using object-oriented design
* Reduce coupling and improve maintainability
* Justify architectural decisions using software engineering principles
* Understand pattern collaboration within large systems

---

## 👩‍🏫 Course Information

**Course:** Software Design & Architecture Lab

**Project:** Smart Hospitality Management System (SHMS)

**Faculty:** Faculty of Information Technology

**Teaching Assistant:** Maryam Skaik

---

## 📚 Academic Use Notice

This repository was developed for educational purposes within the Software Design & Architecture Lab.

Students are encouraged to study the architectural decisions, design pattern implementations, and software engineering practices demonstrated throughout the project.

The repository is intended as a learning resource and reference implementation for understanding software architecture and design patterns in practice.
