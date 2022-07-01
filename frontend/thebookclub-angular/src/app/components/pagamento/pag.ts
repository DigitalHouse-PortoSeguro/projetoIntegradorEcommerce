$(".cc-num").keyup(function() {
  if (this.value.length == this.maxLength) {
      var $next = $(this).next('.cc-num');
      if ($next.length)
          $(this).next('.cc-num').focus();
      else
          $(this).blur();
  }
});
$('.cc-num').on("focusin", function() {
  $('.cc-num').attr('type', 'password')
  $(this).attr('type', 'text');
  $('.card-number').addClass('focused');
});
$('.cc-num').on("focusout", function() {
  $('.card-number').removeClass('focused');
});
$('.dropdown').click(function() {
  $(this).next('ul').stop().slideToggle();
  $(this).toggleClass('selected');
});
$('.card-number').on('keydown', '.cc-num', function(e) {
  -1 !== $.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) || /65|67|86|88/.test(e.keyCode) && (!0 === e.ctrlKey || !0 === e.metaKey) || 35 <= e.keyCode && 40 >= e.keyCode || (e.shiftKey || 48 > e.keyCode || 57 < e.keyCode) && (96 > e.keyCode || 105 < e.keyCode) && e.preventDefault()
});
$('.submit').hover(function(){
  $('.arrow').addClass('rotate');
}, function(){
  $('.arrow').removeClass('rotate');
});
$('.part.bg').mousemove(function(e){
  var amountMovedX = (e.pageX * -1 / 30);
  var amountMovedY = (e.pageY * -1 / 9);
  $(this).css('background-position', amountMovedX + 'px ' + amountMovedY + 'px');
});