$( document ).ready(function(){
	
	$(window).scroll(function(event){
		var scroll = $(window).scrollTop();
		if(scroll == 0){
			$('.header').removeClass("condensed");
			$('#header_subtitle').show();
		}else{
			$('.header').addClass("condensed");	
			$('#header_subtitle').hide();
		}
	})
	
});