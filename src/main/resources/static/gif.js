
function getCodeFromSelect(selectEl) {
    return (selectEl) ? selectEl.options[selectEl.selectedIndex].value : null;
}

function getGif(){
    let code = getCodeFromSelect(document.querySelector('#codes'));
    $(document).ready(function () {
        $.ajax({
            url: "/gif/" + code,
            method: "GET",
            success: function (data) {
                $('#showGif').attr('src', data);
            }
        });
    });
}

$(document).ready(function () {
    $.ajax({
        url: "/codes",
        method: "GET",
        success: function (data) {
            for (let i = 0; i < data.length; i++) {
                $('#codes').append($('<option>').text(data[i]));
            }
        }
    });
});