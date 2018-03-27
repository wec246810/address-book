//修改个人详情页，改为表格可编辑
function editStudentInfo() {
    console.log("editStudentInfo");
    // $(".myinfo").val(""); //设置
    $(".myinfo").attr("disabled", false);
}

function saveStudentInfo() {
    console.log("saveStudentInfo");
    // 点击保存，将数据发送到后台，然后刷新页面
    var student = {
        name: $("#student-name").val(),
        sid: $("#student-sid").val(),
        sex: $("#student-sex").val(),
        age: $("#student-age").val(),
        hobby: $("#student-hobby").val(),
        favoritePeople: $("#student-favoritePeople").val(),
        favoriteFood: $("#student-favoriteFood").val(),
        favoriteFruit: $("#student-favoriteFruit").val(),
        favoriteWords: $("#student-favoriteWords").val(),
        qq: $("#student-qq").val(),
        tel: $("#student-tel").val(),
        email: $("#student-email").val(),
        address: $("#student-address").val()
    }
    $.ajax({
        url: '/user/update-info',
        type: 'post',
        dataType: 'json',
        cache: false,
        data: JSON.stringify(student),
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            // alert("成功");
            // var str = data.username + data.age + data.job;
            // $("#result").html(str);
            alert("保存成功")
            location.reload();
        },
        complete: function (data) {
            // alert("complete");
        }

    });
    // $("#student-name").val() == '' ? $("#student-name").val($("#student-name").attr('placeholder')) : $("#student-name").val();
    // $("#student-name").val() == '' ? $("#student-name").val($("#student-name").attr('placeholder')) : $("#student-name").val();
    // $("#student-name").val() == '' ? $("#student-name").val($("#student-name").attr('placeholder')) : $("#student-name").val();
    // $("#student-name").val() == '' ? $("#student-name").val($("#student-name").attr('placeholder')) : $("#student-name").val();
    // $("#student-name").val() == '' ? $("#student-name").val($("#student-name").attr('placeholder')) : $("#student-name").val();
    // $("#student-name").val() == '' ? $("#student-name").val($("#student-name").attr('placeholder')) : $("#student-name").val();
    // $("#student-name").val() == '' ? $("#student-name").val($("#student-name").attr('placeholder')) : $("#student-name").val();
    // $("#student-name").val() == '' ? $("#student-name").val($("#student-name").attr('placeholder')) : $("#student-name").val();
    // $("#student-name").val() == '' ? $("#student-name").val($("#student-name").attr('placeholder')) : $("#student-name").val();
    // $("#student-name").val() == '' ? $("#student-name").val($("#student-name").attr('placeholder')) : $("#student-name").val();
    // $("#student-name").val() == '' ? $("#student-name").val($("#student-name").attr('placeholder')) : $("#student-name").val();
    // $("#student-name").val() == '' ? $("#student-name").val($("#student-name").attr('placeholder')) : $("#student-name").val();
    // $("#student-name").val() == '' ? $("#student-name").val($("#student-name").attr('placeholder')) : $("#student-name").val();
    $(".myinfo").attr("disabled", true);
}


function editTable(index) {
    //  $('#table').editableTableWidget();--效果是单击编辑按钮后，所有的都可以编辑
    // $(":checked").editableTableWidget();
    $(":checked").parent().parent().editableTableWidget();//整行的可以编辑
}
