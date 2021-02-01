$("#amount").on("input", function () {
  if (isNaN(parseFloat($("#amount").val()))) {
    $("#warn").text("invalid amount");
    $(".btn btn-black").prop("disabled", true);
  } else {
    $("#warn").text("");
    $(".btn-black").prop("disabled", false);
  }
});
