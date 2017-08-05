
$('#myModal').on('hidden.bs.modal', function() {
    $('#form123').data('bootstrapValidator').destroy();
    $('#form123').data('bootstrapValidator', null);
    formValidator();
});
$(document).ready(function() {
    /**
     * 下面是进行插件初始化
     * 你只需传入相应的键值对
     * */
    formValidator();
});
function formValidator() {

    $('#form123').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {/*输入框不同状态，显示图片的样式*/
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {/*验证*/
            f01: {/*键名username和input name值对应*/
                message: 'The username is not valid',
                validators: {
                    notEmpty: {/*非空提示*/
                        message: '标题不能为空'
                    },
                    stringLength: {/*长度提示*/
                        min: 1,
                        max: 20,
                        message: '用户名长度必须在1到20之间'
                    }/*最后一个没有逗号*/,
                    remote:{
                        url: '/paper/validName',
                        message: '该标题已存在',
                        delay :  2000,
                        type:'POST'
                        // data: function(validator) {
                        //     return {
                        //         txt_name1:$('#txt_name1').val()
                        //     };
                        // },
                    }
                }
            }

        }
    });
}


