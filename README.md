# 📦 Warehouse Inventory Management

A Java-based console application that efficiently manages warehouse inventory using **Data Structures and Algorithms (DSA)** and follows **Object-Oriented Programming (OOP)** principles like Composition and SOLID design.

## 🔧 Features

- Add, update, and delete items from inventory
- Track inventory using:
  - **HashMap** for fast item lookup
  - **Binary Search Tree (BST)** for sorted access by quantity
  - **MinHeap / PriorityQueue** for low-stock alerts
- Search items by ID or name
- Sort and list inventory based on quantity
- Maintain real-time item count and availability

## 🧠 DSA Concepts Used

| Data Structure | Purpose |
|----------------|---------|
| `HashMap`      | Fast lookup of items by ID/name |
| `PriorityQueue` (MinHeap) | Quick access to low-stock items |
| `Binary Search Tree` | Efficient sorting and traversal of items by quantity |

## 🧱 OOP Principles Applied

- **Composition**: `InventoryManager` uses composed classes like `Item`, `InventoryTree`, and `LowStockQueue`
- **SOLID** Principles:
  - **S**ingle Responsibility: Each class handles one responsibility
  - **O**pen/Closed: Code is open for extension, closed for modification
  - **L**iskov Substitution: Interchangeable components (e.g., different sorting strategies)
  - **I**nterface Segregation: Separate interfaces for searchable, sortable, and stock-manageable features
  - **D**ependency Inversion: Abstractions over low-level modules (e.g., storage or sorting logic)

✅ Future Improvements
Add file-based persistence

Implement a simple GUI using JavaFX or Swing

Add unit testing with JUnit

REST API wrapper for external integration

👨‍💻 Author
Your Name – @SuryanshKumar



