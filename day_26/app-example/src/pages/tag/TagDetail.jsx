import React from "react";
import { Helmet } from "react-helmet";
import { Link, useParams } from "react-router-dom";
import { useGetBlogsOfCategoryQuery } from "../../app/services/category.api";
import { formatDate } from "../../utils/functionUtils";

function TagDetail() {
    const { tagName } = useParams();
    const { data: blogs, isLoading } = useGetBlogsOfCategoryQuery(tagName);

    if (isLoading) {
        return <h2>Loading ...</h2>;
    }

    return (
        <>
            <Helmet>
                <title>Danh mục : {tagName}</title>
            </Helmet>
            <main className="main">
                <header className="entry-header">
                    <h1 style={{ marginBottom: 16 }}>Tag : {tagName}</h1>
                </header>
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

export default TagDetail;
