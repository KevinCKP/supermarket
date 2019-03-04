function addMember(){
    $.ajax({
        type : "POST",
        url : "http://localhost:8080/member/add",
        data : {
            memberId : $('#memberId').val(),
            memberAccount : $('#memberAccount').val(),
            memberName : $('#memberName').val(),
            memberPhone : $('#memberPhone').val(),
            memberSex : $('#memberSex').val(),
            memberDescription : $('#memberDescription').val()
        },
        success : function () {

        },
        error : function () {

        }
    })
}

function renderMemberData(member) {
    $("#memberId").val(member.memberId);
    $("#memberName").val(member.memberName);
    $("#memberPhone").val(member.memberPhone);
    $("input[name='sex']:checked").val(member.memberSex);
    $("#memberDescription").val(member.memberDescription);

}