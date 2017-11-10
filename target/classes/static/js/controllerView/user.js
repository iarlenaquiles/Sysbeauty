
$.getScript('js/controllerView/crud', function(e)
{
    console.log(e)
});
function teste() {
  console.log(this.usuario)
}

$(function() {
  $('contactform').submit(function(e) {
    e.preventDefault();

    console.log(this.usuario)
  });
});
