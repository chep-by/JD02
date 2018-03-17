function inputCheck() {
    return $('input[name=vehicle]:checked').val();
}



function showDiv() {
    var car = document.getElementById("car");
    var moto = document.getElementById("moto");
    if (inputCheck()=="car"){
        car.style.display = "block";
        moto.style.display = "none";
        clearFormWithIdAddCar();
    } else {
        car.style.display = "none";
        moto.style.display = "block";
        clearFormWithIdAddMoto();
    }

}


var i = 1;

function addFieldForPhoto() {
    var inputPhoto = document.createElement("input");
    inputPhoto.className = "form-control";
    inputPhoto.type = "url";
    inputPhoto.name = "photoUrl";
    var inputRadioMain = document.createElement("input");
    inputRadioMain.type = "radio";
    inputRadioMain.name = "main";
    inputRadioMain.value = parseInt($('#photo_div div input').last().val())+1;
    var div = document.createElement("div");
    div.className = "col-xs-2 text-center";
    $('.classjs').append(div);
    div.appendChild(inputPhoto);
    div.appendChild(inputRadioMain);
}

function removeFieldForPhoto() {
    $('.classjs div').last().remove();
}

// function addFields() {
//     var container = document.getElementById("photo-div");
//     container.appendChild(document.createTextNode("Member " + (i + 1)));
//     var div = document.createElement("div");
//     div.className = "col-xs-2 text-center";
//     var inputPhoto = document.createElement("input");
//     inputPhoto.className = "form-control";
//     inputPhoto.type = "text";
//     var inputRadioMain = document.createElement("input");
//     inputRadioMain.type = "radio";
//     inputRadioMain.name = "main";
//     div.appendChild(inputPhoto);
//     div.appendChild(inputRadioMain);
// }

// function delFields() {
//     var container = document.getElementById("photo-div");
//     container.removeChild(container.lastChild);
// }

// function sendFields() {
//     var a = [];
//     $.each($("#container input"), function (index, value) {
//         a.push(value.value);
//     });
//     var data = JSON.stringify(a);
//     alert(data);
// }
// function sendFields() {
//     var a = [];
//     $.each($("#photo_div "), function (index, value) {
//         a.push(value.value);
//     });
//     var data = JSON.stringify(a);
//     alert(data);
// }

function clearFormWithIdAddCar() {
    $(':input', '#addcar')
        .not(':button, :submit, :reset, :hidden, :radio')
        .val('')
        .removeAttr('checked')
        .removeAttr('selected');
}

function clearFormWithIdAddMoto() {
    $(':input', '#addmoto')
        .not(':button, :submit, :reset, :hidden, :radio')
        .val('')
        .removeAttr('checked')
        .removeAttr('selected');
}
