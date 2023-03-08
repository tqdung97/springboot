import { DeleteOutlined, EditOutlined } from "@ant-design/icons";
import {
    Button,
    Col,
    Modal,
    Row,
    Space,
    Table,
    Typography,
    message,
} from "antd";
import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { generatePath, useNavigate } from "react-router-dom";
import {
    useDeletePostMutation,
    useGetPostsQuery,
} from "../../app/services/posts.api";
import { postsSelector, removePostId } from "../../app/slices/posts.slice";
import Error from "../../components/error/Error";
import Loading from "../../components/loading/Loading";

function ListPost() {
    const navigate = useNavigate();
    const { isLoading, error, isError } = useGetPostsQuery();
    const posts = useSelector(postsSelector.selectAll);

    const entities = useSelector(postsSelector.selectEntities);
    const ids = useSelector(postsSelector.selectIds);
    const totals = useSelector(postsSelector.selectTotal);
    const id5 = useSelector((state) => postsSelector.selectById(state, 5));

    const [deletePost] = useDeletePostMutation();
    const dispatch = useDispatch();
    const confirmDeletePost = (id) => {
        const modal = Modal.confirm({
            title: "Xác nhận xóa",
            content: "Bạn có muốn xóa bài viết này không",
            onOk: async () => {
                modal.update({
                    okButtonProps: { loading: true },
                });
                try {
                    await deletePost(id);
                    dispatch(removePostId(id));

                    message.success("Xóa bài viết thành công", 2);
                } catch (error) {
                    message.error(error);
                } finally {
                    modal.update({
                        okButtonProps: { loading: false },
                    });
                }
            },
            okText: "Đồng ý",
            cancelText: "Hủy bỏ",
        });
    };

    if (isLoading) {
        return <Loading />;
    }

    if (isError) {
        return <Error error={error} />;
    }

    const columns = [
        {
            title: "ID",
            key: "id",
            dataIndex: "id",
        },
        {
            title: "Title",
            key: "title",
            dataIndex: "title",
        },
        {
            title: "",
            key: "action",
            dataIndex: "action",
            render: (_, { id }) => {
                return (
                    <Space>
                        <Button
                            type="primary"
                            icon={<EditOutlined />}
                            onClick={() =>
                                navigate(generatePath("/posts/:id", { id }))
                            }
                        />
                        <Button
                            danger
                            icon={<DeleteOutlined />}
                            onClick={() => confirmDeletePost(id)}
                        />
                    </Space>
                );
            },
        },
    ];

    const dataPosts = posts.map((p, index) => {
        return {
            key: index,
            id: p.id,
            title: p.title,
            action: p.id,
        };
    });
    return (
        <>
            <h2 className="text-3xl font-bold text-center italic">
                Danh sách bài viết
            </h2>
            <Row>
                <Col span={16} offset={4}>
                    <Table
                        bordered
                        columns={columns}
                        dataSource={dataPosts}
                        pagination={{
                            showTotal: (total, range) => (
                                <Typography.Text className="italic mb-0">
                                    Hiển thị từ {range[0]} đến {range[1]} trên
                                    tổng số {total}
                                </Typography.Text>
                            ),
                            showSizeChanger: false,
                            defaultPageSize: 10,
                            size: "default",
                            position: ["bottomCenter"],
                        }}
                    />
                </Col>
            </Row>
        </>
    );
}

export default ListPost;
