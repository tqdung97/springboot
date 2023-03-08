import React from "react";
import { NavLink } from "react-router-dom";

function CustomLink({ link, label }) {
    return (
        <NavLink to={link}>
            {({ isActive }) => (
                <span className={isActive ? "active" : undefined}>{label}</span>
            )}
        </NavLink>
    );
}

export default CustomLink;
