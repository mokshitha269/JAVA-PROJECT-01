# JAVA-PROJECT-01# Delivery Management System

A console-based Java application that manages delivery packages and couriers. It calculates delivery charges, tracks courier statuses, analyses delivery distances, and saves a report to a text file.

## Features

- **Package management:** enter tracking ID, weight, distance, and status for multiple packages
- **Charge calculation:** standard packages cost `50 + (10 x weight)`. Packages with a distance over 100 are treated as Express and add a `100` surcharge
- **Input validation:** rejects negative weight or distance and invalid status codes
- **Tracking ID search:** linear search and binary search (after sorting)
- **Courier status tracking:** assign and update statuses for couriers, and show which have delivered
- **Distance analysis:** total, average, maximum, count of deliveries above 100, and sorted distances
- **Route matrix:** a 2D table of distances between locations
- **String operations:** length and uppercase conversion of a delivery note
- **File report:** saves package details to `delivery_report.txt` and reads it back

## Status Codes

| Code | Status           |
|------|------------------|
| 1    | Package Created  |
| 2    | In Transit       |
| 3    | Out for Delivery |
| 4    | Delivered        |

## Java Concepts Demonstrated

| Concept          | Where it is used                                                      |
|------------------|-----------------------------------------------------------------------|
| Encapsulation    | Private fields with getters and a setter in `DeliveryPackage`         |
| Inheritance      | `ExpressPackage extends DeliveryPackage`                              |
| Polymorphism     | Overridden `calculateCharge()` called through a parent reference      |
| Collections      | `ArrayList`, `HashSet`, `HashMap`, `Iterator`                         |
| Searching        | Custom linear search and `Collections.binarySearch`                   |
| Sorting          | `Collections.sort` and `Arrays.sort`                                  |
| Arrays           | 1D array for distance analysis, 2D array for the route matrix         |
| Strings          | `trim()`, `length()`, `toUpperCase()`, `StringBuilder`                |
| File handling    | `Files.writeString`, `Files.readAllLines`, `Path`                     |
| Exception handling | try-catch for `IOException`                                         |

## Project Structure

```
PROJECT.java          Main source file (contains all classes)
delivery_report.txt   Generated at runtime
README.md             This file
```

### Classes

- **`DeliveryPackage`:** base class holding package data and the standard charge calculation
- **`ExpressPackage`:** subclass that adds a surcharge for long-distance deliveries
- **`PROJECT`:** main class with the `main` method, status mapping, and ID search helper

## Requirements

- Java JDK 11 or higher (uses `Path.of`, `Files.writeString`)

## How to Run

```bash
javac PROJECT.java
java PROJECT
```

The file must be named `PROJECT.java` because `PROJECT` is the public class.

## Sample Run

```
===== DELIVERY MANAGEMENT SYSTEM =====
Enter number of packages: 2
Enter tracking ID: 101
Enter package weight: 5
Enter delivery distance: 150
Enter status (1-4): 2
Delivery Charge = 200
Enter tracking ID: 102
Enter package weight: 3
Enter delivery distance: 40
Enter status (1-4): 4
Delivery Charge = 80

===== PACKAGE DETAILS =====
Tracking ID: 101, Weight: 5, Distance: 150, Status: In Transit
Tracking ID: 102, Weight: 3, Distance: 40, Status: Delivered
...
```

## Known Limitations

- Entering non-numeric input where a number is expected causes `InputMismatchException`
- Duplicate tracking IDs are not rejected
- Weight of 0 is accepted
- Data is not stored between runs, apart from the generated report
- The interface is sequential, not menu-driven

## Future Improvements

- Menu-driven interface
- Exception handling for invalid input
- Duplicate tracking ID prevention
- Database storage
- Distance-based pricing
- GUI version
