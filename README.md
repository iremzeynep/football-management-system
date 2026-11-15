# Football Management System (Data Structures & Algorithms)

*Note: This project was developed as part of a university group assignment to demonstrate practical mastery of Data Structures, Algorithms, and Object-Oriented Programming (OOP) principles in Java.*

A comprehensive Java console application that simulates a football league and team management system. Rather than relying on built-in Java Collection utilities, this project is engineered around **custom Data Structures implemented from scratch** to handle entity storage, match scheduling, match history auditing, search operations, and dynamic league rankings.

## Custom Data Structures Implemented

* **MaxHeap (`MaxHeap.java`, `LeagueRankings.java`):** Dynamically maintains and updates league standings. Teams are prioritized by total points, using goal difference as the tie-breaker.
* **HashTable (`HashTable.java`):** A custom hash table supporting Linear Probing, Quadratic Probing, and Double Hashing algorithms to store, look up, and delete `Team` and `Player` records via UUID hash codes.
* **Binary Search Tree (`BinarySearchTree.java`, `SearchFunctionality.java`):** Organizes team and player names alphabetically to support efficient search queries with $O(\log n)$ average time complexity.
* **Generic Stack & Queue (`Stack.java`, `Queue.java`, `MatchSimulation.java`):** A custom `Queue` manages upcoming match fixtures in FIFO order, while a custom `Stack` records completed matches in LIFO order to audit history or retrieve the last *N* match results.
* **Singly Linked List (`LinkedList.java`, `Node.java`):** Dynamically manages each team's active player roster.

## Key Features

* **Team & Player CRUD Management:** Create players and teams with unique UUIDs, assign players to team rosters, and update or remove records dynamically.
* **Automated Match Simulation:** Processes queued fixtures, generates match scores, automatically calculates goal differences, and awards league points (Win: 3, Draw: 1, Loss: 0).
* **Dynamic League Standings:** Extracts and re-orders teams in real time whenever match results or team points are updated.
* **Fast Entity Lookup:** Combines Hash Table ID verification with Binary Search Tree name lookups.

## Project Structure

```text
src/footballmanagementsystem/
├── BinarySearchTree.java
├── FootballManagementSystem.java
├── HashTable.java
├── LeagueRankings.java
├── LinkedList.java
├── Match.java
├── MatchSimulation.java
├── MaxHeap.java
├── Node.java
├── Player.java
├── Queue.java
├── SearchFunctionality.java
├── Stack.java
└── Team.java
