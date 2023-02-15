
import { configureStore } from "@reduxjs/toolkit";
import counterReducer from "./slices/counter.slice";
import todosReducer from "./slices/todo.slice";
const store = configureStore({
    reducer: {
        counter: counterReducer,
        todos: todosReducer
    }
})

export default store;