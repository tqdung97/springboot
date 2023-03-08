const API_URL = "http://localhost:8080/api/v1"

const params = new URLSearchParams(window.location.search);
const userId = params.get("id");
console.log(userId);

if (!userId) {
    window.location.href = "./404.html"
}

// Truy cập
const imageContainerEl = document.querySelector(".image-container");
const btnChoseImage = document.getElementById("btn-chose-image");
const btnDeleteImage = document.getElementById("btn-delete-image");
const avatarPreviewEl = document.getElementById("avatar-preview");
const avatarEl = document.getElementById("avatar");

const modalImageEl = new bootstrap.Modal(document.getElementById('modal-image'), {
    keyboard: false
  })

// Quản lý ảnh
let images = [];

// Lấy danh sách image
const getImages = async () => {
    try {
        let res = await axios.get(`${API_URL}/users/${userId}/files`);
        console.log(res);

        images = res.data;
        renderPaginationAndRenderImages(images);
    } catch (error) {
        console.log(error)
    }
}

// Hiển thị image trên UI
const renderImages = arr => {
    imageContainerEl.innerHTML = "";
    let html = "";
    arr.forEach(i => {
        html += `
            <div class="image-item" onclick="choseImage(this)">
                <img src="http://localhost:8080${i}" alt="ảnh" data-url=${i}>
            </div>
        `
    });
    imageContainerEl.innerHTML = html;
    btnChoseImage.disabled = true;
    btnDeleteImage.disabled = true;
}

// Phân trang
const renderPaginationAndRenderImages = arr => {
    $('.pagination-container').pagination({
        dataSource: arr,
        pageSize: 8,
        callback: function (data, pagination) {
            console.log(data);
            console.log(pagination);
            renderImages(data);
        }
    })
}

// Chọn 1 hình ảnh
const choseImage = (imageEl) => {
    // xóa ảnh được active trước đó nếu có
    const imageActiveEl = document.querySelector(".image-active");
    if (imageActiveEl) {
        imageActiveEl.classList.remove("image-active");
    }

    // active được hình ảnh
    imageEl.classList.add("image-active")

    // active nút chức năng
    btnChoseImage.disabled = false;
    btnDeleteImage.disabled = false;
}

// Xóa ảnh
btnDeleteImage.addEventListener("click", async () => {
    try {
        const imageActiveEl = document.querySelector(".image-active img");
        if (!imageActiveEl) return;

        const url = imageActiveEl.src;
        console.log(url)

        // Xóa trên server
        await axios.delete(url);

        // Xóa trên client
        // http://localhost:8080/api/v1/users/1/files/1671191936
        // /api/v1/users/1/files/1671191936
        // /api/v1/users/1/files/1671191937
        // /api/v1/users/1/files/1671191938
        images = images.filter(i => !url.includes(i))

        // Render lại image
        renderPaginationAndRenderImages(images);
    } catch (error) {
        console.log(error)
    }
})

// Cập nhật avatar
btnChoseImage.addEventListener("click", async () => {
    try {
        const imageActiveEl = document.querySelector(".image-active img");
        if (!imageActiveEl) return;

        // /api/v1/users/1/files/1671191936
        const url = imageActiveEl.dataset.url;
        console.log(url)

        // Gọi API
        await axios.put(`${API_URL}/users/${userId}/update-avatar`, { avatar: url })

        // Cập nhật avatar trên UI
        avatarPreviewEl.src = `http://localhost:8080${url}`;

        // Đóng modal
        modalImageEl.hide();
    } catch (error) {

    }
})

// Upload ảnh
avatarEl.addEventListener("change", async (e) => {
    try {
        // Lấy ra file upload
        const file = e.target.files[0];
        console.log(file);

        // Tạo đối tượng form data
        const formData = new FormData();
        formData.append("file", file);

        // Gọi API
        const res = await axios.post(`${API_URL}/users/${userId}/files`, formData);

        // Cập nhật UI
        images.unshift(res.data);
        renderPaginationAndRenderImages(images);

    } catch (error) {
        console.log(error)
    }
})



getImages();