$(document).ready(function() {
  $('code, pre').addClass('prettyprint');
  prettyPrint();

  $("input,select,textarea").not("[type=submit]").validate();

});
