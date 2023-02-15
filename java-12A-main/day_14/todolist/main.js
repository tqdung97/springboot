const API_URL = "http://localhost:8080/api/v1"

const todoListEl = document.getElementById("todolist");
let todos = [];

// Lấy ds todo và hiển thị
const getTodos = async () => {
    try {
        // Gọi API
        let res = await axios.get(`${API_URL}/todos`);
        console.log(res);
        todos = res.data; // Lưu lại dữ liệu trả về từ server;

        // Hiển thị lên trên giao diện
        renderTodos(todos);
    } catch (error) {
        console.log(error)
    }
}

const renderTodos = arr => {
    todoListEl.innerHTML = "";
    if(arr.length === 0) {
        todoListEl.innerHTML = '<li>Không có công việc nào trong danh sách</li>';
        return;
    }

    let html = "";
    arr.forEach(t => {
        html += `
            <li>
                <input type="checkbox" ${t.status ? "checked" : ""}>
                <span class=${t.status ? "todo-active" : ""}>${t.title}</span>
                <button onclick="updateTodo(${t.id})">Update</button>
                <button onclick="deleteTodo(${t.id})">Delete</button>
            </li>
        `
    });

    todoListEl.innerHTML = html;
}

const deleteTodo = id => {
    console.log(id);
}

const updateTodo = id => {
    console.log(id);
}

// Vừa vào trang sẽ gọi
getTodos();