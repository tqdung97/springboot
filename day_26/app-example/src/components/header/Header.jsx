import React from "react";
import { Link } from "react-router-dom";
import CustomLink from "../custom-link/CustomLink";

function Header() {
    return (
        <header className="header">
            <nav className="nav">
                <div className="logo">
                    <Link to={"/"}>Kong.dev</Link>
                </div>
                <ul id="menu">
                    <li>
                        <CustomLink link={"/search"} label={"Search"} />
                    </li>
                    <li>
                        <CustomLink link={"/tags"} label={"Tags"} />
                    </li>
                </ul>
            </nav>
        </header>
    );
}

export default Header;
