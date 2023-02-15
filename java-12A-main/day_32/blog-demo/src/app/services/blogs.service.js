const blogApi = createApi({
    reducerPath: "blogAPi",
    baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8081/api/admin" }),
    endpoints: (builder) => ({
        getBlogs: builder.query({
            query: () => "blogs",
            providesTags: ["Blogs"],
        }),
        getBlogById: builder.query({
            query: (id) => `blogs/${id}`,
            
        }),
        getOwnBlog:builder.query({
            query: ()=> `blogs/own-blog`
        }),
        createBlog: builder.mutation({
            query: (data) => ({
                url:"blogs",
                method: "POST",
                body: data,
            }),
            invalidatesTags: ["Blogs"],
        }),
        updateBlog: builder.mutation({
			query: ({ id, ...body }) => ({
				url: `blogs/${id}`,
				method: "PUT",
				body,
			}),
			invalidatesTags: ["Post"],
		}),
		deleteBlog: builder.mutation({
			query: (id) => ({
				url: `blogs/${id}`,
				method: "DELETE",
			}),
		}),
        
    }),
})

export const {
    useGetBlogsQuery,
    useGetBlogByIdQuery,
    useGetOwnBlogsQuery,
    useCreateBlogMutation,
    useUpdateBlogMutation,
    useDeleteBlogMutation,

} = blogApi;