# AUCA_ID — School Management System

Java console OOP project based on the supplied AUCA practical assignment.

## Requirements
- JDK 17 or newer
- Compile and run from the `AUCA_ID` directory.

## Run (Windows PowerShell)
```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object FullName)
java -cp out com.auca.main.Main
```

## Run (Linux/macOS)
```bash
find . -name "*.java" -print0 | xargs -0 javac -d out
java -cp out com.auca.main.Main
```

## Included
- The exact prescribed package layout, 2 interfaces, 2 abstract classes, and 11 concrete domain classes.
- Encapsulation, inheritance, overriding, constructor chaining and polymorphism demonstration.
- Custom checked exceptions.
- One shared Scanner, menu loop, typed in-memory collections, prerequisite-aware workflows, duplicate checks, book stock updates, search/list/report operations.
- Basic console registration workflows for the principal entities.

## Important study note
This is a working learning baseline, not a guarantee that every examiner edge case in the 14-page specification is fully covered. In particular, the assignment's detailed four-step Back/Edit/Cancel smart form is only partially implemented for some record types. Read the comments marked TODO and practise explaining and extending the code. Do not claim features you have not personally tested.
