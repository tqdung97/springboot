import React, { useState } from "react";
import { Helmet } from "react-helmet";
import { Link } from "react-router-dom";
import { useLazySearchBlogQuery } from "../../app/services/blog.api";

function Search() {
    const [searchBlog] = useLazySearchBlogQuery();
    const [term, setTerm] = useState("");
    const [blogs, setBlogs] = useState([]);

    const handleSearch = async (e) => {
        if (e.key === "Enter") {
            if (term.trim() === "") {
                alert("Nội dung không được để trống");
            }
            try {
                let { data } = await searchBlog(term);
                setBlogs(data);
            } catch (error) {
                console.log(error);
            }
        }
    };

    return (
        <>
            <Helmet>
                <title>Tìm kiếm</title>
            </Helmet>
            <main className="main">
                <header className="page-header">
                    <h1>Search</h1>
                    <div className="post-description">Tìm kiếm bài viết</div>
                    <div className="post-meta"></div>
                </header>
                <div id="searchbox">
                    <input
                        id="searchInput"
                        placeholder="Tìm kiếm bài viết"
                        autoComplete="off"
                        value={term}
                        onChange={(e) => setTerm(e.target.value)}
                        onKeyDown={(e) => handleSearch(e)}
                    />
                    <ul id="searchResults">
                        {blogs.map((blog) => (
                            <li class="post-entry">
                                <header class="entry-header">
                                    {blog.title}
                                </header>
                                <Link
                                    to={`/blogs/${blog.id}/${blog.slug}`}
                                    aria-label={blog.title}
                                ></Link>
                            </li>
                        ))}
                    </ul>
                </div>
            </main>
        </>
    );
}

export default Search;
