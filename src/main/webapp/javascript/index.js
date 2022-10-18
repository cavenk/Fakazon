const toastLiveExample = document.getElementById('liveToast')
const toastText = document.getElementById("toastText")

if (toastText.innerText !== "") {
    const toast = new bootstrap.Toast(toastLiveExample)
    toast.show()
}