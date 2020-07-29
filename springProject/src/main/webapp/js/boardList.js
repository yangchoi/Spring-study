$(document).ready(function(){
	$.ajax({
		type : 'post',
		url : '/springProject/board/getBoardList',
		data : 'pg='+$('#pg').val(),
		// pg값을 갖고 있는 건 현재 controller
		dataType:'json',
		success : function(data){
			//alert(JSON.stringify(data));
			// 페이징처리한 값들은 이 data에 들어가게됨 
			
			// for each는 화면에 뿌려주는 역할일 뿐
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.seq
				})).append($('<td/>',{
					}).append($('<a/>',{
						id : 'subjectA',
						href: '#',
						align: 'center',
						text: items.subject,
						class : items.seq
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
					for(i = 0; i <= items.lev; i++){
					$('.'+items.seq).before('&emsp;');
				}//for
				
				if(items.pseq != 0){
					$('.'+ items.seq).before($('<img/>', {
						src : '../image/reply.gif'
					}));
					// previous는 tag 앞으로 들어가는 것 
					// before : 내 앞으로 들어가는 것 
				}
				       
			}); // each
			
			// 페이징 처리 
			// mav의 boardPaging을 꺼내고 싶기 때문에 그 데이터를 가지고 있는 data 변수를 여기에 담는다.
			// 여기까지만 하면 객체값이 나온다. 
			// 따라서 pagingHTML 값이 필요하다 (뭔소린데...) 
			// 페이징 처리 
			$('#boardPagingDiv').html(data.boardPaging.pagingHTML); 
			// 텍스트로 뿌려주면 안된다. html로 뿌려줘야한다(css 땜에)
			
			// 로그인 여부 & 작성한 글 확인 
			// 동기식 처리 (동적 이벤트만)
			//$(부모).on(이벤트, 후손, function(){});
			$('#boardListTable').on('click', '#subjectA', function(){
				//alert($(this).prop('tagName'));
			
				if(data.memId == null){
					alert('로그인 먼저 하세요');
				}else {
					let seq = $(this).attr('class');
					let pg = data.pg;
					location.href='/springProject/board/boardView?seq='+seq+'&pg='+pg;
				}
				
			});
			
			 
		},
		error : function(err){
			console.log(err);
		}
	});
});

// 검색  
$('#boardSearchBtn').click(function(event, str){
					// trigger에서 하나씩 받아온다
	if(str != 'continue') $('input[name=pg]').val(1);
	
	if($('#keyword').val() == ''){
		// 검색값이 없다면 
		alert('검색어를 입력하세요');	
	}else {
		$.ajax({
			type : 'post',
			url : '/springProject/board/getBoardSearch',
			data : {'pg' : $('input[name=pg]').val(),
					'searchOption' : $('#searchOption').val(),
					'keyword' : $('#keyword').val()},
			dataType : 'json',
			success : function(data) {
				//alert(JSON.stringify(data));
				// 테이블 지우고들어가기 
				$('#boardListTable tr:gt(0)').remove();
				
				$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align :'center',
					text : items.seq
				})).append($('<td/>',{
				}).append($('<a/>',{
				
					id : 'subjectA',
					href: '#',
					align: 'center',
					text: items.subject,
					class : items.seq
				
				}))).append($('<td/>',{
					align : 'center',
					text : items.id
				})).append($('<td/>',{
					align : 'center',
					text : items.logtime
				})).append($('<td/>',{
					align : 'center',
					text : items.hit
				})).appendTo($('#boardListTable'));
				
				// 답글
				// 0이 아니면 답글이라는 뜻 
				for(i = 0; i <= items.lev; i++){
					$('.'+items.seq).before('&emsp;');
				}//for
				
				if(items.pseq != 0){
					$('.'+ items.seq).before($('<img/>', {
						src : '../image/reply.gif'
					}));
					// previous는 tag 앞으로 들어가는 것 
					// before : 내 앞으로 들어가는 것 
				}
				
			}); // each
			
			
			$('#boardPagingDiv').html(data.boardPaging.pagingHTML); 
				
			},
			error : function(err){
				console.log(err);
			}
		});
	}
});