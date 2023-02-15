import React from "react";
import { Link } from "react-router-dom";

function TagList() {
    return (
        <main className="main">
            <header className="page-header">
                <h1>Tags</h1>
            </header>
            <ul className="terms-tags">
                <li>
                    <Link to={"/tags/java"}>
                        Action{" "}
                        <sup>
                            <strong>
                                <sup>5</sup>
                            </strong>
                        </sup>
                    </Link>
                </li>
            </ul>
        </main>
    );
}

export default TagList;