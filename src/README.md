# Smart Hospitality Management System (SHMS)

## Reference Architecture and Design Documentation

### Software Design & Architecture Lab – Design Patterns Final Project

---

## 1. Introduction

The Smart Hospitality Management System (SHMS) is a reference implementation developed for the Design Patterns Lab final project.

The purpose of this project is not only to implement hotel-related functionality, but also to demonstrate how multiple software design patterns can work together to solve real architectural problems.

Many students learn design patterns individually through small examples. However, real software systems rarely use a single pattern in isolation. Instead, multiple patterns collaborate to provide flexibility, maintainability, extensibility, and clean separation of responsibilities.

This project simulates a simplified hospitality management environment where hotel staff can create rooms, manage bookings, notify stakeholders, execute operational workflows, calculate bills, process payments, and manage system-wide configuration settings.

Each major requirement of the system is intentionally mapped to an appropriate design pattern so that the final solution reflects realistic software architecture practices.

---

## 2. Project Goals

The system was designed with the following objectives:

* Demonstrate correct application of multiple design patterns.
* Avoid conditional complexity using polymorphism.
* Promote loose coupling between modules.
* Support runtime behavioral changes.
* Allow future extensions with minimal code modifications.
* Separate business logic from infrastructure concerns.
* Simulate a realistic hotel management workflow.

The project follows several software engineering principles including:

* Single Responsibility Principle (SRP)
* Open/Closed Principle (OCP)
* Separation of Concerns
* High Cohesion
* Loose Coupling

---

## 3. Business Scenario

Consider the following scenario:

A guest wants to reserve a room in a hotel.

The system must:

1. Load hotel configuration settings.
2. Create an appropriate room.
3. Construct a booking with optional services.
4. Notify interested stakeholders.
5. Execute the guest check-in workflow.
6. Calculate the bill according to a selected pricing policy.
7. Process payment through a legacy payment service.
8. Execute the guest check-out workflow.
9. Notify stakeholders that the process has completed.

Although this workflow appears simple, it contains multiple architectural challenges:

* Different room types must be created.
* Bookings contain optional information.
* Multiple users must receive notifications.
* Pricing rules may change.
* Workflows share common steps but differ in details.
* Existing payment software cannot be modified.
* Configuration data must remain consistent.

Each of these challenges is solved through a specific design pattern.

---

## 4. Requirement-to-Pattern Mapping

| Requirement                | Design Pattern  | Architectural Purpose                    |
| -------------------------- | --------------- | ---------------------------------------- |
| Room Creation              | Factory Method  | Encapsulate room instantiation           |
| Booking Construction       | Builder         | Create complex booking objects           |
| Event Notifications        | Observer        | Decouple event broadcasting              |
| Billing Calculation        | Strategy        | Support interchangeable pricing policies |
| Check-In / Check-Out       | Template Method | Standardize workflow execution           |
| Global Configuration       | Singleton       | Maintain a single configuration source   |
| Legacy Payment Integration | Adapter         | Connect incompatible interfaces          |

This mapping forms the architectural foundation of the entire system.

---

## 5. Project Structure

```text
src
├── adapter
├── builder
├── factory
├── main
├── model
├── observer
├── singleton
├── strategy
└── template
```

Each package represents a specific architectural responsibility.

The system intentionally separates concerns so that modifications in one module have minimal impact on the rest of the application.

---

## 6. Package Responsibilities

### model

The model package contains the core business entities.

These classes represent the actual objects that exist in the hotel domain.

Examples include:

* Room
* StandardRoom
* DeluxeRoom
* SuiteRoom
* Booking

The model package contains business data but does not contain object creation logic, notification logic, workflow execution logic, or payment integration logic.

This separation keeps domain objects focused and easy to maintain.

---

### factory

The factory package is responsible for room creation.

Instead of allowing client code to directly instantiate room objects using constructors, dedicated factories create rooms on behalf of the system.

Examples:

* RoomFactory
* StandardRoomFactory
* DeluxeRoomFactory
* SuiteRoomFactory

This design allows the application to remain independent of concrete room implementations.

---

### builder

The builder package constructs complex booking objects.

A booking may contain:

* Guest information
* Room information
* Breakfast service
* Airport pickup
* Room upgrades
* Special requests

Rather than creating multiple overloaded constructors, the Builder Pattern allows bookings to be assembled gradually.

This significantly improves readability and maintainability.

---

### observer

The observer package provides event-driven communication.

When important events occur, multiple stakeholders may need to be informed.

Examples include:

* Booking confirmation
* Check-in completion
* Payment processing
* Check-out completion

Observers subscribe to notifications and react automatically when events occur.

Examples:

* Subject
* Observer
* GuestObserver
* StaffObserver
* ManagerObserver

The booking system never communicates directly with individual notification receivers.

This prevents tight coupling.

---

### strategy

The strategy package contains billing algorithms.

Different customers may require different pricing models.

Examples:

* Regular pricing
* Member discounts
* Seasonal pricing

Each pricing policy is implemented as an independent strategy.

This allows pricing behavior to change dynamically without modifying billing code.

---

### template

The template package defines hotel workflows.

Hotel operations usually follow predictable sequences.

For example:

Check-In:

1. Verify reservation
2. Assign room
3. Provide room access

Check-Out:

1. Generate bill
2. Process payment
3. Release room

The Template Method Pattern defines the overall process structure while allowing subclasses to customize individual steps.

---

### adapter

The adapter package integrates external payment services.

The hotel system expects one payment interface while the legacy payment system provides another.

Direct integration is impossible because both interfaces are incompatible.

The adapter translates requests between them.

Examples:

* PaymentProcessor
* PaymentAdapter
* LegacyPaymentSystem

This allows the system to reuse existing software without modification.

---

### singleton

The singleton package manages global configuration.

Examples:

* Hotel name
* Tax rates
* System settings
* Operational configuration

Only one configuration object should exist during application execution.

The Singleton Pattern guarantees this behavior.

Example:

* SystemConfiguration

---

### main

The main package serves as the entry point of the application.

Responsibilities include:

* Initializing system components
* Connecting modules together
* Demonstrating complete execution flow

The main package acts as the orchestrator of the system.

---

## 7. Design Pattern Analysis

### 7.1 Factory Method Pattern

#### Problem

The hotel supports multiple room categories.

Examples:

* Standard Room
* Deluxe Room
* Suite Room

If the application directly creates rooms using constructors, client code becomes tightly coupled to concrete room implementations.

Adding a new room type would require modifying existing code.

#### Solution

Factory Method delegates room creation to specialized factory classes.

Each factory knows how to create its corresponding room type.

#### Benefits

* Encapsulates creation logic.
* Eliminates direct dependencies.
* Supports future room categories.
* Reduces code modification.

---

### 7.2 Builder Pattern

#### Problem

Bookings contain both required and optional information.

Without Builder, constructors quickly become large and difficult to maintain.

For example:

```java
Booking(
 guest,
 room,
 breakfast,
 pickup,
 upgrade,
 specialRequest,
 ...
)
```

As optional parameters increase, readability decreases.

#### Solution

Builder constructs the object step-by-step.

Only required fields must be supplied immediately.

Optional services can be added gradually.

#### Benefits

* Improves readability.
* Simplifies object construction.
* Supports optional attributes naturally.
* Prevents constructor explosion.

---

### 7.3 Observer Pattern

#### Problem

Many stakeholders depend on system events.

For example:

After a booking is confirmed:

* Guest receives confirmation.
* Staff receives reservation details.
* Manager receives activity updates.

Hard-coding these relationships creates strong dependencies.

#### Solution

Observer establishes a publish-subscribe relationship.

Observers register once and automatically receive future updates.

#### Benefits

* Loose coupling.
* Dynamic subscriptions.
* Better extensibility.
* Event-driven architecture.

---

### 7.4 Strategy Pattern

#### Problem

Different pricing policies require different billing calculations.

Embedding all calculations in one class would lead to frequent modifications.

#### Solution

Each pricing policy becomes a separate strategy.

Examples:

* RegularBillingStrategy
* MemberDiscountStrategy
* SeasonalBillingStrategy

#### Benefits

* Runtime flexibility.
* Easy extension.
* Better maintainability.
* No conditional pricing logic.

---

### 7.5 Template Method Pattern

#### Problem

Operational workflows share common structure but differ in implementation details.

#### Solution

Template Method defines:

* workflow sequence
* execution order
* mandatory steps

Subclasses provide workflow-specific behavior.

#### Benefits

* Consistent execution.
* Reduced duplication.
* Easier maintenance.
* Controlled customization.

---

### 7.6 Singleton Pattern

#### Problem

Multiple configuration objects may create inconsistent system behavior.

#### Solution

Singleton guarantees a single shared configuration instance.

#### Benefits

* Consistent settings.
* Centralized management.
* Controlled access.
* Reduced resource usage.

---

### 7.7 Adapter Pattern

#### Problem

The legacy payment system cannot be modified.

Its interface does not match the requirements of SHMS.

#### Solution

Adapter translates between both interfaces.

The rest of the application communicates only with the modern interface.

#### Benefits

* Reuses legacy software.
* Avoids risky modifications.
* Simplifies integration.
* Supports future providers.

---

## 8. Complete System Execution Flow

The following sequence demonstrates a typical system execution.

### Step 1 – System Initialization

The application starts.

The Singleton configuration object is created and system settings become available globally.

Pattern Used:

* Singleton

---

### Step 2 – Room Creation

A factory creates the requested room type.

Example:

* Deluxe Room

Pattern Used:

* Factory Method

Output Example:

```text
Deluxe Room created successfully
```

---

### Step 3 – Booking Construction

A booking is assembled using Builder.

Optional services may be included.

Examples:

* Breakfast
* Airport Pickup
* Upgrade Service

Pattern Used:

* Builder

---

### Step 4 – Booking Notification

The booking event is published.

Observers automatically receive updates.

Recipients:

* Guest
* Staff
* Manager

Pattern Used:

* Observer

---

### Step 5 – Check-In Workflow

The check-in workflow executes through Template Method.

Example:

```text
Verify Booking
Assign Room
Provide Access
```

Pattern Used:

* Template Method

---

### Step 6 – Billing Calculation

A pricing strategy is selected.

Example:

```text
MemberDiscountStrategy
```

The bill is calculated according to the selected algorithm.

Pattern Used:

* Strategy

---

### Step 7 – Payment Processing

The system requests payment processing.

The adapter translates the request and forwards it to the legacy payment service.

Pattern Used:

* Adapter

---

### Step 8 – Check-Out Workflow

The guest completes the checkout process.

Example:

```text
Generate Bill
Process Payment
Release Room
```

Pattern Used:

* Template Method

---

### Step 9 – Final Notifications

Observers receive final completion events.

Pattern Used:

* Observer

---

## 9. Pattern Collaboration Diagram

```text
SystemConfiguration (Singleton)
            │
            ▼
 RoomFactory (Factory Method)
            │
            ▼
  BookingBuilder (Builder)
            │
            ▼
         Booking
            │
            ▼
    Subject / Observers
            │
            ▼
    CheckInWorkflow
            │
            ▼
    BillingStrategy
            │
            ▼
    PaymentAdapter
            │
            ▼
  LegacyPaymentSystem
            │
            ▼
   CheckOutWorkflow
            │
            ▼
       Observers
```

This collaboration demonstrates how independent patterns work together to support a complete business process.

---

## 10. Architectural Quality Attributes

### Extensibility

New room types, workflows, billing algorithms, payment providers, and notification channels can be introduced without modifying existing code.

### Maintainability

Each module has a clearly defined responsibility, reducing complexity and simplifying future updates.

### Reusability

Patterns can be reused independently in other applications.

### Scalability

The architecture supports future system growth without major restructuring.

### Testability

Modules can be tested independently because responsibilities are properly isolated.

---

## 11. Design Constraints Satisfied

The implementation follows all project requirements.

### Avoided

* Conditional behavior selection using if/switch
* Duplicated business logic
* Tight coupling between modules
* Direct dependency on legacy systems
* Hardcoded workflow implementations

### Applied Principles

* Single Responsibility Principle
* Open/Closed Principle
* Separation of Concerns
* Loose Coupling
* High Cohesion

---

## 12. UML Class Diagram

The UML class diagram included with this project illustrates:

* Class relationships
* Pattern implementations
* Dependencies between modules
* Inheritance hierarchies
* Pattern collaboration structure

The diagram should be reviewed together with the source code and this document to fully understand the system architecture.

> Insert UML diagram image here.

---

## 13. Conclusion

The Smart Hospitality Management System demonstrates how multiple design patterns can be integrated into a unified software architecture to address realistic business requirements.

Rather than treating design patterns as isolated academic concepts, this project shows how Factory Method, Builder, Observer, Strategy, Template Method, Singleton, and Adapter collaborate to solve object creation, workflow management, notification handling, billing flexibility, configuration management, and legacy system integration challenges.

The resulting architecture is modular, extensible, maintainable, and aligned with modern software engineering practices.

This project serves as a reference implementation for understanding how design patterns operate collectively in real-world system design.
