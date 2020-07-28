$(document).ready(function(){
	$.ajax({
		type : 'post',
		url : '/springProject/board/getBoardList',
		data: 'pg='+$('#pg').val(),
		dataType: 'json',
		success : function(data){
			//alert(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.seq
				})).append($('<td/>',{
					}).append($('<a/>',{
						id: 'subjectA',
						href: '#',
						align: 'center',
						text: items.subject,
						class: items.seq+''
					}))
				).append($('<td/>',{
					align: 'center',
					text: items.id
				})).append($('<td/>',{
					align: 'center',
					text: items.logtime
				})).append($('<td/>',{
					align: 'center',
					text: items.hit
				})).appendTo($('#boardListTable'));         
			}); //each
			
			//페이징 처리
			$('#boardPagingDiv').html(data.boardPaging.pagingHTML);
			
			//로그인 여부 & 작성한 글 확인
			$('#boardListTable').on('click', '#subjectA', function(){
				if(data.memId == null){
					alert('먼저 로그인하세요');
				}else{
					let seq = $(this).attr('class');
					let pg = data.pg;
					location.href = '/springProject/board/boardView?seq='+seq+'&pg='+pg;
				}
				
			});
			
		},
		error: function(err){
			console.log(err);
		}
	});
});


//검색
$('#boardSearchBtn').click(function(event, str){
	if(str != 'continue') $('input[name=pg]').val(1);
	
	if($('#keyword').val() == ''){
		alert('검색어를 입력하세요');
	}else{
		$.ajax({
			type : 'get',
			url : '/springProject/board/getBoardSearch',
			data: {'pg': $('input[name=pg]').val(),
				   'searchOption': $('#searchOption').val(),
				   'keyword': $('#keyword').val()},
			dataType: 'json',
			success : function(data){
				//alert(JSON.stringify(data));
				
				$('#boardListTable tr:gt(0)').remove();
					
				$.each(data.list, function(index, items){
					$('<tr/>').append($('<td/>',{
						align: 'center',
						text: items.seq
					})).append($('<td/>',{
						align: 'center',
						text: items.subject
					})).append($('<td/>',{
						align: 'center',
						text: items.id
					})).append($('<td/>',{
						align: 'center',
						text: items.logtime
					})).append($('<td/>',{
						align: 'center',
						text: items.hit
					})).appendTo($('#boardListTable'));         
				}); //each
				
				//페이징 처리
				$('#boardPagingDiv').html(data.boardPaging.pagingHTML);
			
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});
















