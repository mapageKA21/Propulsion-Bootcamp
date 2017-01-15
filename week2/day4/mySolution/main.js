$(function() {
  $('.left#horizontal').click(function() {
    var actual = $('.horizontal-scroll').position().left;
    var newP = $('.horizontal-scroll').position().left - 600;
    if (actual < -800) {
      $('.horizontal-scroll').css('transform', 'translateX(' + -1350 + 'px)');
    }
    else {
      $('.horizontal-scroll').css('transform', 'translateX(' + newP + 'px)');
    }
  })

  $('.right#horizontal').click(function() {
    var actual = $('.horizontal-scroll').position().left;
    var newP = $('.horizontal-scroll').position().left + 600;
    if (actual < 450 && actual > -450) {
      $('.horizontal-scroll').css('transform', 'translateX(' + 0 + 'px)');
    }
    else {
      $('.horizontal-scroll').css('transform', 'translateX(' + newP + 'px)');
    }
  })
});
