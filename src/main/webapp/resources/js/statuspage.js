$("#update").on("click", function (event) {
  // console.log("clicked submit");
  // var obj=$('form').serialize();

  // console.log(obj);
  var aPos = $("#aPos").val() == "" ? 0 : $("#aPos").val();
  var aNeg = $("#aNeg").val() == "" ? 0 : $("#aNeg").val();
  var bPos = $("#bPos").val() == "" ? 0 : $("#bPos").val();
  var bNeg = $("#bNeg").val() == "" ? 0 : $("#bNeg").val();

  var oPos = $("#oPos").val() == "" ? 0 : $("#oPos").val();
  var oNeg = $("#oNeg").val() == "" ? 0 : $("#oNeg").val();
  var abPos = $("#abPos").val() == "" ? 0 : $("#abPos").val();
  var abNeg = $("#abNeg").val() == "" ? 0 : $("#abNeg").val();
  var obj = {
    aPos: aPos,
    aNeg: aNeg,
    bPos: bPos,
    bNeg: bNeg,
    oPos: oPos,
    oNeg: oNeg,

    abPos: abPos,
    abNeg: abNeg,
  };
  console.log(obj);

  $.ajax({
    url: "./save",
    type: "POST",
    data: obj,

    success: function (data) {
      if (data == "success") {
        toastr.success("updated successfully");
      } else {
        toastr.error("error");
      }
    },
  });
});

$("#aPos").on("input", function () {
  console.log("a");
  if (isNaN(parseFloat($("#aPos").val()))) {
    $("#update").prop("disabled", true);
    $("#warn-ap").text("invalid");
  } else {
    $("#warn-ap").text("*");
    $("#update").prop("disabled", false);
  }
});

$("#aNeg").on("input", function () {
  if (isNaN(parseFloat($("#aNeg").val()))) {
    $("#update").prop("disabled", true);
    $("#warn-a-").text("invalid");
  } else {
    $("#warn-a-").text("*");
    $("#update").prop("disabled", false);
  }
});

$("#bPos").on("input", function () {
  if (isNaN(parseFloat($("#bPos").val()))) {
    $("#update").prop("disabled", true);
    $("#warn-bp").text("invalid");
  } else {
    $("#warn-bp").text("*");
    $("#update").prop("disabled", false);
  }
});

$("#bNeg").on("input", function () {
  if (isNaN(parseFloat($("#bNeg").val()))) {
    $("#update").prop("disabled", true);
    $("#warn-b-").text("invalid");
  } else {
    $("#warn-b-").text("*");
    $("#update").prop("disabled", false);
  }
});

$("#oPos").on("input", function () {
  if (isNaN(parseFloat($("#oPos").val()))) {
    $("#update").prop("disabled", true);
    $("#warn-op").text("invalid");
  } else {
    $("#warn-op").text("*");
    $("#update").prop("disabled", false);
  }
});

$("#oNeg").on("input", function () {
  if (isNaN(parseFloat($("#oNeg").val()))) {
    $("#update").prop("disabled", true);
    $("#warn-o-").text("invalid");
  } else {
    $("#warn-o-").text("*");
    $("#update").prop("disabled", false);
  }
});

$("#abPos").on("input", function () {
  if (isNaN(parseFloat($("#abPos").val()))) {
    $("#update").prop("disabled", true);
    $("#warn-abp").text("invalid ");
  } else {
    $("#warn-abp").text("*");
    $("#update").prop("disabled", false);
  }
});

$("#abNeg").on("input", function () {
  if (isNaN(parseFloat($("#abNeg").val()))) {
    $("#update").prop("disabled", true);
    $("#warn-ab-").text("invalid");
  } else {
    $("#warn-ab-").text("*");
    $("#update").prop("disabled", false);
  }
});
