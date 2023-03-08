import { Button, Result } from "antd";
import React from "react";
import { Link } from "react-router-dom";

function Error(props) {
    console.log(props);
    <Result
        status="error"
        title="Something Wrong!"
        subTitle="Co gi do sai sai"
        extra={[
            <Button type="primary" key="console">
                <Link to={"/"}>Go to home</Link>
            </Button>,
        ]}
    />;
}

export default Error;
