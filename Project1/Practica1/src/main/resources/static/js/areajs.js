/**
 * 
 */

function areas(){
	$('input[name=areas]').click(function(){
		$('input[name=areas]').removeAttr('checked');
		$(this).attr('checked', true);
	});	
}