import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

const postApi = createApi({
    reducerPath: "postApi",
    baseQuery: fetchBaseQuery({
        baseUrl: "https://jsonplaceholder.typicode.com"
    }),
    tagTypes: ["Posts"],
    endpoints: (builder) => ({
        getPosts: builder.query({
            query: () => "posts",
            tagTypes: ["Posts"]
        }),
        deletePost: builder.mutation({
            query: (id) => ({
                url: `posts/${id}`,
                method: "DELETE"
            }),
            invalidatesTags: ["Posts"]
        })
    })
})

export const { useGetPostsQuery, useDeletePostMutation } = postApi;
export default postApi;