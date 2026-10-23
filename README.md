# Quiz 2 – Calculator and DateChecker (TDD with JUnit 5)

Java 21 Maven project developed with Test Driven Development (Red → Green → Refactor).

## Project structure

```
src/main/java/org/example/
├── Calculator.java      sum, subtract, multiply, divide, isEven
├── DateChecker.java     has31Days(Month month)
└── Month.java           enum with the twelve calendar months
src/test/java/org/example/
├── CalculatorTest.java
└── DateCheckerTest.java
```

## Requirements

- Java 21
- Maven (JUnit 5 is declared in `pom.xml` and downloaded automatically)

## Running the tests

- IntelliJ: right-click `src/test/java` → **Run 'All Tests'**
- IntelliJ Maven panel: **Quiz2 → Lifecycle → test**
- Command line: `mvn test`

Expected result: `Tests run: 26, Failures: 0, Errors: 0, Skipped: 0` and `BUILD SUCCESS`.

## Design decisions

### Calculator

- All methods use `int` values.
- `divide` returns the integer quotient (Java truncates toward zero, so `-7 / 2` is `-3`).
- Dividing by zero throws `IllegalArgumentException("Cannot divide by zero")`, verified with `assertThrows`.
- `isEven` uses `value % 2 == 0`, which also works for negative numbers (`-3 % 2` is `-1`).

### DateChecker

- `Month` is a separate enum, so only the twelve real months can be passed in.
- `has31Days` returns `true` for JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER.
- It returns `false` for APRIL, JUNE, SEPTEMBER, NOVEMBER.
- **FEBRUARY returns `false`.** It has 28 or 29 days, so it never has 31 days; no separate rule
  is needed. This is tested by `februaryDoesNotHave31Days`.
- A `null` month throws `IllegalArgumentException("Month must not be null")`.

## Tests

| Test class | What is covered |
|---|---|
| `CalculatorTest` (13 tests) | sum, subtract, multiply, divide with positive, negative and zero values; divide by zero with `assertThrows`; isEven with `assertTrue` / `assertFalse` |
| `DateCheckerTest` (13 tests) | `@ParameterizedTest` + `@EnumSource` for the 7 months with 31 days and the 4 months with 30 days; February; null input |

## TDD process

Each behavior was built in a Red → Green → Refactor cycle, visible in the commit history:

- `test:` commits add a failing test (Red) against a stub method.
- `feat:` commits add the smallest code that makes the test pass (Green).
- `refactor:` commits improve the code while all tests stay green.

## Reflection

<!-- Write your own reflection here -->
