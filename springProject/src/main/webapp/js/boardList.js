$(document).ready(function(){
	$.ajax({
		type : 'post',
		url : '/springProject/board/getBoardList',
		data : 'pg='+$('#pg').val(),
		// pg값을 갖고 있는 건 현재 controller
		dataType:'json',
		success : function(data){
			//alert(JSON.stringify(data));
		
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align :'center',
					text : items.seq
				})).append($('<td/>',{
					align : 'center',
					text : items.subject
				})).append($('<td/>',{
					align : 'center',
					text : items.id
				})).append($('<td/>',{
					align : 'center',
					text : items.logtime
				})).append($('<td/>',{
					align : 'center',
					text : items.hit
				})).appendTo($('#boardListTable'));
			});
		},
		error : function(err){
			console.log(err);
		}
	});
});
