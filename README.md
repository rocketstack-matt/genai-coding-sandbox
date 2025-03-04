# GenAI Coding Assistant Assessment Framework

This document provides a structured approach to assess various GenAI coding assistants (CAs) using the demo-todo application. The assessment is designed to progressively test different capabilities, from basic code completion to complex refactoring tasks.

## About the Demo Todo App

The demo-todo application is a skeleton Todo app with:
- **Backend**: Spring Boot with H2 in-memory database
- **Frontend**: React
- **Structure**: Intentionally incomplete to test CA capabilities

## Assessment Instructions

### Setup
1. Open this project in your preferred IDE
2. Have the CA interface ready (this could be an IDE plugin, web interface, etc.)
3. For each test, copy the provided prompt into the CA interface
4. Evaluate the CA's response based on the criteria provided

### Base Level Testing

Most GenAI coding assistants have limited capabilities:
- They can suggest code but may not be able to create new files
- They may only be able to edit files that are already open
- They typically work with the context provided to them

For each test, open the relevant files before providing the prompt to the CA. If a prompt requires creating a new file, you may need to create an empty file first and then ask the CA to provide the content.

### 1. Code Completion Assessment

#### 1.1 Method Implementation
**Prompt:**
```
I have the TodoController class open. Please suggest code to add the following endpoints:
1. GET /api/todos/{id} to retrieve a single todo by ID
2. POST /api/todos to create a new todo
3. PUT /api/todos/{id} to update an existing todo
4. DELETE /api/todos/{id} to delete a todo

Implement proper error handling for cases like todo not found.
```

**Evaluation Criteria:**
- Did the CA correctly implement all requested endpoints?
- Did it handle error cases appropriately?
- Did it follow REST conventions?
- Did it use appropriate HTTP status codes?

#### 1.2 Parameter Suggestions
**Prompt:**
```
I need to add a method to the TodoRepository interface that finds todos by their completion status. How should I implement this?
```

**Evaluation Criteria:**
- Did the CA suggest appropriate method names following Spring Data JPA conventions?
- Did it provide the correct parameter types?
- Did it explain how the method works?

### 2. Code Generation Assessment

#### 2.1 New API Endpoint
**Prompt:**
```
I'm looking at the TodoController and TodoRepository files. I need to add a new endpoint that allows filtering todos by completion status and searching by title (case-insensitive partial match). The endpoint should support pagination. Please suggest the code I should add to both files.
```

**Evaluation Criteria:**
- Did the CA generate a working endpoint with all requested features?
- Did it implement pagination correctly?
- Did it handle the search functionality properly?
- Did it add necessary methods to the repository?

#### 2.2 React Component
**Prompt:**
```
I need to create a React component called TodoForm that allows users to add a new todo. The form should have fields for title and description, and a checkbox for completion status. It should include form validation to ensure the title is not empty and make an API call to create the todo when submitted. I have the App.js file open. Please provide the code for this component.
```

**Evaluation Criteria:**
- Did the CA generate a complete, working React component?
- Did it implement form validation?
- Did it handle the API call correctly?
- Did it follow React best practices?

#### 2.3 Database Query
**Prompt:**
```
I need to add functionality to find todos with titles containing a given string, ordered by completion status (incomplete first) and then by ID. I have both the TodoRepository and TodoController files open. Please suggest the code I should add to implement this feature.
```

**Evaluation Criteria:**
- Did the CA generate the correct repository method?
- Did it implement the ordering correctly?
- Did it add a properly functioning endpoint?

### 3. Documentation Assistance

#### 3.1 Method Documentation
**Prompt:**
```
I have the TodoController class open. Please add comprehensive JavaDoc comments to all methods in this class.
```

**Evaluation Criteria:**
- Did the CA generate clear and informative JavaDoc comments?
- Did it document parameters, return values, and exceptions?
- Did it provide context about what each method does?

#### 3.2 API Documentation
**Prompt:**
```
I want to add Swagger/OpenAPI documentation to my Todo API. I need to know:
1. What dependencies to add to my pom.xml
2. What configuration code to add
3. What annotations to add to my TodoController

Please provide the code for each of these steps.
```

**Evaluation Criteria:**
- Did the CA suggest the correct dependencies?
- Did it provide proper configuration code?
- Did it suggest appropriate annotations for the controller?

### 4. Unit Test Generation

#### 4.1 Controller Tests
**Prompt:**
```
I need to create unit tests for the TodoController class using JUnit and MockMvc. Please provide test code that covers all endpoints and includes tests for error cases.
```

**Evaluation Criteria:**
- Did the CA generate comprehensive tests?
- Did it mock dependencies correctly?
- Did it test both success and error scenarios?
- Did it follow testing best practices?

#### 4.2 React Component Tests
**Prompt:**
```
I need to write tests for my TodoForm React component using React Testing Library. The tests should cover form submission, validation, and error handling. Please provide the test code.
```

**Evaluation Criteria:**
- Did the CA generate appropriate component tests?
- Did it test user interactions correctly?
- Did it suggest how to mock API calls?

### 5. Code Refactoring

#### 5.1 Extract Service Layer
**Prompt:**
```
I want to refactor my application to add a service layer between the controller and repository. I have the TodoController and TodoRepository files open. Please suggest how I should:
1. Create a TodoService interface and implementation
2. Move business logic from the controller to the service
3. Update the controller to use the service

Provide the code for each of these steps.
```

**Evaluation Criteria:**
- Did the CA correctly suggest a service layer structure?
- Did it show how to move business logic appropriately?
- Did it explain how to update the controller?
- Did its suggestions maintain the existing functionality?

#### 5.2 Implement Design Patterns
**Prompt:**
```
I want to improve my Todo application by implementing these design patterns:
1. DTO pattern for API requests/responses
2. Builder pattern for Todo objects

I have the Todo model and TodoController files open. Please suggest the code changes needed to implement these patterns.
```

**Evaluation Criteria:**
- Did the CA correctly explain each design pattern?
- Did it provide appropriate implementation code?
- Did it explain the benefits of each pattern?
- Did its suggestions maintain existing functionality?

### 6. Learning and Exploration

#### 6.1 Spring Boot Concepts
**Prompt:**
```
Explain how Spring Boot's dependency injection works and show examples of constructor injection, setter injection, and field injection in the context of this application. Which approach is recommended and why?
```

**Evaluation Criteria:**
- Did the CA provide a clear explanation of dependency injection?
- Did it show correct examples of each injection type?
- Did it provide a reasoned recommendation?

#### 6.2 React Best Practices
**Prompt:**
```
I have my App.js file open. Please analyze this React code and suggest improvements based on modern React best practices. Consider component structure, state management, and performance optimization.
```

**Evaluation Criteria:**
- Did the CA identify areas for improvement?
- Did it suggest relevant best practices?
- Did it provide concrete examples of how to implement improvements?

### 7. Fixing Errors

#### 7.1 Debugging
**Prompt:**
```
The following code in my TodoController has a bug:

@PutMapping("/{id}")
public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
    return todoRepository.findById(id)
        .map(existingTodo -> {
            existingTodo.setTitle(todo.getTitle());
            existingTodo.setDescription(todo.getDescription());
            existingTodo.setCompleted(todo.isCompleted());
            todoRepository.save(existingTodo);
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found"));
}

Please fix the bug and explain what was wrong.
```

**Evaluation Criteria:**
- Did the CA identify and fix the bug correctly?
- Did it explain the root cause of the issue?
- Did it suggest any improvements beyond the fix?

#### 7.2 Error Handling
**Prompt:**
```
I want to implement better error handling in my Spring Boot application. Please suggest code for a global exception handler that handles common exceptions and returns appropriate HTTP responses with meaningful error messages.
```

**Evaluation Criteria:**
- Did the CA suggest a proper exception handler structure?
- Did it handle relevant exception types?
- Did it show how to return appropriate status codes and messages?

### 8. Multi-language Support

#### 8.1 Full-Stack Feature
**Prompt:**
```
I want to add a "due date" feature to my Todo application. I have the Todo.java, TodoRepository.java, TodoController.java, and App.js files open. Please suggest the changes needed to:
1. Add a dueDate field to the Todo entity
2. Update the API to support filtering by due date
3. Add a date picker to the frontend form
4. Display the due date in the todo list with color coding for overdue items
```

**Evaluation Criteria:**
- Did the CA suggest appropriate changes for both backend and frontend?
- Did it handle date formatting and validation correctly?
- Did it suggest how to implement the filtering functionality?
- Did it provide code for the UI elements?

## Advanced Assessment for Agentic CAs with Workspace & Terminal Capabilities

For CAs with more advanced capabilities, you should skip the prior section and instead run the following prompt in one go:

**Prompt:**
```
Given you are an advanced agentic coding assistant, read the entire README.md in the root of this project, execute all steps and test each of them as you go. 

Create an OUTPUT.md file where you will document the steps you executed and how successful you were in each step.

Do not attempt to fix any step you fail on more than three times.

If you need assistance, more information or help to run commands then please ask.
```

## Conclusion

This assessment framework provides a structured approach to evaluate GenAI coding assistants across a range of capabilities. By using the same prompts and evaluation criteria across different CAs, you can make meaningful comparisons of their strengths and limitations.

Remember that different CAs may have different specialties and limitations, so consider the results in the context of your specific use cases and requirements.