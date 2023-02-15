import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
const randomId = () => {
  return Math.floor(Math.random() * 1000);
}
function TodoList() {
  const todos = useSelector((state) => state.todos);
  const dispatch = useDispatch();

  const [title, setTitle] = useState("");

  const handleAdd = () => {
    if (title === "") {
      alert("Tiêu đề không được để trống");
      return;
    }
    const newTodo = {
      id: randomId(),
      title: title,
      status: false,
    };
    dispatch(addTodo(newTodo));
    setTitle("");
  };

  const handleToggleStatus = (id) => {
    const currentTodo = todos.find((todo) => todo.id === id);
    const updatedTodo = {
      id,
      title: currentTodo.title,
      status: currentTodo.setTitle,
    };
    dispatch(updatedTodo(updatedTodo));
  };

  const handleUpdateTitle = (id) => {
    const currentTodo = todos.find((todo) => todo.id === id);
    const newTitle = window.prompt("Cập nhập tiêu đề", currentTodo.title);
    

    if(newTitle === null) {
        return;
    }

    if(title === "") {
        alert("Tiêu đề không được để trống");
        return;
    }

    const updatedTodo ={
        id,
        title: newTitle,
        status: currentTodo.status,
    };
  };

  const handleDelete = (id) => {
    //TODO: thêm confirm trước khi xóa
    dispatch(deleteTodo(id));
  };

  return (
    <>
      <h2>TodoList App</h2>

      <input
        type="text"
        placeholder="Enter title ..."
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />
      <button onClick={handleAdd}>Add</button>

      <ul>
        {todos.length === 0 && <li>Không có công việc nào trong danh sách</li>}
        {todos.length > 0 &&
          todos.map((todo) => (
            <li key={todo.id}>
              <input
                type="checkbox"
                checked={todo.status}
                onChange={() => handleToggleStatus(todo.id)}
              />
              <span className={todo.status ? "active" : ""}>{todo.title}</span>
              <button onClick={() => handleUpdateTitle(todo.id)}>update</button>
              <button onClick={() => handleDelete(todo.id)}>delete</button>
            </li>
          ))}
      </ul>
    </>
  );
}

export default TodoList;
