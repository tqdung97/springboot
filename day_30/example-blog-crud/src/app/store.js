import { configureStore } from "@reduxjs/toolkit";
import postApi from "./services/posts.api";
import postsReducer from "./slices/posts.slice";

const store = configureStore({
    reducer: {
        [postApi.reducerPath]: postApi.reducer,
        posts: postsReducer,
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(postApi.middleware),
});

export default store;
