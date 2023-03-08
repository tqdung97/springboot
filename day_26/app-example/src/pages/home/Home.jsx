import React from "react";
import { Helmet } from "react-helmet";
import { Link } from "react-router-dom";
import { useGetBlogsQuery } from "../../app/services/blog.api";
import { useGetCategoiesQuery } from "../../app/services/category.api";
import { formatDate } from "../../utils/functionUtils";

function Home() {
    const { data: blogs, isLoading: isLoadingBlog } = useGetBlogsQuery();
    const { data: categoies, isLoading: isLoadingCategory } =
        useGetCategoiesQuery();

    if (isLoadingBlog || isLoadingCategory) {
        return <h2>Loading ...</h2>;
    }
    return (
        <>
            <Helmet>
                <title>Trang chủ</title>
            </Helmet>
            <main className="main">
                <header className="entry-header">
                    <h1>
                        <span
                            style={{
                                display: "inline-block",
                                transform: "rotateY(180deg)",
                            }}
                        >
                            🐈
                        </span>{" "}
                        Blog app <span>🐈</span>
                    </h1>
                </header>
                <ul className="terms-tags top-tags">
                    {categoies.map((c) => (
                        <li key={c.id}>
                            <Link to={`/tags/${c.name}`}>
                                {c.name}
                                <sup>
                                    <strong>
                                        <sup>{c.used}</sup>
                                    </strong>
                                </sup>
                            </Link>
                        </li>
                    ))}
                </ul>
                {blogs.map((blog) => (
                    <article key={blog.id} className="post-entry">
                        <Link to={`/blogs/${blog.id}/${blog.slug}`}>
                            <header className="entry-header">
                                <h2>{blog.title}</h2>
                            </header>
                            <div className="entry-content">
                                <p>{blog.description}</p>
                            </div>
                            <footer className="entry-footer">
                                <span>{formatDate(blog.publishedAt)}</span>
                            </footer>
                        </Link>
                    </article>
                ))}
            </main>
        </>
    );
}

export default Home;
