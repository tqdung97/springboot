import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

const END_POINT = "http://localhost:8080/api"

export const categoryApi = createApi({
    reducerPath: 'categoryApi',
    baseQuery: fetchBaseQuery({ baseUrl: END_POINT }),
    endpoints: (builder) => ({
        getCategoies: builder.query({
            query: () => `categories`,
        }),
        getBlogsOfCategory: builder.query({
            query: (name) => `categories/${name}`,
        }),
    }),
})

export const { useGetCategoiesQuery, useGetBlogsOfCategoryQuery }
    = categoryApi;