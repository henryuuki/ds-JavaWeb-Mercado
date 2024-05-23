function displaySelectedImage(event, imageId) {
    const selectedImage = document.getElementById(imageId);
    const file = event.target.files[0];
    const reader = new FileReader();

    reader.onload = function () {
        selectedImage.src = reader.result;
    }

    if (file) {
        reader.readAsDataURL(file);
    }
}