$("#update").on("click", function (event) {
  // console.log("clicked submit");
  // var obj=$('form').serialize();

  // console.log(obj);
  var username = $("#username").val();
  var password = $("#password").val();
  var name = $("#name").val();
  var bg = $("#bg").val();
  var age = $("#age").val() === "" ? 0 : $("#age").val();

  var weight = $("#weight").val() === "" ? 0 : $("#weight").val();
  var location = $("#location").val();
  var sex = $("#sex").val();
  if ($("#status").val() == "active") {
    var status = 1;
  } else if ($("#status").val() == "in active") {
    var status = 0;
  } else {
    var status = $("#status").val();
  }
  var email = $("#email").val();
  var phone = $("#phone").val();

  var obj = {
    username: username,
    bg: bg,
    password: password,
    age: age,
    weight: weight,
    location: location,
    sex: sex,
    status: status,
    email: email,
    phone: phone,
    name: name,
  };
  console.log(obj);

  $.ajax({
    url: "./update",
    type: "POST",
    data: obj,

    success: function (data) {
      if (data == "success") {
        toastr.success("updated successfully");
      } else {
        toastr.error("All fields required");
      }
    },
  });
});
$("#age").on("input", function () {
  if (isNaN(parseInt($("#age").val()))) {
    $("#update").prop("disabled", true);
    $("#warn-age").text("invalid age");
  } else {
    $("#warn-age").text("*");
    $("#update").prop("disabled", false);
  }
});
$("#weight").on("input", function () {
  if (isNaN(parseInt($("#weight").val()))) {
    $("#update").prop("disabled", true);
    $("#warn-weight").text("invalid weight");
  } else {
    $("#warn-weight").text("*");
    $("#update").prop("disabled", false);
  }
});

$("#username").on("input", function () {
  $.ajax({
    url: "./check",
    type: "POST",
    data: { data: $("#username").val() },

    success: function (data) {
      if (data == "success") {
        $("#warn").text("*");
        $("#update").prop("disabled", false);
      } else {
        $("#warn").text("username already taken");
        $("#update").prop("disabled", true);
      }
    },
  });
});
$("#email").on("input", function () {
  if (
    !/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(
      $("#email").val()
    )
  ) {
    $("#warn-email").text("invalid email");
    $("#update").prop("disabled", true);
  } else {
    $("#warn-email").text("*");
    $("#update").prop("disabled", false);
  }
});
$("#phone").on("input", function () {
  if ($("#phone").val().length != 10) {
    $("#warn-phone").text("invalid phone");
    $("#update").prop("disabled", true);
  } else {
    $("#warn-phone").text("*");
    $("#update").prop("disabled", false);
  }
});
function changeSelect() {
  document.getElementById("statusdiv").innerHTML =
    "<label>STATUS<span>*</span></label><select id='status' name='status'><option value='1'>active</option><option value='0'>in active</option></select>";
}
