import React, { useState, useEffect } from 'react';
import axios from 'axios';

function App() {
  const [todos, setTodos] = useState([]);
  
  useEffect(() => {
    // Fetch todos from backend
    axios.get('http://localhost:8000/api/todos')
      .then(response => setTodos(response.data))
      .catch(error => console.error('Error fetching todos:', error));
  }, []);

  return (
    <div className="App">
      <h1>Todo List</h1>
      <div className="todo-list">
        {todos.map(todo => (
          <div key={todo.id} className="todo-item">
            <h3>{todo.title}</h3>
            <p>{todo.description}</p>
          </div>
        ))}
      </div>
      {/* More UI components will be added using Copilot */}
    </div>
  );
}

export default App;
