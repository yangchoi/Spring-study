// 로그인 
$('#loginBtn').click(function(){
	$('div[id=idDiv]').empty();
	$('div[id=pwdDiv]').empty();
	
	if($('input[id=id]').val() == ''){
    	$('div[id=idDiv]').text('아이디를 입력하세요')
        $('div[id=idDiv]').css('color', 'red')
        $('div[id=idDiv]').css('font-size', '8pt')
        $('div[id=idDiv]').css('font-weight', 'bold')
        $('input[id=id]').focus();
    	
	}else if($('input[id=pwd]').val() == ''){
    	$('div[id=pwdDiv]').text('비밀번호를 입력하세요')
        $('div[id=pwdDiv]').css('color', 'red')
        $('div[id=pwdDiv]').css('font-size', '8pt')
        $('div[id=pwdDiv]').css('font-weight', 'bold')
        $('input[id=pwd]').focus();
	
	}else{
    	$.ajax({
    		type : 'post',
    		url : '/springProject/member/login',
    		data : {'id' : $('#loginId').val(),
    				'pwd' : $('#loginPwd').val()},
    		dataType : 'text',
    		success : function(data){
    			if(data == 'success'){
    				location.href = '/springProject/main/index';
    				
    			}else if(data == 'fail'){
    				location.href = '/springProject/main/index';
    				
    				$('#loginResultDiv').text('로그인 실패');
				   	$('#loginResultDiv').css('color', 'red')
			        $('#loginResultDiv').css('font-size', '8pt')
			        $('#loginResultDiv').css('font-weight', 'bold')
	
    			}
    		},
    		error : function(e){
				console.log(e);
			}
			
    	});
    }
});


// 회원가입
$('#writeBtn').click(function(){
	$('#writeNameCheckDiv').empty();
	$('#writeIdCheckDiv').empty();
	$('#writePwdCheckDiv').empty();
	$('#writeRepwdCheckDiv').empty();
	
    if($('#writeName').val() == '') { // 이거는 id속성으로 해서 찾는거다
        $('#writeNameCheckDiv').text('이름을 입력하세요')
        $('#writeNameCheckDiv').css('color', 'red')
        $('#writeNameCheckDiv').css('font-size', '8pt')
        $('#writeNameCheckDiv').css('font-weight', 'bold')
        $('#writeName').focus();
    } else if($('#writeId').val() == ''){
    	$('#writeIdCheckDiv').text('아이디를 입력하세요')
        $('#writeIdCheckDiv').css('color', 'red')
        $('#writeIdCheckDiv').css('font-size', '8pt')
        $('#writeIdCheckDiv').css('font-weight', 'bold')
        $('#writeId').focus();
    } else if($('#writePwd').val() == '') {
    	$('#writePwdCheckDiv').text('비밀번호를 입력하세요')
        $('#writePwdCheckDiv').css('color', 'red')
        $('#writePwdCheckDiv').css('font-size', '8pt')
        $('#writePwdCheckDiv').css('font-weight', 'bold')
        $('#writePwd').focus();
    } else if($('#writePwd').val() != $('#writeRepwd').val()){
    	$('#writeRepwdCheckDiv').text('비밀번호가 일치하지 않습니다')
        $('#writeRepwdCheckDiv').css('color', 'red')
        $('#writeRepwdCheckDiv').css('font-size', '8pt')
        $('#writeRepwdCheckDiv').css('font-weight', 'bold')
        $('#writeRepwd').focus();
    } else if($('#check').val() != $('#writeId').val()){
    	$('#writeIdCheckDiv').text('중복체크 하세요')
        $('#writeIdCheckDiv').css('color', 'magenta')
        $('#writeIdCheckDiv').css('font-size', '8pt')
        $('#writeIdCheckDiv').css('font-weight', 'bold')
        $('#writeId').focus();
    } else  {
    	$('#writeForm').submit();
    } 
 });
 
//회원가입 중복체크
$('#writeId').focusout(function(){
	$('#writeIdCheckDiv').empty();
	
	let id = $('#writeId').val();
	if(id == ''){
		$('#writeIdCheckDiv').text('먼저 아이디를 입력하세요')
		$('#writeIdCheckDiv').css('color', 'magenta')
		$('#writeIdCheckDiv').css('font-size', '8pt')
		$('#writeIdCheckDiv').css('font-weight', 'bold')
		$('#writeId').focus();
	}else{
		$.ajax({
			type: 'post',
			url: '/springProject/member/checkId',
			data: 'id='+$('#writeId').val(),
			dataType: 'text',
			success: function(data){
				
				if(data == 'non_exist'){
					$('#check').val($('#writeId').val());
					
					$('#writeIdCheckDiv').text("사용가능");
					$('#writeIdCheckDiv').css('font-size', '8pt');
					$('#writeIdCheckDiv').css('color', 'blue');
				}else{
					
					$('#writeIdCheckDiv').text("사용불가");
					$('#writeIdCheckDiv').css('font-size', '8pt');
					$('#writeIdCheckDiv').css('color', 'red');
				}
				
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});

// 회원가입 우편번호 
$('#zipcode').click(function(){
	$('#zipcode').empty();
	window.open("/springProject/member/checkPost", "", "width=600,height=600,scrollbars=yes");
	
	if($('#zipcode').val() == ''){
		$('#checkPostDiv').text('주소를 입력하세요')
		$('#checkPostDiv').css('color', 'magenta')
		$('#checkPostDiv').css('font-size', '8pt')
		$('#checkPostDiv').css('font-weight', 'bold')
	
	}
});

$('#postSearchBtn').click(function(){
	$('#sidoDiv').empty();
	$('#roadnameDiv').empty();
	
	if($('#sido').val()==''){
		$('#sidoDiv').text('시도 선택');
		$('#sidoDiv').css('color', 'red');
		$('#sidoDiv').css('font-size', '8px');
		$('#sidoDiv').css('font-weight', 'bold');
	}else if($('#sido').val() != '세종' && $('#sigungu').val()==''){
		$('#sigunguDiv').text('시군구 선택');
		$('#sigunguDiv').css('color', 'red');
		$('#sigunguDiv').css('font-size', '8pt');
		$('#sigunguDiv').css('font-weight', 'bold');
	}else if($('#roadname').val() == ''){
		$('#roadnameDiv').text('도로명 입력');
		$('#roadnameDiv').css('color', 'red');
		$('#roadnameDiv').css('font-size', '8pt');
		$('#roadnameDiv').css('font-weight', 'bold');
	}else{
		$.ajax({
			type: 'post',
			url: '/springProject/member/postSearch',
			data: $('#checkPostForm').serialize(),
			dataType: 'json',
			success : function(data){
				//console.log(JSON.stringify(data));
				
				$('#postTable tr:gt(2)').remove();
				
				$.each(data.list, function(index, items){
					let address = items.sido+' '
								+ items.sigungu+' '
								+ items.yubmyundong+' '
								+ items.ri+' '
								+ items.roadname+' '
								+ items.buildingname;
								
					address	= address.replace(/null/g, '');							
								
					$('<tr/>').append($('<td/>',{
						align: 'center',
						text: items.zipcode
					})).append($('<td/>',{
						colspan: '3'
						}).append($('<a/>',{
							href: '#',
							id: 'addressA',
							text: address
						}))
					).appendTo($('#postTable'));    
				});//each
				
				//a태그를 클릭했을 때
				$('a').click(function(){
					alert($(this).parent().prev().text());
					
					$('#zipcode', opener.document).val($(this).parent().prev().text());
					$('#addr1', opener.document).val($(this).text());
					$('#addr2', opener.document).focus();
					window.close();
				});
				
			},
			error: function(e){
				console.log(e);
			}
		});
	}
});

// 회원정보 수정
$('#modifyBtn').click(function(){
	$('#nameCheckDiv').empty();
	$('#pwdCheckDiv').empty();
	$('#repwdCheckDiv').empty();
	
    if($('#modifyName').val() == '') { // 이거는 id속성으로 해서 찾는거다
        $('#nameCheckDiv').text('이름을 입력하세요')
        $('#nameCheckDiv').css('color', 'red')
        $('#nameCheckDiv').css('font-size', '8pt')
        $('#nameCheckDiv').css('font-weight', 'bold')
        $('#modifyName').focus();
    } else if($('#modifyPwd').val() == '') {
    	$('#pwdCheckDiv').text('비밀번호를 입력하세요')
        $('#pwdCheckDiv').css('color', 'red')
        $('#pwdCheckDiv').css('font-size', '8pt')
        $('#pwdCheckDiv').css('font-weight', 'bold')
        $('#modifyPwd').focus();
    } else if($('#modifyPwd').val() != $('#modifyRepwd').val()){
    	$('#repwdCheckDiv').text('비밀번호가 일치하지 않습니다')
        $('#repwdCheckDiv').css('color', 'red')
        $('#repwdCheckDiv').css('font-size', '8pt')
        $('#repwdCheckDiv').css('font-weight', 'bold')
        $('#modifyRepwd').focus();
    } else  {
    	$.ajax({
    		type : 'post',
    		url : '/springProject/member/modify', 
    		data : $('#modifyForm').serialize(), // post에 있는거(form 안에 있는것) 다 가져감 (name 속성 안해주면 dto 안만들어주더라)
    		success : function(){
    			alert('회원 정보 수정 완료');
    			location.href='/springProject/main/index';
    		},
    		error : function(err){
    			console.log(err);
    		}
    	});
    } 
 });
 



