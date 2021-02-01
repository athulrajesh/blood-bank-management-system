$("#register").on("click", function (event) {
  // console.log("clicked submit");
  // var obj=$('form').serialize();

  // console.log(obj);
  var username = $("#username").val();
  var password = $("#password").val();
  var name = $("#name").val();
  var bg = $("#bg").val();
  var age = $("#age").val() === " " ? 0 : $("#age").val();

  var weight = $("#weight").val() === "" ? 0 : $("#weight").val();

  var location = $("#location").val();
  var sex = $("#sex").val();
  var status = $("#status").val();
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
    url: "./savereg",
    type: "POST",
    data: obj,

    success: function (data) {
      if (data == "success") {
        toastr.success("created successfully");

        setTimeout(function () {
          window.location.href = "../donor/";
        }, 3000);
      } else {
        toastr.error("All fields are required");
      }
    },
  });
});

$("#age").on("input", function () {
  if (isNaN(parseInt($("#age").val()))) {
    $("#register").prop("disabled", true);
    $("#warn-age").text("invalid age");
    $("#register").prop("disabled", true);
  } else {
    $("#warn-age").text("*");
  }
});
$("#weight").on("input", function () {
  if (isNaN(parseFloat($("#weight").val()))) {
    $("#register").prop("disabled", true);
    $("#warn-weight").text("invalid weight");
  } else {
    $("#warn-weight").text("*");
    $("#register").prop("disabled", false);
  }
});

$("form").on("click", function () {
  if ($("username").val() !== "") {
    $.ajax({
      url: "./check",
      type: "POST",
      data: { data: $("#username").val() },

      success: function (data) {
        console.log("hi");
        if (data == "success") {
          $("#warn").text("*");
          $("#register").prop("disabled", false);
        } else {
          $("#warn").text("username already taken");
          $("#register").prop("disabled", true);
        }
      },
    });
  }
});
$("#email").on("input", function () {
  if (
    !/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(
      $("#email").val()
    )
  ) {
    $("#warn-email").text("invalid email");
    $("#register").prop("disabled", true);
  } else {
    $("#warn-email").text("*");
    $("#register").prop("disabled", false);
  }
});
$("#phone").on("input", function () {
  if ($("#phone").val().length != 10) {
    $("#warn-phone").text("invalid phone");
    $("#register").prop("disabled", true);
  } else {
    $("#warn-phone").text("*");
    $("#register").prop("disabled", false);
  }
});
