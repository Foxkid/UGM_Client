var framehawk = framehawk || {};
framehawk.views = framehawk.views || {};

framehawk.views.Shared = (function () {
	
	var _HOVERED_LIST_ITEM_CLASS = "hovered";
	
	var m_errorNumberToMessageMap = {
		"1062" : "The name you entered already exists."
	};
	
	
	function _setUpListInteraction ( pageController ) {
	
		$(".innerContent ul.list li").hover (
		   function () {
			   $(this).addClass( _HOVERED_LIST_ITEM_CLASS );
		   },
		   function () {
			   $(this).removeClass( _HOVERED_LIST_ITEM_CLASS );
		   }
		);
		
		
		$("#mainContent ul.list li").hover (
		   function () {
			   $(this).addClass( _HOVERED_LIST_ITEM_CLASS );
		   },
		   function () {
			   $(this).removeClass( _HOVERED_LIST_ITEM_CLASS );
		   }
		);
		
		//pageController.setUpListInteraction ();
		
		/*
		$("#mainContent ul.list li .delete a").click (
		   function () {
			   try {
				   alert ( "delete" );
				   //alert ( "foo " + pageSpecificLogic );
			 //  pageSpecificLogic.deleteRow ($(this).attr("rel"));
			   } catch ( exc ) {
				   alert ( "EXC: " + exc );
			   }
			   //alert ( "click " + $(this).attr("rel") );
		   }
		);
		*/
		
		
		// <div class="delete"><a href="JavaScript:framehawk.views.Index.deleteUser(<%= user.id %>)"></a></div>
		
	}
	
	function _setUpTextFieldFocusHandlers () {
		$(".input_text, .input_textarea").focus(function () {
			$(this).addClass ( "focused" );
		});
		
		$(".input_text, .input_textarea").blur(function () {
			$(this).removeClass ( "focused" );
		});
	}
	
	function _getElementXY(element) {
       var curleft = curtop = 0;
	   if (element.offsetParent) {
			do {
			 curleft += element.offsetLeft;
			 curtop += element.offsetTop;
	       } while (element = element.offsetParent);
	   }
       return {x:curleft,y:curtop};
    };
	
	function _getColorWithoutHashFromInput ( selector ) {
		var colorText = $.trim($(selector).val());
		if ( colorText.length > 0 && colorText.indexOf ( "#" ) == 0 ) {
			colorText = colorText.substr(1);
		}
		return colorText;
	}
	
	/*
		var drawerColor = $.trim($("#drawerColorPicker").val());
		if ( drawerColor.length > 0 && drawerColor.indexOf ( "#" ) == 0 ) {
			drawerColor = drawerColor.substr(1);
		}

	*/
	
	return {
		
		init : function () {
		},
		
		setUpListInteraction : function (pageSpecificLogic) {
			_setUpListInteraction (pageSpecificLogic);
		},
		
		setUpTextFieldFocusHandlers : function () {
			_setUpTextFieldFocusHandlers ();
		},
		
		getElementXY : function (element) {
			return _getElementXY(element);
		},
		
		getMessageForErrorNumber : function ( errorNumber ) {
			return m_errorNumberToMessageMap[errorNumber];
		},
		
		getColorWithoutHashFromInput : function ( selector ) {
			return _getColorWithoutHashFromInput (selector);
		},
		
		trimAndDefault : function ( origString, defaultIfNull ) {
			var str = ( origString ? origString : defaultIfNull );
			return $.trim(str);
		}
		// drawerLogo = ( drawerLogo ? $.trim(drawerLogo) : drawerLogo );
		
	}
	
}) ();

$(document).ready(function(){
	framehawk.views.Shared.init();
});