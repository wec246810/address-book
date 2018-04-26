//编辑学生
function editStudent(infoTable) {
    console.log("editAdminDetailTable");
    $('#name' + infoTable).attr("contenteditable", true);
    $('#sex' + infoTable).attr("contenteditable", true);
    console.log("editAdminDetailTableend");
}

//保存学生
function saveStudent(infoTable) {
    console.log("saveStudent...")
    var student = {
        sid: $('#sid' + infoTable).text(),
        name: $('#name' + infoTable).text(),
        sex: $('#sex' + infoTable).text()
    }
    console.log(student)

    // $.put("/admin/update-student", JSON.stringify(student), function (data) {
    //     if (data.errorCode == 1) {
    //         $('#motai').html('修改成功！')
    //         $('#myModal').modal('show');
    //     } else if (data.errorCode == -1) {
    //         $('#motai').html('修改失败，请检查输入的数据！')
    //         $('#myModal').modal('show');
    //     } else {
    //         $('#motai').html('发生未知错误,请重试！')
    //         $('#myModal').modal('show');
    //     }
    // })

    $.ajax({
        url: '/admin/update-student',
        type: 'put',
        dataType: 'json',
        cache: false,
        data: JSON.stringify(student),
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            $('#motai').html(data.errMsg);
            $('#myModal').modal('show');
        }

    });


    $("#infoTable").attr("contenteditable", false);
}

//删除学生
function deleteStudent(sid) {
    console.log("deleteStudent...")
    if (confirm("是否确认删除")) {

        // $.delete("/admin/delete-student", JSON.stringify({'sid': sid}), function (data) {
        //     $('#motai').html(data.errMsg)
        //     $('#myModal').modal('show');
        // });
        $.ajax({
            url: '/admin/delete-student',
            type: 'delete',
            dataType: 'json',
            cache: false,
            data: JSON.stringify({'sid': sid}),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                    $('#motai').html(data.errMsg)
                    $('#myModal').modal('show');
            },
        });
    }
}

//增加学生
function addStudent(classesNum) {
    console.log("addStudent");
    var student = {
        sid: $('#addsid').text(),
        name: $('#addname').text(),
        sex: $('#addsex').text(),
        classesNum: classesNum

    }
    // $.post("/admin/add-student", JSON.stringify(student), function (data) {
    //     $('#motai').html(data.errMsg)
    //     $('#myModal').modal('show');
    // });


    $.ajax({
        url: '/admin/add-student',
        type: 'post',
        dataType: 'json',
        cache: false,
        data: JSON.stringify(student),
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            $('#motai').html(data.errMsg)
            $('#myModal').modal('show');
        }
    });
}