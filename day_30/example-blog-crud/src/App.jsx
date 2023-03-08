import React from "react";
import { Route, Routes } from "react-router-dom";
import Loading from "./components/loading/Loading";
import ListPost from "./features/post/ListPost";
import PostCreate from "./features/post/PostCreate";
import PostDetail from "./features/post/PostDetail";

function App() {
    return (
        <Routes>
            <Route path="/posts">
                <Route index element={<ListPost />} />
                <Route path="create" element={<PostCreate />} />
                <Route path=":postId" element={<PostDetail />} />
            </Route>
            <Route path="/loading" element={<Loading />} />
        </Routes>
    );
}

export default App;
