$(function(){

	//CONSULTA 1
	//MUESTRA TODAS LAS IMAGENES PUBLICAS DEL USUARIO
	$("#query1btn").click(function(){
		//Elimina las busqueda realizadas anteriormente. Con JQuery borra los elementos de la pagina
        $(".pagination li").remove();
		$(".pagination a").remove();
		$(".pagination img").remove();

		$(".big-image li").remove();
		$(".big-image a").remove();
		$(".big-image img").remove();	

		$(".noResult h2").remove();		
		
        //Realiza la busqueda en flickr		
		$.getJSON('https://api.flickr.com/services/rest/?&method=flickr.people.getPublicPhotos&api_key=' 
		+ api_key + '&user_id=' + user_id + '&format=json&nojsoncallback=1',
		function(info){
			var i;
			var numPhotos=info.photos.photo.length;//Para controlar cuantas fotos hay
			//Bucle for para mostrar todos los resultados
			for (i=0;i<info.photos.photo.length;i++) {
				var item = info.photos.photo[i];
				//Imagen tamaño pequeño:
				var url = 'https://farm'+item.farm+".staticflickr.com/"+item.server+'/'+item.id+'_'+item.secret+'_s.jpg';
				//Imagen tamaño grande:
				var url_big = 'https://farm'+item.farm+".staticflickr.com/"+item.server+'/'+item.id+'_'+item.secret+'_b.jpg';
				console.debug(url);
				
				//Añade la imagen pequeña a la pagina web, crea un nuevo item en la lista, con el link para cuando pulses ir a la funcion "abrir_dialog" 
				//de js para hacer mas grande la imagen				
				var imgList = "<li><a onclick="+"abrir_dialog("+i+","+numPhotos+")"+"> <img class='smallImg' src="+url+"></a></img></li>";
				$(".pagination").append(imgList);
				
				//Añade la imagen grande al listado oculto, para cuando se pulse a la función "abrir_dialog" se muestre por numero de item
				var imgList2 = "<li><img id=img"+i+" "+"class='bigImg' src="+url_big+"></img></li>";
				$(".big-image").append(imgList2);
			}
			//Si no se encuentran resultados muestra un mensaje.
			if (i==0){
				$(".noResult").append("<h2> No se han encontrado imagenes en esa busqueda. </h2>");
			}			
			
		});
		
	});
	
	//CONSULTA 2
	//MUESTRA LAS IMAGENES CON FECHA MINIMA DE CAPTURA
	$("#query2btn").click(function(){		
		//Elimina las busqueda realizadas anteriormente. Con JQuery borra los elementos de la pagina
        $(".pagination li").remove();
		$(".pagination a").remove();
		$(".pagination img").remove();

		$(".big-image li").remove();
		$(".big-image a").remove();
		$(".big-image img").remove();
		
		$(".noResult h2").remove();
		
		//Realiza la busqueda en flickr
		//min_taken_date para la fecha minima de captura
        $.getJSON('https://api.flickr.com/services/rest/?method=flickr.people.getPhotos&api_key=' 
		+ api_key + '&user_id=' + user_id + '&nojsoncallback=1',
        {
            min_taken_date: $("#query2text").val(), 
            format: "json",
        },
		function(info){
			var i;
			var numPhotos=info.photos.photo.length;
			for (i=0;i<info.photos.photo.length;i++) {
				var item = info.photos.photo[i];
				var url = 'https://farm'+item.farm+".staticflickr.com/"+item.server+'/'+item.id+'_'+item.secret+'_s.jpg';
				var url_big = 'https://farm'+item.farm+".staticflickr.com/"+item.server+'/'+item.id+'_'+item.secret+'_b.jpg';
				console.debug(url);
								
				var imgList = "<li><a onclick="+"abrir_dialog("+i+","+numPhotos+")"+"> <img class='smallImg' src="+url+"></a></img></li>";
				$(".pagination").append(imgList);
				
				var imgList2 = "<li><img id=img"+i+" "+"class='bigImg' src="+url_big+"></img></li>";
				$(".big-image").append(imgList2);
			}
			if (i==0){
				$(".noResult").append("<h2> No se han encontrado imagenes en esa busqueda. </h2>");
			}
		});
    });
	
	//CONSULTA 3
	//MUESTRA LAS IMAGENES CON FECHA MAXIMA DE CAPTURA
	$("#query3btn").click(function(){		
		//Elimina las busqueda realizadas anteriormente. Con JQuery borra los elementos de la pagina
        $(".pagination li").remove();
		$(".pagination a").remove();
		$(".pagination img").remove();

		$(".big-image li").remove();
		$(".big-image a").remove();
		$(".big-image img").remove();
		
		$(".noResult h2").remove();
		
		////Realiza la busqueda en flickr
		//max_taken_date: para la fecha maxima de captura
        $.getJSON('https://api.flickr.com/services/rest/?method=flickr.people.getPhotos&api_key=' 
		+ api_key + '&user_id=' + user_id + '&nojsoncallback=1',
        {
            max_taken_date: $("#query3text").val(), 
            format: "json",
        },
		function(info){
			var i;
			var numPhotos=info.photos.photo.length;
			for (i=0;i<info.photos.photo.length;i++) {
				var item = info.photos.photo[i];
				var url = 'https://farm'+item.farm+".staticflickr.com/"+item.server+'/'+item.id+'_'+item.secret+'_s.jpg';
				var url_big = 'https://farm'+item.farm+".staticflickr.com/"+item.server+'/'+item.id+'_'+item.secret+'_b.jpg';
				console.debug(url);
								
				var imgList = "<li><a onclick="+"abrir_dialog("+i+","+numPhotos+")"+"> <img class='smallImg' src="+url+"></a></img></li>";
				$(".pagination").append(imgList);
				
				var imgList2 = "<li><img id=img"+i+" "+"class='bigImg' src="+url_big+"></img></li>";
				$(".big-image").append(imgList2);
			}
			if (i==0){
				$(".noResult").append("<h2> No se han encontrado imagenes en esa busqueda. </h2>");
			}
		});
    });
	
	//CONSULTA 4
	//MUESTRA LAS IMAGENES CON FECHA MINIMA DE SUBIDA
	$("#query4btn").click(function(){		
		//Elimina las busqueda realizadas anteriormente. Con JQuery borra los elementos de la pagina
        $(".pagination li").remove();
		$(".pagination a").remove();
		$(".pagination img").remove();

		$(".big-image li").remove();
		$(".big-image a").remove();
		$(".big-image img").remove();
		
		$(".noResult h2").remove();
		
		////Realiza la busqueda en flickr
		//min_upload_date: para la fecha minima de subida
        $.getJSON('https://api.flickr.com/services/rest/?method=flickr.people.getPhotos&api_key=' 
		+ api_key + '&user_id=' + user_id + '&nojsoncallback=1',
        {
            min_upload_date: $("#query4text").val(), 
            format: "json",
        },
		function(info){
			var i;
			var numPhotos=info.photos.photo.length;
			for (i=0;i<info.photos.photo.length;i++) {
				var item = info.photos.photo[i];
				var url = 'https://farm'+item.farm+".staticflickr.com/"+item.server+'/'+item.id+'_'+item.secret+'_s.jpg';
				var url_big = 'https://farm'+item.farm+".staticflickr.com/"+item.server+'/'+item.id+'_'+item.secret+'_b.jpg';
				console.debug(url);
								
				var imgList = "<li><a onclick="+"abrir_dialog("+i+","+numPhotos+")"+"> <img class='smallImg' src="+url+"></a></img></li>";
				$(".pagination").append(imgList);
				
				var imgList2 = "<li><img id=img"+i+" "+"class='bigImg' src="+url_big+"></img></li>";
				$(".big-image").append(imgList2);
			}
			if (i==0){
				$(".noResult").append("<h2> No se han encontrado imagenes en esa busqueda. </h2>");
			}
		});
    });
	
	//CONSULTA 5
	//MUESTRA LAS IMAGENES DEPENDIENDO DEL TIPO DE CONTENIDO: PHOTOS, SCREENSHOT
	$("#query5btn").click(function(){		
		//Elimina las busqueda realizadas anteriormente. Con JQuery borra los elementos de la pagina
        $(".pagination li").remove();
		$(".pagination a").remove();
		$(".pagination img").remove();

		$(".big-image li").remove();
		$(".big-image a").remove();
		$(".big-image img").remove();
		
		$(".noResult h2").remove();
		
		//Realiza la busqueda en flickr
		//content_type: para el tipo de contenido
        $.getJSON('https://api.flickr.com/services/rest/?method=flickr.people.getPhotos&api_key=' 
		+ api_key + '&user_id=' + user_id + '&nojsoncallback=1',
        {
            content_type: $("#query5text").val(), 
            format: "json",
        },
		function(info){
			var i;
			var numPhotos=info.photos.photo.length;
			for (i=0;i<info.photos.photo.length;i++) {
				var item = info.photos.photo[i];
				var url = 'https://farm'+item.farm+".staticflickr.com/"+item.server+'/'+item.id+'_'+item.secret+'_s.jpg';
				var url_big = 'https://farm'+item.farm+".staticflickr.com/"+item.server+'/'+item.id+'_'+item.secret+'_b.jpg';
				console.debug(url);
								
				var imgList = "<li><a onclick="+"abrir_dialog("+i+","+numPhotos+")"+"> <img class='smallImg' src="+url+"></a></img></li>";
				$(".pagination").append(imgList);
				
				var imgList2 = "<li><img id=img"+i+" "+"class='bigImg' src="+url_big+"></img></li>";
				$(".big-image").append(imgList2);
			}
			if (i==0){
				$(".noResult").append("<h2> No se han encontrado imagenes en esa busqueda. </h2>");
			}
		});	
    });
	
	//CONSULTA 6
	//MUESTRA LAS IMAGENES POR ETIQUETAS
	$("#query6btn").click(function(){		
		//Elimina las busqueda realizadas anteriormente. Con JQuery borra los elementos de la pagina
        $(".pagination li").remove();
		$(".pagination a").remove();
		$(".pagination img").remove();

		$(".big-image li").remove();
		$(".big-image a").remove();
		$(".big-image img").remove();
		
		$(".noResult h2").remove();
		
		//Realiza la busqueda en flickr
		//tags: para la etiqueta, coge el valor del txt de la pagina web
        $.getJSON('https://api.flickr.com/services/rest/?method=flickr.people.getPhotos&api_key=' 
		+ api_key + '&user_id=' + user_id + '&nojsoncallback=1',
        {
            tags: $("#query6text").val(), 
            format: "json",
        },
		function(info){
			var i;
			var numPhotos=info.photos.photo.length;
			for (i=0;i<info.photos.photo.length;i++) {
				var item = info.photos.photo[i];
				var url = 'https://farm'+item.farm+".staticflickr.com/"+item.server+'/'+item.id+'_'+item.secret+'_s.jpg';
				var url_big = 'https://farm'+item.farm+".staticflickr.com/"+item.server+'/'+item.id+'_'+item.secret+'_b.jpg';
				console.debug(url);
								
				var imgList = "<li><a onclick="+"abrir_dialog("+i+","+numPhotos+")"+"> <img class='smallImg' src="+url+"></a></img></li>";
				$(".pagination").append(imgList);
				
				var imgList2 = "<li><img id=img"+i+" "+"class='bigImg' src="+url_big+"></img></li>";
				$(".big-image").append(imgList2);
			}
			if (i==0){
				$(".noResult").append("<h2> No se han encontrado imagenes en esa busqueda. </h2>");
			}
		});	
    });
});

//Funcion para mostrar las imagenes en tamaño grande
//Recibe dos argumentos: 
//n: numero de la imagen a mostrar
//numPhotos: numero de fotos de la consulta para ocultarlas
function abrir_dialog(n,numPhotos) {
    for (i=0;i<numPhotos;i++) {
		document.getElementById('img'+i).style.display='none'; //Oculta las otras imagenes
	}
	document.getElementById('img'+n).style.width='800px'; //Le aplica un tamaño
	document.getElementById('img'+n).style.display='initial'; //Visualiza la imagen
};