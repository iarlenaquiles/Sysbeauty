$(document).ready(function(){
    //sabendo o navegador do usuario
    var sUsrAg = navigator.userAgent;
    console.log(sUsrAg);
    if ((sUsrAg.indexOf("MSIE") > -1)||sUsrAg.indexOf("Edge")>-1) {
        $("#nav-mobile").find("hr").css("margin-left","100%","border","solid","1px","white");
    }

    

    // menu mobile
    $(".button-collapse").sideNav();
    
    // modal login
    $('.modal').modal();
    //tabs cadastro
    $('ul.tabs').tabs({swipeable:true,responsiveThreshold:900});
    //trocar cor das das cadastro
    $('li.tab').each(function(){
		$(this).click(function(){

            $('li.tab').find('a').addClass("inativo").removeClass("ativo");

            $(this).find('a').removeClass("inativo").addClass("ativo");
        });
    });
    //trocar abas modal login
    $('#modalLogin .botoes-modal-login').each(function(){
		$(this).click(function(){

            $('#modalLogin .botoes-modal-login').find('a').addClass("inativo-login").removeClass("ativo-login");

            $(this).find('a').removeClass("inativo-login").addClass("ativo-login");
        });
    });
     $('select').material_select();

     $('.carousel').carousel();

     //Grafico js
    
        
    
    $('.modal-escuro').modal({
        opacity: .9, // Opacity of modal background
        }
    );
});

function fecharModal(){
     $('#modal-fale-conosco').modal('close');
}

