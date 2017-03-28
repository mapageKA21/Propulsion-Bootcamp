$(function() {
  $('#sum').on('click', function() {
    var num1 = parseInt($('#num1').val());
    var num2 = parseInt($('#num2').val());
    $('.result').html(num1 + num2);
  });
})
