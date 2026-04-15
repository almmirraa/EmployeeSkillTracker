# Employee Skill Tracker

## Student Information
Name: Almira Orozbekova  
Course: Foundations of Creative Industries  
University: Ala-Too International University  

---

## Project Description
Employee Skill Tracker is a console-based Java application that allows users to manage employees and their skills efficiently. The system supports creating, updating, deleting employees, and assigning different types of skills to them.

---

## Objectives
- To apply Object-Oriented Programming (OOP) concepts
- To build a modular and scalable Java application
- To implement CRUD operations
- To practice file handling and data persistence
- To improve input validation and error handling

---

## Key Features (Requirements)

1. Add new employees  
2. View all employees  
3. Update employee information  
4. Delete employees  
5. Add skills to employees  
6. View employees with their skills  
7. Update skill level  
8. Delete skills  
9. Save data to file  
10. Load data from file  

---

## OOP Concepts Used

- **Encapsulation** - Private fields with getters/setters  
- **Inheritance** - 
  - `Employee` extends `Person`  
  - `TechnicalSkill` and `SoftSkill` extend `Skill`  
- **Polymorphism** - Using `List<Skill>` and overridden methods  
- **Abstraction** - Interface `Displayable`

---

## Project Structure

src/

├── model/
│ ├── Employee.java
│ ├── Person.java
│ ├── Skill.java
│ ├── TechnicalSkill.java
│ └── SoftSkill.java
│
├── service/
│ └── EmployeeManager.java
│
├── util/
│ ├── FileManager.java
│ └── InputValidator.java
│
├── interfaces/
│ └── Displayable.java
│
└── Main.java


---

## Data Persistence

The system uses file handling to store data in a `.txt` file.

- Save - stores all employees and skills
- Load - restores saved data

---

## Sample Test Cases

### Test Case 1: Add Employee
Input:
1
ID: 1
Name: Almira
Department: IT
Position: Intern
Email: almira@gmail.com

Output:
Employee added successfully!


---

### Test Case 2: Add Skill
Input:
5
Employee ID: 1
Skill ID: 101
Skill Name: Java
Level: 8
Type: Technical

Output:
Skill added successfully!

---

### Test Case 3: View Employees with Skills
Output:
Employee ID: 1, Name: Almira, Department: IT
Skill: Java (Level 8)

---

## Error Handling

- Prevents invalid numeric input  
- Validates email format  
- Handles missing employees or skills  

---

## Future Improvements

- Add GUI interface  
- Integrate database (MySQL)  
- Add authentication system  
- Improve user interface  

---

## GitHub Repository
https://github.com/almmirraa/EmployeeSkillTracker

---

## Presentation Content
(To be added: slides)


