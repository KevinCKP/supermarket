$(function () {
    $()
})
function addGoods(){
    $.ajax({
        type : "POST",
        url : "http://localhost:8080/goods/add",
        data : {
            goodsId : $('#goodsId').val(),
            categoryId : $('#categoryId').val(),
            supplierId : $('#supplierId').val(),
            goodsName : $('#goodsName').val(),
            goodsBarcode : $('#goodsBarcode').val(),
            goodsSaleprice : $('#goodsSaleprice').val(),
            goodsSpecification : $('#goodsSpecification').val(),
            goodsMetricUnit : $('#goodsMetricUnit').val(),
            goodsBuyprice : $('#goodsBuyprice').val(),
            goodsMemprice : $('#goodsMemprice').val(),
            goodsDescription : $('#goodsDescription').val(),
            goodsProduceplace : $('#goodsProduceplace').val(),
            goodsCategory : $('#goodsCategory').val(),
            goodsSupplier : $('#goodsSupplier').val(),
            goodsMaterial : $('#goodsMaterial').val(),
            goodsBrand : $('#goodsBrand').val(),
            goodsState : 1
        },
        success : function (data){
            if (data.code != 0){
                layer.msg(data.msg,{icon:2,time:2000});
            } else {
                layer.msg("添加成功",{icon:1,time:2000});
            }
        },
        error : function () {
            layer.msg('服务器异常',{icon:2,time:2000});
        }
    })
};
function updateGoods(){
    $.ajax({
        type : "POST",
        url : "http://localhost:8080/goods/update",
        data : {
            goodsId : $('#goodsId').val(),
            categoryId : $('#categoryId').val(),
            supplierId : $('#supplierId').val(),
            goodsName : $('#goodsName').val(),
            goodsBarcode : $('#goodsBarcode').val(),
            goodsSaleprice : $('#goodsSaleprice').val(),
            goodsSpecification : $('#goodsSpecification').val(),
            goodsMetricUnit : $('#goodsMetricUnit').val(),
            goodsBuyprice : $('#goodsBuyprice').val(),
            goodsMemprice : $('#goodsMemprice').val(),
            goodsDescription : $('#goodsDescription').val(),
            goodsProduceplace : $('#goodsProduceplace').val(),
            goodsCategory : $('#goodsCategory').val(),
            goodsSupplier : $('#goodsSupplier').val(),
            goodsMaterial : $('#goodsMaterial').val(),
            goodsBrand : $('#goodsBrand').val(),
            goodsState : $('#goodsState').val()
        },
        success : function (data){
            if (data.code != 0){
                layer.msg(data.msg,{icon:2,time:2000});
            } else {
                layer.msg("修改成功",{icon:1,time:2000});
            }
        },
        error : function () {
            layer.msg('服务器异常',{icon:2,time:2000});
        }
    })

};
function updateGoodsState(){
    var goodsState = $('#goodsState').val();
    $.ajax({
        type : "POST",
        url : "http://localhost:8080/goods/update",
        data : {
            goodsId : $('#goodsId').val(),
            goodsState : goodsState
        },
        success : function (data){
            if (data.code != 0){
                layer.msg(data.msg,{icon:2,time:2000});
            } else {
                if (goodsState == 0){
                    layer.msg("已下架",{icon:1,time:2000});
                } else{
                    layer.msg("已上架",{icon:1,time:2000});
                }
            }
        },
        error : function () {
            layer.msg('服务器异常',{icon:2,time:2000});
        }
    })
};

function getGoodsById(){
    var goodsId = $('#goodsId').val();
    $.ajax({
        type : "GET",
        url : "http:localhost:8080/goods/detail/" + goodsId,
        success : function (data) {
            if (data.code != 0){

            } else {

            }
        },
        error :function () {
            alert("服务器异常");
        }
    })
}

// 进入页面时的查询
function getGoodsList(pageIndex){
    var pageNum = pageIndex
    $.ajax({
        type : 'GET',
        url : 'http://localhost:8080/goods/to_list',
        data: {
            pageNum : 0,
            pageSize : 10,
            orderby : "goodsCreateTime"
        },
        dataType : 'json',
        success : function (result) {
            // 渲染数据
            $.each(result.data.list)
        }

    })
}
// 条件查询
function getGoodsListByFactors(){

}
