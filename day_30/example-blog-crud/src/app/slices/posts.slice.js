import { createEntityAdapter, createSlice } from "@reduxjs/toolkit";
import postApi from "../services/posts.api";

const postAdapter = createEntityAdapter({
    selectId: (post) => post.id,
});

const postsSlice = createSlice({
    name: "posts",
    initialState: postAdapter.getInitialState(),
    reducers: {
        removePostId: postAdapter.removeOne
    },
    extraReducers: (builder) => {
        builder.addMatcher(
            postApi.endpoints.getPosts.matchFulfilled,
            postAdapter.setAll
        );
    },
});

export const { removePostId } = postsSlice.actions;

export const {
    selectById: selectPostById,
    selectIds: selectPostIds,
    selectEntities: selectPostEntities,
    selectAll: selectAllPosts,
    selectTotal: selectTotalPosts,
} = postAdapter.getSelectors((state) => state.posts);

export const postsSelector = postAdapter.getSelectors(state => state.posts)

export default postsSlice.reducer;
