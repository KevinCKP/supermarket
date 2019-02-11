$(function () {
    $('#loginBtn').on('click',function () {
        staffId = $('#username').val();
        password = $('#password').val();
        $.ajax({
            type : 'POST',
            url : 'http://localhost:8080/login',
            data : {
                staffId : staffId,
                password : password
            },
            success : function (result) {
                if (result.code != 0){
                    alert(result.msg)
                } else {
                    alert("登录成功");
                    window.location.href = 'http://localhost:8080/welcome';
                }
            },
            error : function () {
                alert('服务器异常');
                return ;
            }
        });
    });
});