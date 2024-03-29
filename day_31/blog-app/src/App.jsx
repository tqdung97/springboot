import React from "react";
import { Route, Routes } from "react-router-dom";
import Layout from "./components/layout/Layout";
import Private from "./components/private/Private";
import BlogCreate from "./pages/blog/BlogCreate";
import BlogDetail from "./pages/blog/BlogDetail";
import OwnBlog from "./pages/blog/OwnBlog";
import CategoryList from "./pages/category/CategoryList";
import Login from "./pages/login/Login";
import BlogList from "./pages/blog/blog-list/BlogList";

function App() {
    return (
        <Routes>
            <Route element={<Private />}>
                <Route path="/admin" element={<Layout />}>
                    <Route path="blogs">
                        <Route index element={<BlogList />} />
                        <Route path=":blogId" element={<BlogDetail />} />
                        <Route path="own-blogs" element={<OwnBlog />} />
                        <Route path="create" element={<BlogCreate />} />
                    </Route>
                    <Route path="categories">
                        <Route index element={<CategoryList />} />
                    </Route>
                </Route>
            </Route>
            <Route path="/admin/login" element={<Login />} />
        </Routes>
    );
}

export default App;
