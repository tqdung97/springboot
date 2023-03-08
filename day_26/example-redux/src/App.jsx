import { Link, Route, Routes } from "react-router-dom";
import Counter from "./components/counter/Counter";
import NotFound from "./components/not-found/NotFound";
import TodoList from "./components/todolist/TodoList";
import { createAction } from "@reduxjs/toolkit";

function App() {
    const actionCreator = createAction("SOME_ACTION_TYPE");

    console.log(actionCreator.toString());
    return (
        <>
            <ul>
                <li>
                    <Link to={"/counter"}>Counter App</Link>
                </li>
                <li>
                    <Link to={"/todolist"}>Todo App</Link>
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
