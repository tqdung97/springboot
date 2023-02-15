import Counter from "./component/counter/Counter";
import TodoList from "./component/todo/TodoList";
import { Link, Route, Routes } from "react-router-dom";
import NotFound from "./component/not-found/NotFound";

function App() {
  return (
    <>
      <ul>
        <li>
          <Link to={"/counter"}> Counter App</Link>
        </li>
        <li>
          <Link to={"/todolist"}> Todo App</Link>
        </li>
      </ul>
      <Routes>
        <Route path="/" element={<Counter />} />
        <Route path="/counter" element={<Counter />} />
        <Route path="/todolist" element={<TodoList />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </>
  );
}

export default App;

