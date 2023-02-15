import React from "react";
import { Route, Routes } from "react-router-dom";
import Layout from "./components/layout/Layout";
import BlogCreate from "./pages/blog/BlogCreate";
import BlogDetail from "./pages/blog/BlogDetail";
import BlogList from "./pages/blog/BlogList";
import OwnBlog from "./pages/blog/OwnBlog";
import CategoryList from "./pages/category/CategoryList";

function App() {
    return (
        <Routes>
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
        </Routes>
    );
}

export default App;