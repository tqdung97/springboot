import { combineReducers, createStore } from "redux";
import counterReducer from "./reducers/counterReducer";
import todoReducer from "./reducers/todoReducer";

// Gộp các reducer lại với nhau
const rootReducer = combineReducers({
    counter: counterReducer,
    todos : todoReducer
})

const store = createStore(rootReducer)

export default store;