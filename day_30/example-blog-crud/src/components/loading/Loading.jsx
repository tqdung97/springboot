import React from "react";
import styles from "./Loading.module.css";
import { Spin } from "antd";

function Loading() {
    return (
        <div id="loading" className={styles.loading}>
            <Spin />
        </div>
    );
}

export default Loading;
