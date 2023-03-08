import { todolistApi } from "./app/services/todolist.service";
import UserList from "./components/user/UserList";

function App() {
    // const { data, error, isFetching, isLoading } = useGetTodosQuery();
    const { data, error, isFetching, isLoading } =
        todolistApi.endpoints.getTodos.useQuery();
    console.log({ data, error, isFetching, isLoading });
    return (
        <>
            <UserList />
        </>
    );
}

export default App;
