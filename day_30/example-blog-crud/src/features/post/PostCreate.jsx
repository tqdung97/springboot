import React from "react";
import Error from "../../components/error/Error";

function PostCreate() {
    const error = {
        data: "Khong ket noi duoc voi DB",
    };
    return (
        <>
            <Error />
        </>
    );
}

export default PostCreate;
