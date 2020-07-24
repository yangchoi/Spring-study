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
	$('#nameCheckDiv').empty();
	$('#idCheckDiv').empty();
	$('#pwdCheckDiv').empty();
	$('#repwdCheckDiv').empty();
	
    if($('#name').val() == '') { // 이거는 id속성으로 해서 찾는거다
        $('#nameCheckDiv').text('이름을 입력하세요')
        $('#nameCheckDiv').css('color', 'red')
        $('#nameCheckDiv').css('font-size', '8pt')
        $('#nameCheckDiv').css('font-weight', 'bold')
        $('#name').focus();
    } else if($('#id').val() == ''){
    	$('#idCheckDiv').text('아이디를 입력하세요')
        $('#idCheckDiv').css('color', 'red')
        $('#idCheckDiv').css('font-size', '8pt')
        $('#idCheckDiv').css('font-weight', 'bold')
        $('#id').focus();
    } else if($('#pwd').val() == '') {
    	$('#pwdCheckDiv').text('비밀번호를 입력하세요')
        $('#pwdCheckDiv').css('color', 'red')
        $('#pwdCheckDiv').css('font-size', '8pt')
        $('#pwdCheckDiv').css('font-weight', 'bold')
        $('#pwd').focus();
    } else if($('#pwd').val() != $('#repwd').val()){
    	$('#repwdCheckDiv').text('비밀번호가 일치하지 않습니다')
        $('#repwdCheckDiv').css('color', 'red')
        $('#repwdCheckDiv').css('font-size', '8pt')
        $('#repwdCheckDiv').css('font-weight', 'bold')
        $('#repwd').focus();
    }else  {
    	$('form[name=writeForm]').submit();
    } 
 });
 
 
//회원가입 중복체크
$('#id').focusout(function(){
	$('#idCheckDiv').empty();
	
	let id = $('#id').val();
	if(id == ''){
		$('#idCheckDiv').text('먼저 아이디를 입력하세요')
		$('#idCheckDiv').css('color', 'magenta')
		$('#idCheckDiv').css('font-size', '8pt')
		$('#idCheckDiv').css('font-weight', 'bold')
		$('#id').focus();
	}else{
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/checkId',
			data: 'id='+$('#id').val(),
			dataType: 'text',
			success: function(data){
				//alert(data);
				
				if(data == '사용 가능'){
					$('#idDiv').text(data);
					$('#idDiv').css('font-size', '8pt');
					$('#idDiv').css('color', 'blue');
				}else{
					$('#idDiv').text(data);
					$('#idDiv').css('font-size', '8pt');
					$('#idDiv').css('color', 'red');
				}
				
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});

