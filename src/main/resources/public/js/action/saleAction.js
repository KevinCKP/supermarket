// 售卖
function sale(){
    $.ajax({
        type : "POST",
        url : "http://localhost:8080/sale/add",
        data : {

        },
        success : function () {

        },
        error : function () {

        }
    })
}
// 输入商品id后显示商品信息
function getById(){
    var goodsId = $('#goodsId').val();
    $.ajax({
        type : "GET",
        url : "http://localhost:8080/goods/detail/" + goodsId,
        success : function () {
            // 在table中显示多一行数据
            // 每次添加后，总价格要改变
        },
        error : function () {

        }
    })

}
// 计算商品价格利润等

function toList(){

}