// function notFound() {
//     var container = document.getElementById("div-table");
//     var pNotFound = document.createElement("p");
//     pNotFound.innerText = "Not Found";
//
//     container.appendChild(document.cre("Member " + (i + 1)));
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

// function loadCarsFromServer() {
//     $.ajax("/selectcarsv2", {
//         method: "GET",
//         contentType: "application/json"
//     }).done(function (carList) {
//
//     })
//
// }

function getCarListRequest() {
    var carDtoObject = {
        manufacture: $('#manufacture').val(),
        model: $('#model').val(),
        vehicleCategoryName: $('#category').val(),
        yearMin: $('#yearMin').val(),
        yearMax: $('#yearMax').val(),
        perPage: $('#pagination').val(),
        page: 1
    };
    $.ajax('/getcarlist', {
        method: 'GET',
        contentType: 'application/json',
        data: carDtoObject
    }).done(function (listCars) {
        console.log(listCars)
    })

}