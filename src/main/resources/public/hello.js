$(document).ready(function() {
    $("#submit").click(function (event) {
        event.preventDefault();

        inputs = $("input");
        data = {
            "name": inputs[0].value,
            "phoneNumber": inputs[1].value,
            "address": inputs[2].value
        };

        created_buddy = null;

        $.ajax({
            url: "/buddies",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (result, status, xhr) {
                href = result._links.self.href;
                id = Number(href.match(/\d+$/)[0]);
                created_buddy = result;
                $.ajax({
                    url: window.location.href + "/addBuddy?buddyId=" + id,
                    method: "PATCH",
                    contentType: "application/json",
                    success: function (result, status, xhr) {
                        $('table').append(buildRow(created_buddy))
                    },
                    error: function (xhr, status, error) {
                        alert("Adding a buddy failed!");
                    }
                });

            },
            error: function (xhr, status, error) {
                alert("Buddy creation failed!");
            }
        });
    });
});

var buildRow = function (results) {
    tr = '<tr>';
    tr += '<td>' + results.name + '</td>';
    tr += '<td>' + results.phoneNumber + '</td>';
    tr += '<td>' + results.address + '</td>';
    tr += '</tr>';
    return tr;
};
