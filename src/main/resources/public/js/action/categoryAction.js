function queryTopCategory(){
    $.ajax({
        url : "http://localhost:8080/categoty/to_list",
        type : "GET",
        success :function (result) {
            var data = result.data;
            var total = data.total;
            var pageNum = data.pageNum;
            var pageSize = data.pageSize;//页大小
            var categories = data.list;
            $("#categotryTbody").html("");
            for(var i = 0; i < categories.length; i++){
                (function (category) {
                    var index = (pageNum - 1) * pageSize + i + 1;
                    var tr = '<tr><td>' + category.categoryId + '</td>'
                            + '<td>'  + category.categoryName + '</td>'
                            + '<td>' + category.categoryNote + '</td></tr>';
                })(categories[i])
            }
            categoryPage(total,pageNum,pageSize);
        },
        error : function () {
            layer.msg("服务器异常");
        }
    })
}

function categoryPage(total,pageNum,pageSize) {
    layui.use(['laypage', 'layer'], function () {
        var laypage = layui.laypage, layer = layui.layer;

        //执行一个laypage实例
        laypage.render({
            elem: 'pageDiv', //注意，这里的 test1 是 ID，不用加 # 号
            count: total, //数据总数，从服务端得到
            limit: pageSize,//每页显示的条数。laypage将会借助 count 和 limit 计算出分页数。
            curr: pageNum,//当前页号
            limits: [6, 10, 15, 20],
            layout: ['limit', 'prev', 'page', 'next', 'skip', 'count'],//显示哪些分页组件
            jump: function (obj, first) {//点击页号的时候执行的函数
                //obj包含了当前分页的所有参数，比如：

                $("[name='pageNum']").val(obj.curr);//向隐藏域设置当前页的值
                $("[name='pageSize']").val(obj.limit);//向隐藏域设置当前页的大小
                if (!first) {//首次不执行(点击的时候才执行)
                    queryTopCategory();//执行查询分页函数(这个函数必须写在这里)
                }
            }
        });
    });
}

function topCategory_add() {
    var url = "/category/topCategory-add.html";
    layer_show1("编辑",url,800,500);
}
function layer_show1(title,url,w,h){
    if (title == null || title == '') {
        title=false;
    }
    if (url == null || url == '') {
        url="404.html";
    }
    if (w == null || w == '') {
        w=800;
    }
    if (h == null || h == '') {
        h=($(window).height() - 50);
    }
    layer.open({
        type: 2,
        area: [w+'px', h +'px'],
        fix: false, //不固定
        maxmin: true,
        shade:0.4,
        title: title,
        content: url,

    });
}