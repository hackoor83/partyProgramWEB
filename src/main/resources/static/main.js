$(document).ready(function() {
    $('#guestsTable').DataTable();
    $("#addGuestBtn").click(addPerson);
    $("#getGuestsListBtn").click(getList);
});


function getList() {
    $.get("api/party", function(persons) {
        $("#tableBody").empty();
        for (let i = 0; i < persons.length; i++) {
            const person = persons[i];
            $("#tableBody").append(
                '<tr id="row' + person.id + '"><td>' + person.id + '</td>' +
                '<td>' + person.name + '</td>' +
                '<td>' + person.age + '</td>' +
                '<td>' + person.favouriteDrink + '</td>' +
                '<td>' + person.isAttendingParty + '</td>' +
                '<td><button onclick="deletePerson(' + person.id + ')">Delete</button></td>'
            );
        }
    });
}

function deletePerson(id) {
    $.ajax({
        url: "api/party/" + id,
        type: "DELETE",
        success: function() {
            alert("Guest removed from list");
            $("#row" + id).remove();
        },
        error: function() {
            alert("ERROR: Not removed");
        }
    });
}

function addPerson() {
    let newPerson = {
        name: $("#guestNameInput").val(),
        age: $("#guestAgeInput").val(),
        favouriteDrink: $("#guestFavouriteDrinkInput").val(),
        isAttendingParty: $("#guestPresenceInput").val()
    }

    let jsonObject = JSON.stringify(newPerson);

    $.ajax({
        url: "api/party",
        type: "POST",
        contentType: "application/json",
        data: jsonObject,
        success: function() {
            alert("Post succesfull");
            $("#guestNameInput").val(''),
                $("#guestAgeInput").val(''),
                $("#guestFavouriteDrinkInput").val(''),
                $("#guestPresenceInput").val('')
        },
        error: function() {
            alert("Not succesfull!!");
        }
    });
}