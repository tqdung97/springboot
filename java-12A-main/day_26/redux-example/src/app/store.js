import { combineReducers, createStore } from "redux";
import counterReducer from "./reducer/counterReducer";
import todoReducer from "./reducer/todoReducers";

// Gộp các reducer lại với nhau
const rootReducer = combineReducers({
   counter: counterReducer,
    todos : todoReducer
})

const store = createStore(rootReducer)

export default store;