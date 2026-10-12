# 🚀 NetworkFlowOptimizer

**A Java-based network flow visualization and optimization tool using maximum-flow algorithms.**

NetworkFlowOptimizer is a desktop application that models networks as directed graphs and calculates the maximum possible flow from a source vertex to a destination vertex. It implements two well-known maximum-flow algorithms and provides a graphical interface for exploring network flow optimization.

## 📌 Overview

Network flow optimization is a fundamental graph theory problem used in transportation, communication networks, resource allocation, logistics, and scheduling.

This project represents a network using vertices and capacity-constrained edges. It computes the maximum flow that can be sent from a source to a sink while respecting the capacity of each edge.

## ✨ Features

- **Maximum Flow Calculation:** Computes the maximum flow between a source and a sink.
- **Dinic's Algorithm:** Uses level graphs and blocking flows to find maximum flow efficiently.
- **Edmonds–Karp Algorithm:** Uses breadth-first search (BFS) to find augmenting paths.
- **Graph Representation:** Models networks with vertices, directed edges, and capacities.
- **Graphical User Interface:** Provides a Java Swing-based desktop interface.
- **Performance Measurement:** Includes utilities for timing and comparing algorithm execution.
- **Modular Architecture:** Separates graph structures, algorithms, GUI components, and utility classes.

## 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java | Core programming language |
| Java Swing | Desktop graphical user interface |
| Graph Theory | Network modeling and optimization |
| Dinic's Algorithm | Maximum-flow computation |
| Edmonds–Karp Algorithm | Maximum-flow computation |
| Git and GitHub | Version control and collaboration |

## 📂 Project Structure

```text
NetworkFlowOptimizer/
├── src/
│   ├── Main.java
│   ├── algorithms/
│   │   ├── Dinic.java
│   │   └── EdmondsKarp.java
│   ├── graph/
│   │   ├── Edge.java
│   │   ├── Graph.java
│   │   └── Vertex.java
│   ├── gui/
│   │   ├── ControlPanel.java
│   │   ├── GraphPanel.java
│   │   └── MainFrame.java
│   └── utils/
│       ├── AlgorithmResult.java
│       ├── Performance.java
│       └── Timer.java
├── lib/
├── .vscode/
├── .gitignore
└── README.md
```

## ⚙️ Prerequisites

Before running the project, install:

- Java Development Kit (JDK)
- Visual Studio Code or another Java-compatible IDE (optional)
- Git (optional, for cloning and version control)

Verify your Java installation:

```bash
java -version
javac -version
```

## ▶️ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/nikhilsangu-ux/DSA_Project_Team-8.git
cd DSA_Project_Team-8
```

> If the repository contains multiple projects, navigate to the `NetworkFlowOptimizer` folder before running the commands below.

### 2. Compile the source files

From the `NetworkFlowOptimizer` project directory, run:

```bash
mkdir -p bin
javac -d bin src/Main.java src/graph/*.java src/algorithms/*.java src/utils/*.java src/gui/*.java
```

### 3. Run the application

```bash
java -cp bin Main
```

The graphical interface should launch if the project compiles successfully and the environment supports Java Swing.

## 🧠 Algorithms Used

### 1. Dinic's Algorithm

Dinic's algorithm calculates maximum flow using:

1. Breadth-first search to construct a level graph.
2. Depth-first search to find blocking flows.
3. Repeated flow augmentation until no more augmenting paths exist.

**Time complexity:** \(O(V^2E)\) for general graphs.

### 2. Edmonds–Karp Algorithm

Edmonds–Karp is an implementation of the Ford–Fulkerson method that uses BFS to find the shortest augmenting path in terms of the number of edges.

1. Search for an augmenting path using BFS.
2. Determine the residual capacity along the path.
3. Increase the flow and update residual capacities.
4. Repeat until no augmenting path remains.

**Time complexity:** \(O(VE^2)\).

Here, \(V\) is the number of vertices and \(E\) is the number of edges.

## 📊 Applications

Network flow optimization can be applied to:

- Transportation and traffic networks
- Communication and computer networks
- Supply chain and logistics planning
- Resource allocation
- Bipartite matching and assignment problems
- Capacity planning and scheduling

## 🎯 Project Objectives

- Apply graph theory concepts to a practical optimization problem.
- Implement and understand two maximum-flow algorithms.
- Visualize and explore network structures through a desktop GUI.
- Measure algorithm execution time and compare performance.
- Develop modular, maintainable Java code.

## 🔮 Future Enhancements

- Allow users to create graphs interactively.
- Support editing edge capacities and selecting source and sink vertices.
- Animate augmenting paths and residual graph updates.
- Display the maximum-flow value and minimum cut.
- Add larger test networks and automated correctness tests.
- Export graph data and algorithm results.
- Improve performance comparison and visualization.

## 👥 Contributors

**DSA Project Team 8**

This project was developed as part of a Data Structures and Algorithms project.

## 📄 License

This project is intended for educational and academic use. Add a formal open-source license if you plan to distribute it under specific reuse terms.

---

⭐ If you find this project useful, consider starring the repository on GitHub.
