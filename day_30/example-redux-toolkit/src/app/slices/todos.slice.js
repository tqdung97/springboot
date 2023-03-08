import { createSlice } from '@reduxjs/toolkit';

const initialState = [
    { id: 1, title: "Đá bóng", status: false },
    { id: 2, title: "Làm bài tập", status: true },
    { id: 3, title: "Đi chơi", status: true },
]

const todosSlice = createSlice({
    name: "todos",
    initialState,
    reducers: {
        addTodo: (state, action) => {
            state.push(action.payload);
        },
        deleteTodo: (state, action) => {
            const { id } = action.payload; // Lấy ra id trong object action.payload
            const index = state.findIndex(todo => todo.id === id); // Tìm index của todo cần xóa trong state
            state.splice(index, 1); // Xóa trong state
        },
        updateTodo: (state, action) => {
            const { id } = action.payload; // Lấy ra id trong object action.payload
            const index = state.findIndex(todo => todo.id === id); // Tìm index của todo cần xóa trong state
            state[index] = action.payload; // Gán lại giá trị của phần tử tại vị trí index
        },
    }
});

export const { addTodo, deleteTodo, updateTodo } = todosSlice.actions

export default todosSlice.reducer